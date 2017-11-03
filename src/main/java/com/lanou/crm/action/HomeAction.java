package com.lanou.crm.action;

import com.lanou.crm.domain.Department;
import com.lanou.crm.domain.Post;
import com.lanou.crm.domain.Staff;
import com.lanou.crm.service.HomeService;
import com.lanou.crm.service.impl.HomeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by dllo on 17/11/2.
 */
public class HomeAction extends ActionSupport{
    private HomeService homeService = new HomeServiceImpl();
    private List<Department> department;
    //用来接收jsp传递过来的id
    private int deptId;
    private int postId;
    private List<Post> posts;


    public String home(){
        //获取所有部门信息
        department = homeService.getDepartment();

        return SUCCESS;
    }

    public String getPostByDepartmentId(){
        //根据部门id来查对应的职位
        posts = homeService.getPostDeptId(deptId);
        System.out.println(posts);
        return SUCCESS;
    }



    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
