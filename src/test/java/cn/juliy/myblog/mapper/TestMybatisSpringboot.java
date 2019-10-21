package cn.juliy.myblog.mapper;

import cn.juliy.myblog.entity.ArticleEntity;
import cn.juliy.myblog.entity.UserEntity;
import cn.juliy.myblog.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMybatisSpringboot {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;


    /*测试文章概述列表方法*/
    @Test
    public void getAllArticle(){

        List<ArticleEntity> articleEntities = articleMapper.selectList(null);
        for (ArticleEntity articleEntity : articleEntities) {
            System.out.println(articleEntity);
        }


    }
    /*测试查出所有用户信息*/
    @Test
    public void getUserList() throws Exception {

        List<UserEntity> users = userMapper.selectList(null);
        for (UserEntity user : users) {
            System.out.println(user);

        }
    }
}
