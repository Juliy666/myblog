package cn.juliy.myblog.service;

import cn.juliy.myblog.entity.ArticleEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ArticleService {
    /*获取所有的文章概述列表*/
    List<ArticleEntity> getAllArticle();
    /*获取指定的文章详情*/
    ArticleEntity getArticleById(Integer articleId);
}
