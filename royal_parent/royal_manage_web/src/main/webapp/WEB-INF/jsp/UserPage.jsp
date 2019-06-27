<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖信息管理页面</title>

</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }


</style>
<script>

</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="../../jsp/commom/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="../../jsp/commom/leftsidebar.jsp"%>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div >
                    <ol class="breadcrumb">
                        <li><a href="#">用户管理</a></li>
                        <li class="active">用户信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="get" id="articleSearchForm">
                            <table>
                                <tr>
                                    <th>
                                        <label for="title" class="control-label">用户名:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="title" class="form-control"
                                               name="title" value="">
                                        <input type="hidden" id="pageNum" name="pn" value="">
                                    </th>
                                    <th>
                                        <label for="article_sendername" class="control-label">用户组:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="article_sendername" class="form-control"
                                               name="sendername" value="">
                                    </th>
                                    <th colspan="2">
                                        <input type="submit" value="查询" class="form-control btn-primary">
                                    </th>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>用户组</th>
                        <th>邮箱</th>
                        <th>是否禁言</th>
                        <th>最近登陆时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                            <c:forEach items="${pageInfo.list}" var="user">
                            <tr>
                                <td>${user.userName}</td>
                                <td>
                                    ${user.role}
                                </td>
                                <td>${user.email}</td>
                                <td>
                                        ${user.talkStatusStr}
                                </td>
                                <td width="15%">
                                        ${user.lastLoginTime}
                                <td width="15%">
                                    <c:if test="${user.role==2}">
                                        <a href="${pageContext.request.contextPath}/user/changeStatus?id=${user.userId}&role=${user.role-1}" role="button" class="btn btn-danger" >降级</a>
                                    </c:if>
                                    <c:if test="${user.role==1}">
                                            <a href="${pageContext.request.contextPath}/user/changeStatus?id=${user.userId}&role=${user.role+1}" role="button" class="btn btn-info" >升级</a>
                                    </c:if>
                                <c:if test="${user.talkStatus==0}">
                                    <a href="${pageContext.request.contextPath}/user/speakingCompetence?id=${user.userId}&talkStatus=${user.talkStatus+1}" role="button" class="btn btn-danger" >禁言</a>
                                </c:if>
                                <c:if test="${user.talkStatus==1}">
                                    <a href="${pageContext.request.contextPath}/user/speakingCompetence?id=${user.userId}&talkStatus=${user.talkStatus-1}" role="button" class="btn btn-info" >恢复</a>
                                </c:if>

                                </td>
                            </tr>
                            </c:forEach>
                    </tbody>
                </table>


            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
                </div>

                <div class="box-tools pull-right">
                    <ul class="pagination">
                        <li>
                            <a href="${pageContext.request.contextPath}/user/findByPage?page=1&size=${pageInfo.pageSize}" aria-label="Previous">首页</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/user/findByPage?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>
                        <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                            <li><a href="${pageContext.request.contextPath}/user/findByPage?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                        </c:forEach>
                        <li><a href="${pageContext.request.contextPath}/user/findByPage?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a></li>
                        <li>
                            <a href="${pageContext.request.contextPath}/user/findByPage?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Next">尾页</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%@ include file="ArticleUpdate.jsp"%>
</body>
</html>
