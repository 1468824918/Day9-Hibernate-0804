package com.lanou.crm.dao.impl;

import com.lanou.crm.dao.HomeDao;
import com.lanou.crm.domain.Department;
import com.lanou.crm.domain.Post;
import com.lanou.crm.domain.Staff;
import com.lanou.crm.utils.QueryUtil;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public class HomeDaoImpl implements HomeDao{
    public List<Department> getDepartment() {
        return QueryUtil.findAll(Department.class);
    }

    public List<Post> getPostDeptId(int deptId) {
        return QueryUtil.queryByEqual(Post.class,"department",deptId);
    }

    public List<Staff> getStaffByDeptIdAndPostId(int deptId, int postId) {
        String[] fields = {"department","post"};
        Object[] values = {deptId,postId};
        return QueryUtil.queryByEquals(Staff.class,fields,values);
    }

    public List<Staff> getStaffByDeptId(int deptId) {
        return QueryUtil.queryByEqual(Staff.class,"department",deptId);
    }

    public List<Staff> getStaffs() {
        return QueryUtil.findAll(Staff.class);
    }
}
