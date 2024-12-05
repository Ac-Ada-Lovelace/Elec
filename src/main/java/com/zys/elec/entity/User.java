package com.zys.elec.entity;

import java.sql.Timestamp;

@SuppressWarnings("unused")
public class User {

    private Long id;
    private String username;
    private String password;
    private String avatar;
    private Timestamp createdAt;
    private Boolean isDeleted;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getAvatar() {
    return avatar;
}

public void setAvatar(String avatar) {
    this.avatar = avatar;
}

public Timestamp getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
}

public Boolean getIsDeleted() {
    return isDeleted;
}

public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
}

    // 省略其他字段的 Getter 和 Setter
}
