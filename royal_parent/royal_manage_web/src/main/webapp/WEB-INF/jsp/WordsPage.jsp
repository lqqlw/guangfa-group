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
                        <li><a href="#">用户贴管理</a></li>
                        <li class="active">敏感词汇管理</li>
                    </ol>
                </div>
                <hr>
                <div style="clear:both"></div>
                <hr>
                <table>
                    <tr>
                        <td width="15%">
                            <a href="${pageContext.request.contextPath}/jsp/InsertWords.jsp" role="button" class="btn btn-info" >新增敏感词</a>
                        </td>
                    </tr>
                </table>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>敏感词</th>
                        <th>是否启用</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                            <c:forEach items="${pageInfo.list}" var="word">
                            <tr>
                                <td>${word.wordId}</td>
                                <td>
                                    ${word.word}
                                </td>
                                <td>${word.statusStr}</td>
                                <td width="15%">

                                <c:if test="${word.status==0}">
                                    <a href="${pageContext.request.contextPath}/word/processing?id=${word.wordId}&status=${word.status+1}" role="button" class="btn btn-danger" >停用</a>
                                </c:if>
                                <c:if test="${word.status==1}">
                                    <a href="${pageContext.request.contextPath}/word/processing?id=${word.wordId}&status=${word.status-1}" role="button" class="btn btn-info" >启用</a>
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
                            <a href="${pageContext.request.contextPath}/word/findByPage?page=1&size=${pageInfo.pageSize}" aria-label="Previous">首页</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/word/findByPage?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>
                        <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                            <li><a href="${pageContext.request.contextPath}/word/findByPage?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                        </c:forEach>
                        <li><a href="${pageContext.request.contextPath}word/findByPage?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a></li>
                        <li>
                            <a href="${pageContext.request.contextPath}/word/findByPage?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Next">尾页</a>
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
