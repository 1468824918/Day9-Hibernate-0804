package com.lanou.crm.utils;

import com.lanou.crm.domain.Department;
import com.lanou.crm.domain.Post;
import com.lanou.crm.domain.Staff;
import org.junit.Test;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public class QueryUtilTest {

    @Test
    public void questTest(){
        System.out.println(QueryUtil.findAll(Department.class));
        System.out.println(QueryUtil.findAll(Post.class));
        System.out.println(QueryUtil.findAll(Staff.class));
    }

    @Test
    public void questTest2(){
        //查询部门id为1的所有员工
        List<Staff> list = QueryUtil.queryByEqual(Staff.class, "gender","男");
        System.out.println(list);
    }

    @Test
    public void questTest3(){
        //多条件查询
        //查询教学部的所有男员工
        String[] fields = {"department","gender"};
        Object[] values={1,"女"};

        List<Staff> staffs = QueryUtil.queryByEquals(Staff.class, fields, values);
        System.out.println(staffs);
    }

}