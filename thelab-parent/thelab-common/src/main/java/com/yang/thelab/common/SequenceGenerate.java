/**
 * Yixiu.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.yang.thelab.common;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.yang.thelab.common.dataobj.SeqDO;
import com.yang.thelab.common.enums.DateFormatEnum;
import com.yang.thelab.common.enums.SeqServiceKey;
import com.yang.thelab.common.utils.DateUtil;


/**
 * @author nibo
 * @version $Id: SequenceGenerate.java, v 0.1 2015年11月12日 下午10:30:38 nibo Exp $
 */
public final class SequenceGenerate extends SqlMapClientDaoSupport {

    private TransactionTemplate    transactionTemplate;

    private ThreadPoolTaskExecutor executor;

    /**
     * 加锁获取数据
     * @param key
     * @return
     */
    private SeqDO getByKey4Lock(String key) {
        return (SeqDO) getSqlMapClientTemplate().queryForObject("SEQ.getByKey4Lock", key);
    }

    private SeqDO getByKey(String key) {
        return (SeqDO) getSqlMapClientTemplate().queryForObject("SEQ.getByKey", key);
    }

    private void insert(String key) {
        SeqDO seq = new SeqDO();
        seq.setKey(key);
        getSqlMapClientTemplate().insert("SEQ.insert", seq);
    }

    private void inc(String key, int step) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("key", key);
        param.put("step", step);
        getSqlMapClientTemplate().update("SEQ.inc", param);
    }

    /**重置SEQ*/
    private void reset(String key) {
        int count = getSqlMapClientTemplate().update("SEQ.reset", key);
        if (count == 0) {
        }
    }

    private class Work implements Runnable {
        private SeqRes ser;

        public Work(SeqRes ser) {
            this.ser = ser;
        }

        public void run() {
            try {
                transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus status) {
                        SeqDO seq = getByKey4Lock(ser.key.code());
                        if (seq == null) {
                            //初始化序列值数据
                            insert(ser.key.code());
                            seq = getByKey4Lock(ser.key.code());
                        }
                        //时间版本于当前日期不同
                        if (seq.getVersion().compareTo(seq.getNow()) != 0) {
                            //序列号清0
                            reset(ser.key.code());
                            //查询重新check值
                            SeqDO newSeq = getByKey(ser.key.code());
                            if (newSeq.getNow().compareTo(seq.getNow()) != 0) {
                                throw new RuntimeException("生成序列号发生未知异常");
                            }
                            seq = newSeq;
                        }
                        //更新序列号
                        inc(ser.key.code(), ser.step);
                        List<String> res = ser.seqList;
                        for (int i = 1; i <= ser.step; i++) {
                            res.add(genSeqNO(seq.getVersion(), seq.getValue() + i) + ser.key.shortName());
                        }
                    }
                });
            } catch (Throwable throwable) {
                ser.e = throwable;
            } finally {
                ser.latch.countDown();
            }
        }
    }

    public List<String> getSequenceValue(int step, SeqServiceKey key) {
        //需要起线程独立完成，保证序列号生成的独立性
        SeqRes ser = new SeqRes(step, key);
        executor.execute(new Work(ser));
        try {
            ser.latch.await();
            if (ser.e != null) {
                if (ser.e instanceof RuntimeException) {
                    throw (RuntimeException) ser.e;
                }
                throw new RuntimeException(ser.e);
            }
        } catch (InterruptedException e) {
            //TODO 
            throw new RuntimeException("");
        }
        return ser.seqList;
    }

    private final class SeqRes {
        private Throwable      e;
        private CountDownLatch latch   = new CountDownLatch(1);;
        private List<String>   seqList = new ArrayList<String>();
        private int            step;
        private SeqServiceKey  key;

        public SeqRes(int step, SeqServiceKey key) {
            super();
            this.step = step;
            this.key = key;
        }
    }

    private String genSeqNO(Date version, long value) {
        String vs = value + "";
        return DateUtil.dateFormat(version, DateFormatEnum.DT_SHORT)
               + "000000".substring(0, 6 - vs.length()) + vs;
    }

    public String getSeqNO(SeqServiceKey key) {
        return getSequenceValue(1, key).get(0);
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setExecutor(ThreadPoolTaskExecutor executor) {
        this.executor = executor;
    }
}
