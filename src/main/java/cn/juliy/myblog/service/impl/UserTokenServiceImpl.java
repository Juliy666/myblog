package cn.juliy.myblog.service.impl;

import cn.juliy.myblog.entity.UserTokenEntity;
import cn.juliy.myblog.mapper.UserTokenMapper;
import cn.juliy.myblog.oauth2.TokenGenerator;
import cn.juliy.myblog.service.UserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper,UserTokenEntity> implements UserTokenService {
    //12小时后过期
    private final static int EXPIPE =3600 * 12;
    
    @Override
    public UserTokenEntity createToken(Long id) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        /*System.out.println(token);*/
        //当前时间
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + EXPIPE * 1000);
        //判断是否生成过token
        UserTokenEntity userTokenEntity = this.getById(id);
        //如果没生成，就new一个新的userTokenEntity对象
        if (userTokenEntity==null){
            userTokenEntity= new UserTokenEntity();
            userTokenEntity.setUserId(id);
            userTokenEntity.setToken(token);
            userTokenEntity.setUpdateTime(now);
            userTokenEntity.setExpireTime(expireTime);
            //保存token
            this.save(userTokenEntity);
        }
        //如果之前有生成过了
        else {
            userTokenEntity.setToken(token);
            userTokenEntity.setUpdateTime(now);
            userTokenEntity.setExpireTime(expireTime);
            //更新token
            this.updateById(userTokenEntity);
        }
        return userTokenEntity;
    }
}
