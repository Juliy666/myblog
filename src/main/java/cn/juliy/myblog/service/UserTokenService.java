package cn.juliy.myblog.service;

import cn.juliy.myblog.entity.UserTokenEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

@Service
public interface UserTokenService extends IService<UserTokenEntity> {

    UserTokenEntity createToken(Long id);
}
