/**
 * Yixiu.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.yang.thelab.common.dataobj;
import java.util.Date;

/**
 * 
 * @author nibo
 * @version $Id: SeqDO.java, v 0.1 2015年11月12日 下午11:17:26 nibo Exp $
 */
public class SeqDO {
    /***/
    private String key;
    /**数值*/
    private Long   value;
    /**数据时间戳版本，用于每日数据清0*/
    private Date   version;
    /**当前时间*/
    private Date   now;

    public Long getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
}
