package com.lagou.domain;

/**
 * @Author wsl
 * @Date 2021/12/6 20:55
 * @Project_Name lagou_edu_home_parent
 */
public class ResourceVO {

    private Integer currentPage;
    private Integer pageSize;
    private String name;
    private int categoryId;
    private String url;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ResourceVO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", url='" + url + '\'' +
                '}';
    }
}
