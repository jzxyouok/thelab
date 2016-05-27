/**
 * Yixiu.com Inc.
 * Copyright (c) 2015-2015 All Rights Reserved.
 */
package com.yang.thelab.common;

/**
 * 
 * @author nibo
 * @version $Id: PageReq.java, v 0.1 2015年11月29日 下午8:07:51 nibo Exp $
 */
public class PageRequ {

    private int page;         // 当前页码。(1-based)
    
    private int itemsPerPage; // 每页项数。
    
    private int beginIndex;
    
    private int endIndex;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
    
}
