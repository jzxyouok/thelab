package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author nibo
 * @version $Id: DateFormatEnum.java, v 0.1 2015年10月29日 下午11:52:23 nibo Exp $
 */
public enum DateFormatEnum implements EnumInterface {

    /**yyyy-MM-dd HH:mm:ss*/
    SIMPLE("yyyy-MM-dd HH:mm:ss", ""),

    /**yyyy年MM月dd日*/
    DT_SIMPLE_CHINESE("yyyy年MM月dd日", ""),

    /**yyyy-MM-dd*/
    DT_SIMPLE("yyyy-MM-dd", ""),

    /**yyyyMMdd*/
    DT_SHORT("yyyyMMdd", ""),

    /**yyyyMMddHHmmss*/
    DT_LONG("yyyyMMddHHmmss", ""),

    /**HH:mm:ss*/
    HMS("HH:mm:ss", ""),

    /**yyyy-MM-dd HH:mm*/
    SIMPLE_NO_S("yyyy-MM-dd HH:mm", ""),

    /**yyyyMMddHHmmssS*/
    DT_LONG_MILL("yyyyMMddHHmmssS", ""),

    ;
    private String code;

    private String desc;

    private DateFormatEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

}
