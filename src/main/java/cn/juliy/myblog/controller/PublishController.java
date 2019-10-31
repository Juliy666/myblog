package cn.juliy.myblog.controller;

import cn.juliy.myblog.utills.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {
    @GetMapping("/publish")
    public R getPublish(){
        return R.ok("进入文章发表页面");
    }
}
