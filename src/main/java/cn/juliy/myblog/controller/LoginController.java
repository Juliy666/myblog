package cn.juliy.myblog.controller;

import cn.juliy.myblog.service.UserService;
import cn.juliy.myblog.utills.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends AbstractController{
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;



    @Autowired
    private UserService userService;



    /**
     * @Description 用户登陆
     **/
    @PostMapping("/login")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password
                   ){
        //1获取用户数据
        Subject subject = SecurityUtils.getSubject();

        //2封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //执行登陆方法
        try {
            subject.login(token);
            //登陆成功
            return R.ok("登陆成功");
        }catch (UnknownAccountException e){
            return R.ok("登陆失败");
        }
    }
    @GetMapping("/toLogin")
    public R toLogin(){
        return R.ok("login");
    }
    @GetMapping("/noAuth")
    public R noAuth(){
        return R.ok("noAuth");
    }






}
