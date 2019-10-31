package cn.juliy.myblog.service.impl;

import cn.juliy.myblog.entity.UserEntity;
import cn.juliy.myblog.mapper.UserMapper;
import cn.juliy.myblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * @param
     * @Return  用户id
     * @Description
     **/
    @Override
    public UserEntity login(String username,String password) {

        List<UserEntity> userEntities = userMapper.selectList(null);
        for (UserEntity userEntity : userEntities) {
            if (userEntity.getUsername().equals(username)&&userEntity.getPassword().equals(password)){
                return userEntity;
            }
        }
        //账户或者密码错误
        return null;
    }
    /*查询用户的所有菜单ID*/
    @Override
    public List<Long> queryAllMenuId(Long id) {
         return baseMapper.queryAllMenuId(id);
    }
}
