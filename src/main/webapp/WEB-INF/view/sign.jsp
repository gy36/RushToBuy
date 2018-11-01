<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀商品列表😁</title>
    <%@include file="common/site/login.jsp" %>
</head>
<body>
        <div class="container">
            <div class="row row-centered">
                <div class="well col-md-6 col-centered">
                    <h2>用户注册</h2>
                    <br>
                    <form:form action="/login" method="post" role="form">
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" id="userid" name="userid" placeholder="请输入用户ID"/>
                        </div>
                        <br>
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
                        </div>
                        <br>
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" id="password" name="password" placeholder="请再次输入密码"/>
                        </div>
                        <br/>
                        
                        <a href="login">登陆</a>
                        <button style="float:right;" type="button" class="btn btn-success">注册</button>
                    </form:form>
                </div>
            </div>
        </div>
        <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
        <script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
 
        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
        <script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </body>
</html>