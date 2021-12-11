package com.lagou.domain;

/**
 * @Author wsl
 * @Date 2021/11/29 22:02
 * @Project_Name lagou_edu_home_parent
 */
public class Test {

    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
