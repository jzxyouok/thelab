package com.yang.thelab.common;
import javax.validation.Valid;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 
 * @author nibo
 * @version $NO: BaseDO.java, v 0.1 2015年11月8日 上午12:12:23 nibo Exp $
 */
public abstract class BaseDTO<T> {
    /**属性*/
    @Valid
    protected T prop;

    public BaseDTO(T prop) {
        this.prop = prop;
    }
  
    public BaseDTO() {
        
    }

    public T getProp(){
        return this.prop;
    }

    public void setProp(T prop){
        this.prop = prop;
    }

    /**
     * 获取基础属性快捷方式
     * @return
     */
    public T get() {
        return prop;
    }

    /**
     * 设置基础属性快捷方式
     * @return
     */
    public void set(T prop) {
        setProp(prop);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
