package com.yang.thelab.common;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 基本数据类
 * @author YJ.yang
 * @version $Id: BaseSO.java, v 0.1 2016年5月26日 下午4:43:21 dev Exp $
 */
public abstract class BaseSO {

    /**业务编号*/
    private String bizNO;
    /**创建时间*/
    private Date gmtCreate;
    /**修改时间*/
    private Date gmtModified;
    
    public String getBizNO() {
        return bizNO;
    }
    public void setBizNO(String bizNO) {
        this.bizNO = bizNO;
    }
    public Date getGmtCreate() {
        return gmtCreate;
    }
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtModified() {
        return gmtModified;
    }
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
