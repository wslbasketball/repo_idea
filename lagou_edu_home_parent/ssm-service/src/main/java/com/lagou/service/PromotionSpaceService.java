package com.lagou.service;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @Author wsl
 * @Date 2021/12/2 22:56
 * @Project_Name lagou_edu_home_parent
 */
public interface PromotionSpaceService {

     /**
     * 1.广告位列表查询
     */
    public List<PromotionSpace> findAllPromotionSpace();

    /**
     * 2.添加广告位(名称)
     */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 3.根据ID回显广告位信息
     */
    public PromotionSpace findPromotionSpaceById(int id);

    /**
     * 4.更新广告位(名称)
     */
    public void updatePromotionSpace(PromotionSpace promotionSpace);

}
