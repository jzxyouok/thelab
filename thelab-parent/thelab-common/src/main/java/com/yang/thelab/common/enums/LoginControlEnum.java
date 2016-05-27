package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * 
 * @author YJ.yang
 * @version $Id: LoginControlEnum.java, v 0.1 2016年3月17日 下午3:23:31 dev Exp $
 */
public enum LoginControlEnum implements EnumInterface {
	/**主页面*/
    INDEX_PAGE("/indexpage", "主页面", "index"),
	
    /**测试页面*/
    TEST_PAGE("/testPage", "测试页面", "testPage"),
    //----登录-----
    /**登录页*/
    LOGIN_1("/", "登录页面", "login"),
    /**登录页*/
    LOGIN_2("/login", "登录页面", "login"),
    /**登录页*/
    LOGIN_3("/login.htm", "登录页面", "login"),
    /**temp*/
    TEMP_PAGE("/temp","temp","temp"),
    ;

    private String code;
    private String desc;
    private String mapStr;

    private LoginControlEnum(String code, String desc, String mapStr) {
        this.code = code;
        this.desc = desc;
        this.mapStr = mapStr;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    public String mapStr() {
        return mapStr;
    }
}
