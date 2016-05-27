package com.yang.thelab.common.exception;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author YJ.yang
 * @version $Id: BizCode.java, v 0.1 2015年12月27日 下午6:27:56 dev Exp $
 */
public enum BizCode implements EnumInterface {

	/** 系统异常 */
	SYS_EXCE("SYS_EXCE", "系统异常", "系统异常"),
	/** 参数校验异常 */
	PARAM_CHECK("PARAM_CHECK", "参数校验异常", "参数校验异常"),
	/** 唯一性主键冲突*/
	DUPLICATE_KEY("DUPLICATE_KEY","唯一性主键冲突","唯一性主键冲突"),
	/** 状态校验异常*/
	STATUS_CHECK("STATUS_CHECK","状态校验异常","状态校验异常"),
	
	//===用户======
	/**该用户昵称已经存在*/
	CUST_NICKNAME_EXSIT("CUST_NICKNAME_EXSIT","该用户昵称已经存在"),
	/**该手机号码已经被使用*/
    CUST_MOBILE_EXSIT("CUST_MOBILE_EXSIT","该手机号码已经被使用"),
    /**该工号（学号）已经存在*/
    CUST_EXTNO_EXSIT("CUST_NICKNAME_EXSIT","该工号（学号）已经存在"),
    /** 找不到用户 */
    CUST_NOT_FOUND("CUST_NOT_FOUND", "哎呀！你还不是用户！"),
    /** 匹配不到人的信息*/
    PERSON_NOT_FOUND("PERSON_NOT_FOUND","查无此人！"),
    /** 身份证号码已被使用*/
    PERSON_ID_CARD_NO_EXSIT("PERSON_ID_CARD_NO_EXSIT","这个真的是你自己的身份证么！"),
    /** 用户名或密码错误*/
    CUST_LOGIN_FAIL("CUST_LOGIN_FAIL","用户名或密码错误"),
    /** 登录信息不能为空*/
    LOGIN_INFO_BLANK("LOGIN_INFO_BLANK","登录信息不能为空"),
	
    //====枚举项===
	/**该项内容已经存在*/
    ENUM_ITEM_CONTENT_EXSIT("ENUM_ITEM_CONTENT_EXSIT","不好意思哦！此内容已经存在咯！"),
    /**枚举项内容不能为空*/
    ENUM_ITEM_CONTENT_BLANK("ENUM_ITEM_CONTENT_BLANK","你忘记输入内容了！"),
    
    //====学校====
    /**此学校已经存在*/
    SCHOOL_NAME_EXSIT("SCHOOL_NAME_EXSIT","学校已经存在了!"),
    /**学校名称不能为空*/
    SCHOOL_NAME_BLANK("SCHOOL_NAME_BLANK","忘记输入学校名称了！"),
    /**学校类型不能为空*/
    SCHOOL_TYPE_BLANK("SCHOOL_TYPE_BLANK","忘记输入学校类型了！"),
    /**学校代码不能为空*/
    SCHOOL_CODE_BLANK("SCHOOL_CODE_BLANK","忘记输入学校代码了！"),
    /**学校代码已经存在了*/
    SCHOOL_CODE_EXSIT("SCHOOL_CODE_EXSIT","学校代码已经存在了！"),
    // =======预约单=======
    /**预约时间有误*/
    RESERVE_DATE_FAULT("RESERVE_DATE_FAULT","预约时间有误"),
    /**时间顺序有误*/
    DATE_SEQ_WRONG("DATE_SEQ_WRONG","开始时间不能比结束时间晚"),
    /**预约时间的已经过了*/
    DATE_HAD_PASS("DATE_HAD_PASS","预约时间的已经过了"),
    /**你有一个预约单还未完成，请不要重复预约*/
    RESERVE_REPEAT("RESERVE_REPEAT","你有一个预约单还未完成，请不要重复预约"),
    /***预约时间过短*/
    RESERVE_DATE_IS_SHORT("RESERVE_DATE_IS_SHORT","预约时间过短"),
    /**你有段时间已经被预约*/
    RESERVE_PIECE_HAD_EXIST("RESERVE_PIECE_HAD_EXIST","你有段时间已经被预约"),
    //---------
    
	// =======注册登录=======
	/** 未登录 */
	NOT_LOGIN("NOT_LOGIN", "未登录", "未登录"),
	/** 请登陆 */
	LOGIN_TOKEN_IS_EMPTY("LOGIN_TOKEN_IS_EMPTY", "请登陆", "请登陆"),
	/** 请登陆 */
	LOGIN_DATA_EXCE("LOGIN_DATA_EXCE", "token失效", "token失效"),
	/** 找不到用户 */
	MOBILE_NOT_REF_DEPA("MOBILE_NOT_REF_DEPA", "用户不存在", "用户不存在"),
	/** 密码格式有误 */
	PASSWORD_WRONG_FROMAT("PASSWORD_WRONG_FROMAT", "密码格式有误", "密码格式有误"),
	/** 无权限 */
	MISS_PERMISSION("MISS_PERMISSION", "无权限访问", "无权限访问"),
	/** 验证码错误 */
	CODE_FAIL("CODE_FAIL", "验证码错误", "验证码错误"),
	/** 未获取验证码 */
	CODE_NOT_FOUND("CODE_NOT_FOUND", "请先获取验证码", "请先获取验证码"),
	/** 验证码失效 */
	CODE_LOSE_EFFICACY("CODE_LOSE_EFFICACY", "验证码失效", "验证码失效"),
	/** 邀请码失效 */
	INVITE_CODE_USED("INVITE_CODE_USED", "邀请码失效", "邀请码失效"),
	/** 邀请码不存在 */
	INVITE_CODE_NOT_FOUND("INVITE_CODE_NOT_FOUND", "邀请码不存在", "邀请码不存在"),
	/** 无邀请码 */
	NO_INVITE_CODE("NO_INVITE_CODE", "无邀请码", "无邀请码"),
	/** 用户已经存在无法注册 */
	CANT_GET_CODE("CANT_GET_CODE", "用户已经存在无法注册", "用户已经存在无法注册"),
	/** 该用户不是工程师 */
	NOT_AS_ENGINEER("NOT_A_ENGINEER", "该用户还未认证为工程师", "该用户还未认证为工程师"),





	// =======顾客=========
	/** 该手机号码已经被使用 */
	CUSTOMER_MOBILE_EXISIT("CUSTOMER_MOBILE_EXISIT", "该手机号码已经被使用"),
	/** 请输入正确的手机号 */
	CUSTOMER_MOBILE_NO_ILLEGAL("CUSTOMER_ILLEGAL_MOBILE_NO", "请输入正确的手机号"),

	;
	private String code;

	private String desc;

	private String defaultMsg;

	private String[] defMsg;

	private BizCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private BizCode(String code, String desc, String defaultMsg,
			String... defMsg) {
		this.code = code;
		this.desc = desc;
		this.defaultMsg = defaultMsg;
		this.defMsg = defMsg;
	}

	public String code() {
		return code;
	}

	public String desc() {
		return desc;
	}

	public String getDefaultMsg() {
		return defaultMsg;
	}

	public String[] getDefMsg() {
		return defMsg;
	}
}
