package cn.juliy.myblog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @TableId//id自增长
    private Long id;
    private String username;
    private String password;
}
