package com.blog.controller;

import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.utils.TransCodingUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhenweijin
 * @Date: 2019/11/17 20:50
 * Describe:
 */
@RestController
public class CategoriesControl {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ArticleService articleService;

    /**
     * 获得所有分类名以及每个分类名的文章数目
     * @return
     */
    @GetMapping("/findCategoriesNameAndArticleNum")
    public JSONObject findCategoriesNameAndArticleNum(){
        return categoryService.findCategoriesNameAndArticleNum();
    }

    /**
     * 分页获得该分类下的文章
     * @return
     */
    @GetMapping("/getCategoryArticle")
    public JSONObject getCategoryArticle(@RequestParam("category") String category,
                                         HttpServletRequest request){

        try {
            category = TransCodingUtil.unicodeToString(category);
        } catch (Exception e){
        }
        int rows = Integer.parseInt(request.getParameter("rows"));
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));

        return articleService.findArticleByCategory(category, rows, pageNum);
    }


}