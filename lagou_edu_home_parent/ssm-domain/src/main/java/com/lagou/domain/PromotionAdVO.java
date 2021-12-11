package com.lagou.domain;

/**
 * @Author wsl
 * @Date 2021/12/3 22:40
 * @Project_Name lagou_edu_home_parent
 */
public class PromotionAdVO {

    //当前页
    private Integer currentPage;
    //每页显示的条数
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
