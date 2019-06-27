<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/bootstrap/jquery-1.11.0.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="margin: 380px 380px">
            <div class="login-panel panel panel-default"style="margin-top:-130px" >
                <div class="panel-heading">
                    <h3 class="panel-title" style="text-align: center;">新增敏感词汇</h3>
                </div>
                <div class="panel-body">
                    <div id="errorMsg" class="alert alert-danger" ></div>
                    <form role="form" method="post" id="login_form" action="${pageContext.request.contextPath}/word/save">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="请输入敏感词" name="word" autofocus>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <!--<a href="javascript:void(0)" class="btn btn-lg btn-success btn-block" id='login_btn'>登录</a>-->
                            <input type="submit" id="btn_sub" class="btn btn-lg btn-success btn-block" value="保存">
                        </fieldset>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

