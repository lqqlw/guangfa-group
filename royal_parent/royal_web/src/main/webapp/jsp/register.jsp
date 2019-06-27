<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛注册页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>

    <script>

        /*
            表单校验：
                1.用户名：由英文、数字、下划线组成
                2.密码：长度必须6~10位的英文或数字
                3.email：邮件格式              */

        //校验用户名
        function checkUsername() {
            //1.获取用户名值
            var username = $("#userName").val();
            //2.定义正则
            var reg_username = /^[A-Za-z0-9]{6,10}$/;
            //3.判断，给出提示信息
            var flag = reg_username.test(username);
            var span = $("#s_username");
            $.get("${pageContext.request.contextPath}/user/findByUserName",{"userName":username},function (data) {
                //判断此用户名是否存在
                if(data.userExsit){
                    //用户名存在 提示此用户名太受欢迎，请重新输入
                    span.css("color","red");
                    span.html(data.msg);
                }else {
                    //用户名不存在 提示可以使用的用户名
                    span.css("color" , "green");
                    span.html(data.msg);
                }
            })
        }

        //校验密码
        function checkPassword() {
            var password = $("#userPass").val();
            var reg_password = /^[A-Za-z0-9]{6,10}$/;
            var flag = reg_password.test(password);
            if(flag==true){
                $("#userPass").css("border","");
            }else{
                $("#userPass").css("border","1px solid red");
            }
            return flag;
        }
        //校验邮箱
        function checkEmail(){
            //1.获取邮箱
            var email = $("#email").val();
            //2.定义正则		itcast@163.com
            var reg_email = /^\w+@\w+\.\w+$/;
            //3.判断
            var flag = reg_email.test(email);
            if(flag){
                $("#email").css("border","");
            }else{
                $("#email").css("border","1px solid red");
            }
            return flag;
        }


        $(function () {
            $("#form").submit(function () {
                if(checkUsername() && checkPassword() &&checkEmail()){
                    location.href="success.jsp";
                }else{
                    location.href="falier.jsp";
                }
        });

            $("#userName").blur(checkUsername);
            $("#userPass").blur(checkPassword);
            $("#email").blur(checkEmail);
        });




    </script>
</head>
<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="${pageContext.request.contextPath}/images/logo.png" height="64" width="168" alt=""/></a>
            </h1>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="${pageContext.request.contextPath}/jsp/index.jsp">首页</a><span></span>注册页面
        </div>
    </div>
</div>


<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="reg-box">
            <h2>用户注册<span>（红色型号代表必填）</span></h2>
            <div class="reg-info">
                <form action="${pageContext.request.contextPath}/user/save" method="post" id="form">
                    <ul>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 用户名：
                            </div>
                            <div class="reg-c">
                                <input type="text" id="userName" name="userName" class="txt" value=""/>
                            </div>
                            <span class="tips" id="s_username">用户名必须是由英文、数字、下划线组成</span>
                        </li>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 密&nbsp;&nbsp;&nbsp;码：
                            </div>
                            <div class="reg-c">
                                <input type="password" id="userPass" name="userPass" class="txt" value=""/>
                            </div>
                            <span class="tips">密码长度必须6~10位的英文或数字</span>
                        </li>
                        <li class="no-tips">
                            <div class="reg-l">&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;箱：</div>
                            <div class="reg-c">
                                <input type="text" id="email" name="email" class="txt" value=""/>
                            </div>
                        </li>
                        <li>
                            <div class="reg-l"></div>
                            <div class="reg-c">
                                <input type="submit" class="submit-btn" value="注册"/><br/>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>




<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>


</body>
</html>