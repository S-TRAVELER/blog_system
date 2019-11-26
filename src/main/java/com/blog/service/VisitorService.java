package com.blog.service;

import com.blog.model.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yujunrui
 * @Date: 2019/11/16 16:19
 * Describe:访客业务操作
 */
public interface VisitorService {

    /**
     * 通过页名更新访客人数
     */
    void updateVisitorNumByPageName(String pageName, String visitorNum);

    /**
     * 发布文章后保存该文章的访客量
     * @param pageName 文章url
     */
    void insertVisitorArticlePage(String pageName);

    /**
     * 通过页名获得访客量
     * @param pageName 页名
     * @return 访客量
     */
    long getNumByPageName(String pageName);

    /**
     * 通过页名增加访客量
     * @param pageName
     */
    Result addVisitorNumByPageName(String pageName, HttpServletRequest request);

    /**
     * 获得总访问量
     * @return
     */
    long getTotalVisitor();
   
}
