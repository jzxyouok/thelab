/**
 * Yixiu.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author nibo
 * @version $Id: SeqServiceKey.java, v 0.1 2015年11月12日 下午11:15:16 nibo Exp $
 */
public enum SeqServiceKey implements EnumInterface {
    /**用户*/
    CUSTOMER("CUSTOMER", "用户", "CR"),
    /**人*/
    PERSON("PERSON","人","PR"),
    /**枚举项*/
    ENUM_ITEM("ENUM_ITEM","枚举项","EI"),
    /**班级*/
    CLASSES("CLASSES","班级","CL"),
    /**学校*/
    SCHOOL("SCHOOL","学校","SH"),
    /**实验室*/
    LABORATORY("LABORATORY","实验室","LB"),
    /**预约单*/
    RESERVE("RESERVE","预约单","RS"),
    /**预约执行单*/
    RESERVE_EXEC("RESERVE_EXEC","预约执行单","RE"),
    /**学院*/
    SH_INSTITUTE("SH_INSTITUTE","学院","SI"),
    /**专业*/
    SH_MAJOR("SH_MAJOR","专业","SJ"),
    /**实验室座位*/
    LAB_SITE("LAB_SITE","实验室座位","LS"),
    ;
    private String code;
    private String desc;
    private String shortName;

    private SeqServiceKey(String code, String desc, String shortName) {
        this.code = code;
        this.desc = desc;
        this.shortName = shortName;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    public String shortName() {
        return shortName;
    }

}
