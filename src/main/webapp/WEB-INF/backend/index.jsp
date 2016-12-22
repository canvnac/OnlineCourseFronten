<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="UTF-8">
    <link  rel="stylesheet" href="${pageContext.request.contextPath}/static/backend/css/bootstrap/bootstrap.css">
    <link  rel="stylesheet" href="${pageContext.request.contextPath}/static/backend/css/style.css">
    <link  rel="stylesheet" href="${pageContext.request.contextPath}/static/backend/css/font-awesome.min.css">
    <title>index</title>
</head>
<body>

<!-- 页面加载 Loading -->
<div class="loading"><img src="${pageContext.request.contextPath}/static/backend/img/loading.gif" alt="loading-img"></div>
<!-- 页面加载 Loading -->

<!--header-->
<div id="top" class="clearfix">

    <!-- Logo -->
    <div class="applogo">
        <img src="${pageContext.request.contextPath}/static/backend/img/logo.png" height="50" style="margin-top:-13px;">
    </div>
    <!-- Logo -->

    <!-- Start Sidebar Show Hide Button -->
    <a href="#" class="sidebar-open-button"><i class="fa fa-bars"></i></a>
    <a href="#" class="sidebar-open-button-mobile"><i class="fa fa-bars"></i></a>
    <!-- End Sidebar Show Hide Button -->

    <!-- 设置 -->
    <a href="#sidepanel" class="sidepanel-open-button dropdown-toggle profilebox" data-toggle="dropdown" ><i class="fa fa-gear"></i></a>
    <!-- 设置end-->
    <ul class="dropdown-menu dropdown-menu-list dropdown-menu-right">
        <li role="presentation" class="dropdown-header">设置</li>
        <li><a href="#" target="iframe"><i class="fa falist fa-code"></i>各种设置</a></li>
        <li><a href="edit-cid.html"><i class="fa falist fa-wrench"></i>渠道设置</a></li>
        <li><a href="edit-data.html"><i class="fa falist fa-wrench"></i>数据编辑</a></li>
        <li><a href="#"><i class="fa falist fa-inbox"></i>信息通知<span class="badge label-danger">4</span></a></li>
        <li><a href="#"><i class="fa falist fa-lock"></i>修改密码</a></li>
        <li><a href="#"><i class="fa falist fa-power-off"></i>退出</a></li>
    </ul>
    <!-- 右边菜单栏-->
    <ul class="top-right">
        <li class="dropdown link">
            <a href="#" class="profilebox"><img src="${pageContext.request.contextPath}/static/backend/img/profileimg.png" alt="img"><b>卡西欧</b></a>
        </li>
        <li class="dropdown link">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle hdbutton">项目<span class="caret"></span></a>
            <ul class="dropdown-menu dropdown-menu-list">
                <li><a href="#"><i class="fa falist fa-paper-plane-o"></i>卡西欧商城</a></li>
                <li><a href="#"><i class="fa falist fa-font"></i>卡西欧天猫</a></li>
                <li><a href="#"><i class="fa falist fa-file-image-o"></i>Image Gallery</a></li>
                <li><a href="#"><i class="fa falist fa-file-video-o"></i>Video Gallery</a></li>
            </ul>
        </li>

    </ul>
    <!-- 右边菜单栏end -->

</div>
<!--headerend-->

<!--左边菜单栏-->
<div class="sidebar clearfix">
    <div class="sidebar-colorful">
        <ul class="sidebar-panel nav ">
            <li><a href="index.html" target="_self"><span class="icon color3"><i class="fa fa-dashboard"></i></span>报表面板</a></li>
            <li><a target="_self"><span class="icon color7"><i class="fa fa-gift"></i></span>创建课程<span class="caret"></span></a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/creatcourse/show" target="iframe">创建课程</a></li>
                    <%--<li><a href="direct-traffic.html" target="_self">直接流量</a></li>
                    <li><a href="coo-traffic.html" target="_self">合作流量</a></li>--%>
                    <%--<li><a href="seo.html" target="_self">SEO</a></li>--%>
                </ul>
            </li>
            <li><a target="_self" ><span class="icon color6"><i class="fa fa-money"></i></span>付费推广<span class="caret"></span></a>
                <ul >
                    <li><a href="paying-promotion.html" target="_self">付费概括</a></li>
                    <li><a href="sem.html" target="_self">SEM</a></li>
                    <li><a href="edm.html" target="_self">EDM</a></li>
                    <li><a href="dsp.html" target="_self">DSP</a></li>
                    <li><a href="alliance-promotion.html" target="_self">网盟</a></li>
                    <li><a href="text-message.html" target="_self">短信</a></li>
                    <li><a href="telecom.html" target="_self">电信</a></li>
                    <li><a href="advertorial.html" target="_self">软文</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="icon color5"><i class="fa fa-bullhorn"></i></span>活动分析<span class="caret"></span></a>
                <ul>
                    <li><a href="qingren.html" target="_self">情人节促销</a></li>
                    <li><a href="liuyi.html" target="_self">六一促销</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="icon color10"><i class="fa fa-shopping-cart"></i></span>产品分析<span class="caret"></span></a>
                <ul>
                    <li><a href="shuma.html" target="_self">数码相机</a></li>
                    <!--       <li><a href="shuma.html" target="_self">手表</a></li>
                    <li><a href="shuma.html" target="_self">电子乐器</a></li>
                    <li><a href="shuma.html" target="_self">计算器</a></li>
                    <li><a href="shuma.html" target="_self">投影机</a></li> -->

                </ul>
            </li>
            <li><a href="#"><span class="icon color9"><i class="fa fa-desktop"></i></span>站内分析<span class="caret"></span></a>
                <ul>
                    <li><a href="channel.html" target="_self">频道分析</a></li>
                    <li><a href="adpositionid.html" target="_self">广告位分析</a></li>
                    <li><a href="in-recommend.html" target="_self">站内推荐</a></li>
                    <li><a href="in-search.html" target="_self">站内搜索</a></li>
                </ul>
            </li>
            <li><a href="renqun.html" target="_self"><span class="icon color1"><i class="fa fa-group"></i></span>人群画像</a>
            </li>
            <li><a href="#"><span class="icon color4"><i class="fa fa-database"></i></span>个性报表<span class="caret"></span></a>
                <ul>
                    <li><a href="download.html" target="_self">报表下载</a></li>
                    <li><a href="applyfor.html" target="_self">报表申请</a></li>
                </ul>
            </li>
    </div>
</div>
<!--左边菜单栏end-->

<!--内容-->
<div class="content">

    <iframe id="iframe" name="iframe" frameborder="0" scrolling="no" src="" width="100%" height="100%"></iframe>

</div>
<!--内容end-->
<!--加载js-->
<script src="${pageContext.request.contextPath}/static/backend/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/js/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/backend/js/index/index.js"></script>
</body>
</html>
