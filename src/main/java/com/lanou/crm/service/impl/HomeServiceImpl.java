package com.lanou.crm.service.impl;

import com.lanou.crm.dao.HomeDao;
import com.lanou.crm.dao.impl.HomeDaoImpl;
import com.lanou.crm.domain.Department;
import com.lanou.crm.domain.Post;
import com.lanou.crm.domain.Staff;
import com.lanou.crm.service.HomeService;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public class HomeServiceImpl implements HomeService {
    private HomeDao dao = new HomeDaoImpl();

    public List<Department> getDepartment() {
        return dao.getDepartment();
    }

    public List<Post> getPostDeptId(int deptId) {
        return dao.getPostDeptId(deptId);
    }

    public List<Staff> getStaffByDeptIdAndPostId(int deptId, int postId) {
        if (deptId < 1) {
            return getStaffs();
        } else if (postId < 1) {
            return getStaffByDeptId(deptId);
        } else return dao.getStaffByDeptIdAndPostId(deptId, postId);
    }

    public List<Staff> getStaffByDeptId(int deptId) {
        if (deptId < 1) {
            return getStaffs();
        }
        return dao.getStaffByDeptId(deptId);
    }

    public List<Staff> getStaffs() {
        return dao.getStaffs();
    }
}
