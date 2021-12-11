package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wsl
 * @Date 2021/12/3 22:52
 * @Project_Name lagou_edu_home_parent
 */
@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    //5.分页查询广告列表信息
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVO promotionAdVO){

        PageInfo<PromotionAd> pageInfo = promotionAdService.findAllPromotionAdByPage(promotionAdVO);

        return new ResponseResult(true,200,"分页查询广告列表信息成功",pageInfo);
    }

    //6.1 广告图片上传
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //1.判断接受到的上传文件是否为空
        if (file.isEmpty()){
            throw new RuntimeException();
        }

        //2.获取项目部署路径
        // D:\\apache-tomcat-8.5.56\\webapps\\ssm-web\\
        String realPath = request.getServletContext().getRealPath("/");
        // D:\\apache-tomcat-8.5.56\\webapps
        String substring = realPath.substring(0, realPath.indexOf("ssm-web"));

        //3.获取原文件名
        //lagou.jpg
        String originalFilename = file.getOriginalFilename();

        //4.生成新文件名
        //时间戳.jpg
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //5.文件上传
        // D:\\apache-tomcat-8.5.56\\webapps\\upload
        String uploadPath = substring + "upload\\";
        File filePath = new File(uploadPath, newFileName);

        //如果目录不存在就创建目录
        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录："+ filePath);
        }

        //图片就进行了真正的上传
        file.transferTo(filePath);

        //6.将文件名和文件路径返回，进行响应
        Map<String,String> map = new HashMap<>();
        map.put("fileName",newFileName);
        //"filePath": "http://localhost:8080/upload/1597112871741.JPG"
        map.put("filePath","http://localhost:8080/upload/" + newFileName);

        ResponseResult responseResult = new ResponseResult(true,200,"图片上传成功",map);

        return responseResult;
    }

    //6.2 新增&修改广告信息
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd){

        //判断是否携带ID，有携带，则为修改操作，没有携带，则为新增操作
        if (promotionAd.getId() == null){
            //新增操作
            promotionAdService.savePromotionAd(promotionAd);
            return new ResponseResult(true,200,"新增广告信息成功",null);
        } else {
            //修改操作
            promotionAdService.updatePromotionAd(promotionAd);
            return new ResponseResult(true,200,"更新广告信息成功",null);
        }

    }

    //7.根据ID回显广告信息
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(int id){

        PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);

        return new ResponseResult(true,200,"根据ID回显广告信息成功",promotionAd);
    }

    //8.广告动态上下线
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(Integer id,Integer status){

        promotionAdService.updatePromotionAdStatus(id,status);

        //使用map集合进行封装
        Map<String,Object> map = new HashMap<>();
        map.put("status", status);

        return new ResponseResult(true,200,"广告动态上下线成功",map);
    }

}
