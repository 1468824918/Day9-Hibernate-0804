package com.lanou.crm.domain;

import com.lanou.crm.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/2.
 */
public class DepartmentTest {
    @Test
    public void generateTable(){
        Session session = HibernateUtil.openSession();

       Department d1 = new Department("教学部");
       Department d2 = new Department("职业规划部");

        Post p1 = new Post("教学总监");
        Post p2 = new Post("教学主管");
        Post p3 = new Post("讲师");
        Post p4 = new Post("事业规划主管");
        Post p5 = new Post("职业规划师");

        p1.setDepartment(d1);
        p2.setDepartment(d1);
        p3.setDepartment(d1);
        p4.setDepartment(d2);
        p5.setDepartment(d2);


        Staff s1 = new Staff("孟宪义","男",32);
        s1.setDepartment(d1);
        s1.setPost(p1);
        Staff s2 = new Staff("李中仁","男",27);
        s2.setDepartment(d1);
        s2.setPost(p2);
        Staff s3 = new Staff("肖玲玲","女",23);
        s3.setDepartment(d1);
        s3.setPost(p3);
        Staff s4 = new Staff("表姐","女",22);
        s4.setDepartment(d1);
        s4.setPost(p3);
        Staff s5 = new Staff("琳姐","女",21);
        s5.setDepartment(d2);
        s5.setPost(p4);
        Staff s6 = new Staff("何欣","女",21);
        s6.setDepartment(d2);
        s6.setPost(p5);

        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);



//        session.save(p1);
//        session.save(p2);
//        session.save(p3);
//        session.save(p4);
//        session.save(p5);


        HibernateUtil.commit();
    }
}