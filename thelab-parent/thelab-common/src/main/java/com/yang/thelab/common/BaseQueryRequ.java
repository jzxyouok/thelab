package com.yang.thelab.common;

/**
 * 
 * @author YJ.yang
 * @version $Id: BaseQueryRequ.java, v 0.1 2016年3月11日 上午10:53:48 dev Exp $
 */
public abstract class BaseQueryRequ<T extends BaseSO> extends PageRequ{

    protected T prop;

    public BaseQueryRequ(){
    }
    
    public BaseQueryRequ(T prop) {
        this.prop = prop;
    }
    
    public abstract T getProp();

    public abstract void setProp(T prop);

    /**快速获取属性值*/
    public T get() {
        return prop;
    }

    /**快速设置属性值*/
    public void set(T prop) {
        this.prop = prop;
    }

    
}
