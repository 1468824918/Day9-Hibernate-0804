package com.lanou.crm.dao.impl;

import com.lanou.crm.dao.HomeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dllo on 17/11/2.
 */
public class HomeWorkImplTest {
    private HomeDao dao;
    @Before
    public void setUp() throws Exception {
        dao= new HomeDaoImpl();
    }

    @Test
    public void getDepartment() throws Exception {
        Assert.assertEquals(dao.getDepartment().size(),2);
    }

    @Test
    public void getPostDeptId() throws Exception {
        Assert.assertEquals(dao.getPostDeptId(1).size(),3);
    }

    @Test
    public void getStaffByDeptIdAndPostId() throws Exception {
        Assert.assertEquals(dao.getStaffByDeptIdAndPostId(2,5).size(),1);
    }

    @Test
    public void getStaffByDeptId() throws Exception {
        Assert.assertEquals(dao.getStaffByDeptId(1).size(),4);
    }

    @Test
    public void getStaffs() throws Exception {
        Assert.assertEquals(dao.getStaffs().size(),6);
    }

}