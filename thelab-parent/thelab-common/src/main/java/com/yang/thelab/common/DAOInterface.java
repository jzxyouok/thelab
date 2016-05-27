/**
 * Yixiu.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.yang.thelab.common;
import java.util.List;

/**
 * 
 * @author nibo
 * @version $NO: DAOInterface.java, v 0.1 2015年11月8日 上午12:20:01 nibo Exp $
 */
@SuppressWarnings("rawtypes")
public interface DAOInterface<T extends BaseDO> {
    /**
     * 通用insert
     * 
     * @param obj
     */
    void insert(T obj);

    /**
     * 
     * 通过主键查询数据实体
     * @param key
     * @param ipNO
     * @param tntInstNO
     * @return
     */
    T getByKey(String key);
    
    /**
     * 
     * 通过主键查询数据实体
     * @param key
     * @param ipNO
     * @param tntInstNO
     * @return
     */
    List<T> getByKeyList(List<String> key);
    
    /**
     * 
     * 通过主键查询数据实体
     * @param key
     * @param ipNO
     * @param tntInstNO
     * @return
     */
    int update(T obj);

    /**
     * 
     * 通过主键查询数据实体,并加锁
     * @param key
     * @param ipNO
     * @param tntInstNO
     * @return
     */
    T getByKeyForLock(String key);
    
    

}

