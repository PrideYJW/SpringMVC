package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/10/12.
 */
@Entity(name = "stu")
public class StudentEntity {
    @Id
    private Integer id;

    private String name;

    private String Password;

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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
