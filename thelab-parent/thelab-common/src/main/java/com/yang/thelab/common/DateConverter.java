/**
 * Yixiu.com Inc.
 * Copyright (c) 2015-2015 All Rights Reserved.
 */
package com.yang.thelab.common;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
/**
 * 
 * @author YJ.yang
 * @version $Id: DateConverter.java, v 0.1 2015年12月27日 上午10:50:58 dev Exp $
 */
public class DateConverter implements Converter<String,Date> {

    public Date convert(String source) {
        return new Date(Long.valueOf(source));
    }

}
