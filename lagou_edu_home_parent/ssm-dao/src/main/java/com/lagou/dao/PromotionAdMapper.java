package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/3 22:07
 * @Project_Name lagou_edu_home_parent
 */
public interface PromotionAdMapper {

    /**
     * 5.分页查询广告信息列表
     */
    public List<PromotionAd> findAllPromotionAdByPage();

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
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
