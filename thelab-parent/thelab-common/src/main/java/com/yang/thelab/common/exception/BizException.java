package com.yang.thelab.common.exception;
/**
 * @author YJ.yang
 * @version $Id: BizException.java, v 0.1 2015年12月27日 下午4:29:17 dev Exp $
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 9018203596613174000L;
    
    private BizCode code;
    public BizException() {
        super();
    }
   
    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public BizException(BizCode code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    
    public BizException(BizCode code,Throwable cause) {
        super(cause);
        this.code = code;
    }
    
    public BizException(BizCode code) {
        super(code.desc());
        this.code = code;
    }
    
    public BizException(BizCode code,String message) {
        super(message);
        this.code = code;
    }

    public BizCode getCode() {
        return code;
    }
}
