package cn.juliy.myblog.mapper;

import cn.juliy.myblog.entity.UserTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenMapper extends BaseMapper<UserTokenEntity> {
    UserTokenEntity queryByToken(String token);
}
