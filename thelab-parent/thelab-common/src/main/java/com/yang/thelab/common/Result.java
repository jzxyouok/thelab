package com.yang.thelab.common;

import java.util.List;
import java.util.Map;

import com.yang.thelab.common.exception.Prompt;

/**
 * 数据封装
 * 
 * @author YJ.yang
 * @version $Id: Result.java, v 0.1 2016年3月8日 下午7:15:39 dev Exp $
 */
public class Result<T> {
    /**结果码，正常情况为“1”*/
    private String              resuCode = "1";
    /**结果信息描述，正常情况下为空*/
    private String              resuDesc;
    /**指定字段错误*/
    private List<Prompt>        promptError;
    /**提示信息中的动态参数*/
    private Map<String, String> descParam;
    /**业务数据*/
    private T                   data;
    
    public Result() {
        super();
    }
    
    public static final Result<Void> defaultFail(){
        Result<Void> result = new Result<Void>();
        result.setResuCode("-1");
        return result;
    }

    public Result(T data) {
        super();
        this.data = data;
    }

    /**
     * @param resuCode
     * @param resuDesc
     */
    public Result(String resuCode, String resuDesc) {
        super();
        this.resuCode = resuCode;
        this.resuDesc = resuDesc;
    }
    
    public String getResuCode() {
        return resuCode;
    }
    public void setResuCode(String resuCode) {
        this.resuCode = resuCode;
    }
    public String getResuDesc() {
        return resuDesc;
    }
    public void setResuDesc(String resuDesc) {
        this.resuDesc = resuDesc;
    }
    public List<Prompt> getPromptError() {
        return promptError;
    }
    public void setPromptError(List<Prompt> promptError) {
        this.promptError = promptError;
    }
    public Map<String, String> getDescParam() {
        return descParam;
    }
    public void setDescParam(Map<String, String> descParam) {
        this.descParam = descParam;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    
    
}
