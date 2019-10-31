package cn.juliy.myblog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 用户token
 * @Return
 * @param
 **/
@Data
@TableName("user_token")
public class UserTokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //用户id
    @TableId
    private Long userId;
    //token
    private String token;
    //过期时间
    private Date expireTime;
    //更新时间
    private Date updateTime;
}
