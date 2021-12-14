package com.lagou.domain;

/**
 * @Author wsl
 * @Date 2021/12/14 20:17
 * @Project_Name lagou_edu_home_parent
 */
public class MenuVO {

    //分页
    private Integer currentPage;
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
