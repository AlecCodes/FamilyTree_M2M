package com.example.ft.DTO;

import java.util.Date;
import java.util.List;


public class CreatePersonRequest {
    private String name;
    private Date birthday;
    private List<Long> parentIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Long> getParentIds() {
        return parentIds;
    }

    public void setParentIds(List<Long> parentIds) {
        this.parentIds = parentIds;
    }
}
