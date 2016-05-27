package com.yang.thelab.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
/**
 * 
 * @author YJ.yang
 * @version $Id: BaseController.java, v 0.1 2016年3月8日 下午7:20:26 dev Exp $
 */
public abstract class BaseController {

    protected Logger            LOG          = LoggerFactory.getLogger(this.getClass());
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    public static <T> void toResponse(HttpServletResponse response, T obj) {
        Result<T> result = new Result<T>();
        result.setData(obj);
        toResponse(response, result);
    }

    public static <T> void toResponse(HttpServletResponse response, Result<T> result) {
        String jsonStr = JSON.toJSONString(result,
            SerializerFeature.DisableCircularReferenceDetect);
        try {
            response.setContentType(CONTENT_TYPE);
            response.addHeader("Access-Control-Allow-Origin", "http://dev.yixiuservice.net:3000");
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.getWriter().println(jsonStr);
        } catch (IOException e) {

        } finally {
            //try {
            //response.getWriter().close();
            //} catch (IOException e) {
            //}
        }
    }
    
    public static void toResponse(HttpServletResponse response) {
        toResponse(response, "");
    }

}
