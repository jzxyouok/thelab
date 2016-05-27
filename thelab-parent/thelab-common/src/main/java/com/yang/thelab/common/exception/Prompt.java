package com.yang.thelab.common.exception;
/**
 * 提示信息
 * @author YJ.yang
 * @version $Id: Prompt.java, v 0.1 2016年3月8日 下午7:14:06 dev Exp $
 */
public class Prompt {
    /**字段名称*/
    private String fileName;
    /**信息内容*/
    private String msg;
    
    public Prompt(String fileName, String msg) {
        super();
        this.fileName = fileName;
        this.msg = msg;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
