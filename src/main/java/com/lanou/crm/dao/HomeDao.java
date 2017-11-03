package com.lanou.crm.dao;

import com.lanou.crm.domain.Department;
import com.lanou.crm.domain.Post;
import com.lanou.crm.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public interface HomeDao {
    /**
     * 查询所有部门信息
     * @return
     */
    List<Department> getDepartment();

    /**
     * 根据部门id查询对应职位
     * @param deptId 部门id
     * @return 职位的集合
     */
    List<Post> getPostDeptId(int deptId);

    /**
     * 根据部门和职位的id查询出所有对应的员工
     * @param deptId 部门id
     * @param postId 职位id
     * @return 员工集合
     */
    List<Staff> getStaffByDeptIdAndPostId(int deptId,int postId);

    /**
     * 查询某个部门的所有员工
     * @param deptId
     * @return
     */
    List<Staff> getStaffByDeptId(int deptId);

    /**
     * 查询所有员工
     * @return
     */
    List<Staff> getStaffs();
}
