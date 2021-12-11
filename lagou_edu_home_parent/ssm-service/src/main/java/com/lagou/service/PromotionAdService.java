package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;


/**
 * @Author wsl
 * @Date 2021/12/3 22:38
 * @Project_Name lagou_edu_home_parent
 */
public interface PromotionAdService {

    /**
     * 5.分页查询广告信息列表
     */
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    /**
     * 6.新增广告信息
     */
    public void savePromotionAd(PromotionAd promotionAd);

    /**
     * 7.根据ID回显广告信息
     */
    public PromotionAd findPromotionAdById(int id);

    /**
     * 8.更新广告信息
     */
    public void updatePromotionAd(PromotionAd promotionAd);

    /**
     * 9.广告动态上下线
     */
    public void updatePromotionAdStatus(int id,int status);
}
