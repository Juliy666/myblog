package cn.juliy.myblog.controller;

import cn.juliy.myblog.entity.ArticleEntity;
import cn.juliy.myblog.service.ArticleService;
import cn.juliy.myblog.utills.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * @Description 文章概述列表
     * @Return
     * @param
     **/
    @GetMapping("/article")
    public R getAllArticle(){
        List<ArticleEntity> allArticle = articleService.getAllArticle();
        System.out.println(allArticle);
        return R.ok("获取文章概述成功").put("articleList", allArticle);
    }
    /**
     * @Description 文章详情页
     * @Return
     * @param
     **/
    @GetMapping("/article/{articleId}")
    public R getOneArticle(@PathVariable("articleId") Integer articleId){
        //按id查找出指定的文章
        ArticleEntity articleEntity = articleService.getArticleById(articleId);
        return R.ok("获取文章详情成功").put("articleEntity",articleEntity);
    }


}
