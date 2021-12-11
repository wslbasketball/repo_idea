package com.lagou.service.impI;

import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author wsl
 * @Date 2021/12/2 22:57
 * @Project_Name lagou_edu_home_parent
 */
@Service
public class PromotionSpaceServiceImpI implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    //1.广告位列表查询
    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        List<PromotionSpace> allPromotionSpace = promotionSpaceMapper.findAllPromotionSpace();
        return allPromotionSpace;
    }

    //2.添加广告位
    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        //封装数据
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);

        //调用Mapper方法
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    //3.根据ID回显广告位信息
    @Override
    public PromotionSpace findPromotionSpaceById(int id) {
        PromotionSpace promotionSpaceById = promotionSpaceMapper.findPromotionSpaceById(id);
        return promotionSpaceById;
    }

    //4.更新广告位(名称)
    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        //封装数据
        promotionSpace.setUpdateTime(new Date());

        //调用Mapper方法
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }
}
