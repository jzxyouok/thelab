package com.yang.thelab.common;

import javax.validation.Valid;

/**
 * 
 * @author nibo
 * @version $Id: BaseModel.java, v 0.1 2015年11月15日 上午12:22:08 nibo Exp $
 */
public abstract class BaseModel<T extends BaseSO> {
    @Valid
    protected T prop;

    public BaseModel(T prop) {
        this.prop = prop;
    }
    

    public BaseModel() {
    }

    public T get() {
        return prop;
    }

    public void set(T prop) {
        this.prop = prop;
    }

    public T getProp() {
        return prop;
    }

    public void setProp(T prop) {
        this.prop = prop;
    }

    public String getBizNO() {
        return prop.getBizNO();
    }

    public void setBizNO(String bizNO) {
        prop.setBizNO(bizNO);
    }
}
