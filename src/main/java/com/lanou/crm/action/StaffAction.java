package com.lanou.crm.action;

import com.lanou.crm.domain.Staff;
import com.lanou.crm.service.HomeService;
import com.lanou.crm.service.impl.HomeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/3.
 */
public class StaffAction extends ActionSupport{
    private HomeService homeService = new HomeServiceImpl();
    private int deptId;
    private int postId;
    private List<Staff> staffs;

    public String staffs(){

        staffs = homeService.getStaffByDeptIdAndPostId(deptId, postId);

        return SUCCESS;
    }

    public String staffsJson(){

        staffs = homeService.getStaffByDeptIdAndPostId(deptId, postId);

        return SUCCESS;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
