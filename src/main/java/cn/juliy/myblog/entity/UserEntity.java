package cn.juliy.myblog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId//id自增长
    private Long id;
    private String username;
    private String password;
    private String perms;
}
