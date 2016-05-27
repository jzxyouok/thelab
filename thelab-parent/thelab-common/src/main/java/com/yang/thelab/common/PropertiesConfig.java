package com.yang.thelab.common;

import java.util.Properties;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * @author YJ.yang
 *@version $Id: PropertiesConfig.java, v 0.1 2016年3月8日 下午8:15:39 wztw Exp $
 */
public class PropertiesConfig extends PropertyPlaceholderConfigurer implements
		InitializingBean {

	private static Logger     LOG   = LoggerFactory.getLogger(PropertiesConfig.class);

    private boolean           print = false;

    private static Properties properties;

    public static String get(String key) {
        String value = properties.getProperty(key);
        return value == null ? null : value.trim();
    }

    public void afterPropertiesSet() throws Exception {
        properties = this.mergeProperties();
        if (!print) {
            return;
        }
        if (properties == null) {
            return;
        }
        StringBuffer log = new StringBuffer("\r\n======加载属性配置开始=====\r\n");
        for (Entry<Object, Object> entry : properties.entrySet()) {
            log.append(entry.getKey() + " = " + entry.getValue() + "\r\n");
        }
        log.append("======加载属性配置结束=====");
        LOG.info(log.toString());
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

}
