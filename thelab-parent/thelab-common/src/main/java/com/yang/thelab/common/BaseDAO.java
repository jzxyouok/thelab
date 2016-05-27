package com.yang.thelab.common;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yang.thelab.common.enums.SeqServiceKey;


/**
 * 
 * @author nibo
 * @version $NO: BaseDAO.java, v 0.1 2015年11月8日 上午12:18:06 nibo Exp $
 */
public abstract class BaseDAO<T extends BaseDO<?>> extends SqlMapClientDaoSupport
                             implements DAOInterface<T> {
    /**
     * 命名空间
     * @return
     */
    protected String getNameSpace() {
        return getSeqServiceKey().code();
    }

    protected abstract SeqServiceKey getSeqServiceKey();

    protected SequenceGenerate sequenceGenerate;

    public void insert(T obj) {
        if (StringUtils.isBlank(obj.getBizNO()) && getSeqServiceKey() != null) {
            obj.setBizNO(sequenceGenerate.getSeqNO(getSeqServiceKey()));
        }
        getSqlMapClientTemplate().insert(getNameSpace() + ".insert", obj);
    }

    public void insert2(T obj) {
        getSqlMapClientTemplate().insert(getNameSpace() + ".insert", obj);
    }

    public int update(T obj) {
        return getSqlMapClientTemplate().update(getNameSpace() + ".update", obj);
    }

    @SuppressWarnings("unchecked")
    public T getByKey(String key) {
        return (T) getSqlMapClientTemplate().queryForObject(getNameSpace() + ".getByKey", key);
    }
    
    @SuppressWarnings("unchecked")
    public List<T> getByKeyList(List<String> keyList) {
        if(CollectionUtils.isEmpty(keyList)){
            return null;
        }
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("bizNOList", keyList);
        return (List<T>) getSqlMapClientTemplate().queryForList(getNameSpace() + ".getByKeyList", param);
    }

    public T getByKeyForLock(String key) {
        return null;
    }

    public void setSequenceGenerate(SequenceGenerate sequenceGenerate) {
        this.sequenceGenerate = sequenceGenerate;
    }

}
