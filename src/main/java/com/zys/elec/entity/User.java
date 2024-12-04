package com.zys.elec.entity;

import java.sql.Timestamp;

@SuppressWarnings("unused")
public class User {

    private Long id;
    private String username;
    private String password;
    private byte[] avatar;
    private Timestamp createdAt;
    private Boolean isDeleted;

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // 省略其他字段的 Getter 和 Setter
}
