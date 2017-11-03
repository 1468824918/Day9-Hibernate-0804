<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/2
  Time: 下午4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>欢迎进入本系统</h1>
<script>
    <%--当选择部门的时候会执行--%>
    function onChange(value) {
        //输出value的值
        console.log(value);
        //根据value的值发送请求,获取二级列表的json数据
        var data = new FormData();
        data.append("deptId", value);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.responseText);
                //对请求回来的数据进行解析
                json = eval('(' + this.responseText + ')');

                //获取服务器的标签
                serverSelect = document.getElementById("post");
                //获取option标签
                optionEle = serverSelect.getElementsByTagName("option");
                //获取option的数量
                length = optionEle.length;
                //使用循环清空所有option标签
                for (var i = 0; i < length - 1; i++) {
                    serverSelect.removeChild(optionEle[1]);
                }
//                    serverSelect.innerText = '<option value="-1">---请选择---</option>'
                //将json数据插入到option中
                for (var i = 0; i < json.length; i++) {
                    //创建一个option标签
                    option = document.createElement("option");
                    //设置value属性
                    option.setAttribute("value", json[i].id);
                    //设置文本信息
                    text = document.createTextNode(json[i].name)
                    //把文本信息添加到option标签中
                    option.appendChild(text);
                    //把option标签添加到servers标签中
                    serverSelect.appendChild(option);
                }

            }
        });

        xhr.open("POST", "getPosts.action");
        xhr.send(data);
    }

    function onStaffsQuery() {
        //当点击查询按钮的时候会执行
        //获取两个select选中时的id
        var deptId = document.getElementById("department").value;
        var postId = document.getElementById("post").value;
        var data = new FormData();
        data.append("deptId",deptId);
        data.append("postId",postId);
        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.responseText);
                //对请求回来的数据进行解析
                json = eval('(' + this.responseText + ')');
                function createTD(text) {
                    var td = document.createElement("td");
                    td.setAttribute("align", "center");
                    var textNode = document.createTextNode(text);
                    td.appendChild(textNode);
                    return td;
                }
                var tableEle = document.getElementById("staff");
                var length = tableEle.rows.length;
                for(var i = 0; i < length - 1; i++){
                    tableEle.deleteRow(1);
                }

                for (var i = 0; i < json.length; i++) {
                    var tr = document.createElement("tr");

                    tr.appendChild(createTD(json[i].id));
                    tr.appendChild(createTD(json[i].name));
                    tr.appendChild(createTD(json[i].gender));
                    tr.appendChild(createTD(json[i].age));
                    tr.appendChild(createTD(json[i].department.name));
                    tr.appendChild(createTD(json[i].post.name));

                    tableEle.appendChild(tr);
                }

            }
        });

        xhr.open("POST", "staffsJson.action");
        xhr.send(data);
    }
</script>

    部门:
    <select id="department"
            onchange="onChange(this.value)"
            form="getStaffs"
            name="deptId">
        <option value="-1">---请选择---</option>
        <s:iterator value="department" var="dept">
            <option value="${dept.id}">${dept.name}</option>
        </s:iterator>
    </select>
    <select id="post"
            form="getStaffs"
            name="postId">
        <option value="-1">---请选择---</option>
    </select>
    <br>
<form action="staffs.action" method="post" id="getStaffs">
    <input type="submit" value="查询">
    <input type="reset" value="重置">
</form>

<br>
<button onclick="onStaffsQuery()">查询员工</button>
<table id="staff">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>部门</th>
        <th>职位</th>
    </tr>
    <s:iterator value="staffs" var="staff">
    <tr>
        <td>${staff.id}</td>
        <td>${staff.name}</td>
        <td>${staff.gender}</td>
        <td>${staff.age}</td>
        <td>${staff.department.name}</td>
        <td>${staff.post.name}</td>
    </tr>
    </s:iterator>
</table>
</body>
</html>
