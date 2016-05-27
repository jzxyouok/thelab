/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.yang.thelab.common.exception;
/**
 * 
 * @author bo.nib
 * @version $Id: DateException.java, v 0.1 2015年10月30日 上午12:12:29 bo.nib Exp $
 */
public class DateException extends RuntimeException{

    /**  */
    private static final long serialVersionUID = 6231414430929433010L;

    public DateException(String message) {
        super(message);
    }
    
    public DateException(String message,Throwable e) {
        super(message,e);
    }
}
