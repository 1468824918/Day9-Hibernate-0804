package com.lanou.crm.domain;

import java.util.Set;

/**
 * Created by dllo on 17/11/2.
 */
public class Post {
    private int id;
    private String name;
    private Department department;
    private Set<Staff> staffs;

    public Post() {
    }

    public Post(String name) {
        this.name = name;
    }

    public Post(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
}
