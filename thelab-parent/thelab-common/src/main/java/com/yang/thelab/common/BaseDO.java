package com.yang.thelab.common;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author YJ.yang
 * @version $Id: BaseDO.java, v 0.1 2016年5月26日 下午4:53:49 dev Exp $
 */
public abstract class BaseDO<T extends BaseSO> {

    protected T prop;
    
    public BaseDO(){
    }
    
    public BaseDO(T prop) {
        this.prop = prop;
    }

    public String getBizNO(){
        return prop.getBizNO();
    }
    
    public void setBizNO(String bizNO){
        prop.setBizNO(bizNO);
    }
    
    /**
     * ibatis属性赋值会用到，而且无法统一使用父类的泛型直接实现
     * @return
     */
    public abstract T getProp();

    /**
     * ibatis属性赋值会用到，而且无法统一使用父类的泛型直接实现
     * @return
     */
    public abstract void setProp(T prop);
    
    public void set(T prop){
        setProp(prop);
    }
    
    public T get(){
        return this.prop;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
