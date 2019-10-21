package cn.juliy.myblog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @param
 * @Return
 * @Description 文字分类表
 **/
@Data
@TableName("category")
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @TableId
    private Integer cid;
    private String cname;
}
