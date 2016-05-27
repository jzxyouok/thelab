package com.yang.thelab.common.enums;

import java.util.ArrayList;
import java.util.List;

import com.yang.thelab.common.EnumInterface;
import com.yang.thelab.common.exception.BizCode;

/**
 * 唯一性约束枚举
 * 
 * @author YJ.yang
 * @version $Id: UniqueEnum.java, v 0.1 2016年3月10日 下午6:45:56 dev Exp $
 */
public enum UniqueEnum implements EnumInterface {
    /**默认唯一性冲突*/
    UQ_DEFAULT("uq_default","默认唯一性冲突",BizCode.DUPLICATE_KEY),
    
    /** 用户的昵称唯一约束 */
    UQ_CR_NICKNMAE("uq_cr_nickname", "用户的昵称唯一约束", BizCode.CUST_NICKNAME_EXSIT),
    /** 用户的手机号码唯一约束 */
    UQ_CR_MOBILE("uq_cr_mobile", "用户的手机号码唯一约束", BizCode.CUST_MOBILE_EXSIT),
    /** 用户的学好（工号）唯一约束 */
    UQ_CR_EXTNO("uq_cr_extNO", "用户的学好（工号）唯一约束", BizCode.CUST_EXTNO_EXSIT),
    /** 身份证号码已被使用*/
    UQ_PR_IDCARDNO("uq_pr_idcardno","身份证号码已被使用",BizCode.PERSON_ID_CARD_NO_EXSIT),
    /** 枚举内容同一类型唯一冲突*/
    UQ_EI_CONT_TYPE("uq_ei_cont_type","枚举内容同一类型唯一冲突",BizCode.ENUM_ITEM_CONTENT_EXSIT),
    /** 学校名称唯一性约束*/
    UQ_SH_NAME("uq_sh_name","学校名称唯一性约束",BizCode.SCHOOL_NAME_EXSIT),
    /** 学校代码唯一性约束*/
    UQ_SH_CODE("uq_sh_code","学校代码唯一性约束",BizCode.SCHOOL_CODE_EXSIT),
    ;

    private String                 code;
    private String                 desc;
    private BizCode                bizCode;

    public static List<UniqueEnum> ENUM_LIST = new ArrayList<UniqueEnum>();

    static {
        for (UniqueEnum uniqueEnum : UniqueEnum.values()) {
            ENUM_LIST.add(uniqueEnum);
        }
    }

    private UniqueEnum(String code, String desc, BizCode bizCode) {
        this.code = code;
        this.desc = desc;
        this.bizCode = bizCode;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    public BizCode bizCode() {
        return bizCode;
    }
}
