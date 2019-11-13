package cn.juliy.myblog.controller;

import cn.juliy.myblog.service.ArticleService;
import cn.juliy.myblog.utills.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @Description 发布文章页面(管理员权限)
 * @Return
 * @param
 **/
@RestController
@RequestMapping("/publish")
@RequiresPermissions("admin:publish")
public class PublishController {
    @Value("${myblog.file-root}")
    private String fileRoot;

    @Autowired
    private ArticleService articleService;

/*    @PostMapping("/article")
    public R publishArticle(){
        return R.ok("文章发布成功");
    }*/

    /*上传图片按钮v1*/
/*    @PostMapping("/picture/upload")
    public R uploadPicture(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return R.error("上传头像不能为空");
        } else if (file.getSize() / 1024 / 1024 >= 1) {
            return R.error("头像不能超过1M");
        } else if (!file.getOriginalFilename().endsWith(".jpg")) {
            return R.error("必须上传JPG图片");
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        try {
            InputStream in = file.getInputStream();
            BufferedInputStream bin = new BufferedInputStream(in);
            OutputStream out = new FileOutputStream(fileRoot + "/banner/" + uuid + ".jpg");
            BufferedOutputStream bout = new BufferedOutputStream(out);
            int i = bin.read();
            while (i != -1) {
                bout.write(i);
                i = bin.read();
            }
            bin.close();
            in.close();
            bout.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("头像保存失败");
        }

        return R.ok("图片上传成功").put("filename", uuid + ".jpg").put("articlePic","/banner/" + uuid + ".jpg");
    }*/

    /*和另一个接口相同*/
    /*发布文章按钮(将文章文字存入数据库,把图片路径存入数据库)*/
/*    @PostMapping("/article")
    public R addArticle(@RequestParam("articleTitle") String articleTitle,
                        @RequestParam("articleContent") String articleContent,
                        @RequestParam("articleDesc") String articleDesc,
                        *//*这里要给我图片路径的json数据值*//*
                        @RequestParam("articlePic") String articlePic
                        ){
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setArticleTitle(articleTitle);
        articleEntity.setArticleContent(articleContent);
        articleEntity.setArticleDesc();
        articleService.addArticle(articleEntity);
        return R.ok("存入文章成功").put();
    }*/

    /*图片上传v2,为防止接口冲突，不写相同的名字的接口*/
    @PostMapping("/picture/upload")
    public R uploadPicture(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return R.error("上传头像不能为空");
        } else if (file.getSize() / 1024 / 1024 >= 1) {
            return R.error("头像不能超过1M");
        } else if (!file.getOriginalFilename().endsWith(".jpg")) {
            return R.error("必须上传JPG图片");
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        try {
            InputStream in = file.getInputStream();
            BufferedInputStream bin = new BufferedInputStream(in);
            OutputStream out = new FileOutputStream(fileRoot +"/"+ uuid + ".jpg");
            BufferedOutputStream bout = new BufferedOutputStream(out);
            int i = bin.read();
            while (i != -1) {
                bout.write(i);
                i = bin.read();
            }
            bin.close();
            in.close();
            bout.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("图片保存失败");
        }

        return R.ok("图片上传成功").put("filename", uuid + ".jpg").put("location","home/demo/"+uuid + ".jpg");
    }

}
