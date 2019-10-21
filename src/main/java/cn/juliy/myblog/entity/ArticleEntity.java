package cn.juliy.myblog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@TableName("article")
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity {
    @TableId
    private Integer articleId;
    private String articleTitle;
    private String articleTime;
    private String articleContent;
    private String articlePic;
    private String articleDesc;
    /*类型id*/
    private Integer articleCid;
}
