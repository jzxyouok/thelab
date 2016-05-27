package com.yang.thelab.common.utils;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.yang.thelab.common.PageRequ;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.enums.SeqServiceKey;


/**
 * 
 * @author nibo
 * @version $Id: PaginatUtil.java, v 0.1 2015年12月12日 下午7:43:40 nibo Exp $
 */
public class PaginatUtil {
    
    @SuppressWarnings("unchecked")
    public static final  <T> Paginator<T> execute(SqlMapClientTemplate SqlMapClientTemplate,SeqServiceKey ns,PageRequ requ){
        Long count = (Long) SqlMapClientTemplate.queryForObject(ns.code() + ".compQueryCount",
            requ);
        Paginator<T> result = null;
        if (count.longValue() == 0) {
            return new Paginator<T>(requ.getItemsPerPage(),0);
        }
        result = new Paginator<T>(requ.getItemsPerPage(), count.intValue());
        result.setPage(requ.getPage());
        requ.setBeginIndex(result.getBeginIndex() - 1);
        requ.setItemsPerPage(result.getItemsPerPage());
        requ.setEndIndex(result.getEndIndex());
        result.setPdate((List<T>) SqlMapClientTemplate
            .queryForList(ns.code() + ".compQuery", requ));
        return result;
    }

}
