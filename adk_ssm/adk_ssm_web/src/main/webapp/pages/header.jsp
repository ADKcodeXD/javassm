<%--
  Created by IntelliJ IDEA.
  User: 79053
  Date: 2021/7/31
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<header class="main-header">


    <!-- Logo -->
    <a href="all-admin-index.html" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>数据</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>数据</b>后台管理</span>
    </a>


    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">

                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">张猿猿</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                张猿猿 - 数据管理员
                                <small>最后登录 11:20AM</small>
                            </p>
                        </li>
                        <!-- Menu Body
                <li class="user-body">
                    <div class="row">
                        <div class="col-xs-4 text-center">
                            <a href="#">Followers</a>
                        </div>
                        <div class="col-xs-4 text-center">
                            <a href="#">Sales</a>
                        </div>
                        <div class="col-xs-4 text-center">
                            <a href="#">Friends</a>
                        </div>
                    </div>
                </li>-->
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">修改密码</a>
                            </div>
                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
</header>
</body>
</html>
