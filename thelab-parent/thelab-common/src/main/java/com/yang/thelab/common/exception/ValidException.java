package com.yang.thelab.common.exception;

import java.util.List;
/**
 * 
 * @author YJ.yang
 * @version $Id: ValidException.java, v 0.1 2015年12月20日 下午12:52:26 wztz Exp $
 */
public class ValidException extends RuntimeException {
	
	private static final long serialVersionUID = -4172166921503877360L;

    private List<Prompt>      promptList;

    public ValidException(List<Prompt> promptList) {
        super();
        this.promptList = promptList;
    }

    public List<Prompt> getPromptList() {
        return promptList;
    }
}
