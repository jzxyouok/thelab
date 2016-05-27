package com.yang.thelab.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.Result;

/**
 * 
 * @author YJ.yang
 *@version $Id: MyHandlerExceptionResolver.java, v 0.1 2016年3月8日 下午8:20:39 wztw Exp $
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
	
	 private static final Logger LOG = LoggerFactory.getLogger(MyHandlerExceptionResolver.class);

	    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
	                                         Object handler, Exception ex) {
	        Result<Void> result = Result.defaultFail();
	        String log = "请求地址(" + request.getRequestURI() + ")，请求参数(" + JSON.toJSONString(request.getParameterMap()) + ")";
	        // 根据不同错误转向不同页面  
	        if (ex instanceof ValidException) {
	            ValidException vException = (ValidException) ex;
	            //result.setPromptError(vException.getPromptList());  
	            log += "。验证失败，" + JSON.toJSONString(vException.getPromptList());
	            result.setResuCode(BizCode.PARAM_CHECK.code());
	            String desc = "";
	            for(Prompt prompt : vException.getPromptList()){
	                desc += prompt.getMsg() + ",";
	            }
	            desc += "参数校验异常";
	            result.setResuDesc(desc);
	            LOG.error(log);
	        } else if (ex instanceof BizException) {
	            //BizException bzException = (BizException) ex;
	            result.setResuDesc(ex.getMessage());
	            result.setResuCode(((BizException) ex).getCode().code());
	            LOG.error(log,ex);
	        } else if (ex instanceof Exception) {
	            result.setResuDesc("系统异常");
	            LOG.error(log,ex);
	        }
	        BaseController.toResponse(response, result);
	        return null;
	    }
}
