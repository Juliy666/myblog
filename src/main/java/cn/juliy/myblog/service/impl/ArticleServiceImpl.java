package cn.juliy.myblog.service.impl;

import cn.juliy.myblog.entity.ArticleEntity;
import cn.juliy.myblog.mapper.ArticleMapper;
import cn.juliy.myblog.service.ArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    /**
     * @param
     * @Return
     * @Description 获取文章列表业务
     **/
    @Override
    public List<ArticleEntity> getAllArticle() {
        List<ArticleEntity> articleEntities = articleMapper.selectList(null);
        return articleEntities;
    }

    @Override
    public ArticleEntity getArticleById(Integer articleId) {
        QueryWrapper<ArticleEntity> wrapper = new QueryWrapper<>();
        //这里的key是数据库的字段名
        wrapper.eq("article_id",articleId);
        ArticleEntity articleEntity = articleMapper.selectOne(wrapper);
        return articleEntity;
    }
}
