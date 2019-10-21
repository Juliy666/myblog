package cn.juliy.myblog.controller;

import cn.juliy.myblog.entity.UserEntity;
import cn.juliy.myblog.service.UserService;
import cn.juliy.myblog.utills.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @Autowired
    private UserService userService;



    /**
     * @Description 用户登陆
     **/
    @PostMapping("/login")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password){

        UserEntity userEntity = userService.login(username, password);
        System.out.println(userEntity);
        //登陆成功
        if (userEntity!=null){
            //生成token,并保存到数据库中
            /*userTokenSerivce.createToken(userEntity.getId());*/
            return R.ok("登陆成功");
        }
        return R.error("登陆失败");


    }






}
