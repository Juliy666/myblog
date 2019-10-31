package cn.juliy.myblog.mapper;

import cn.juliy.myblog.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    /**
     * 查询用户的所有菜单id
     */
    List<Long> queryAllMenuId(long id);

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);

}
