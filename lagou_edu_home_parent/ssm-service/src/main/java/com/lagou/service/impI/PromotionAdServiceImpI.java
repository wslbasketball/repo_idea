package com.lagou.service.impI;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/3 22:42
 * @Project_Name lagou_edu_home_parent
 */
@Service
public class PromotionAdServiceImpI implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    //5.分页查询广告信息列表
    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {

        PageHelper.startPage(promotionAdVO.getCurrentPage(),promotionAdVO.getPageSize());
        List<PromotionAd> allPromotionAdByPage = promotionAdMapper.findAllPromotionAdByPage();

        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allPromotionAdByPage);
        return pageInfo;
    }

    //6.新增广告信息
    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        //封装数据
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);

        //调用Mapper方法
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    //7.根据ID回显广告信息
    @Override
    public PromotionAd findPromotionAdById(int id) {
        PromotionAd promotionAd = promotionAdMapper.findPromotionAdById(id);
        return promotionAd;
    }

    //8.更新广告信息
    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        //封装数据
        promotionAd.setUpdateTime(new Date());

        //调用Mapper方法
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    //9.广告动态上下线
    @Override
    public void updatePromotionAdStatus(int id, int status) {
        //封装数据
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());

        //调用Mapper方法
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
