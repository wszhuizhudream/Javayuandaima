package com.wschase.jdbc3.moban;


import java.time.LocalDateTime;

/**
 * Author:WSChase
 * Created:2019/3/25
 */
public class Member {
    private Integer id;
    private String name;
    private LocalDateTime createdTime;
    private LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
