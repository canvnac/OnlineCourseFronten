<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <link href="${pageContext.request.contextPath}/static/public/css/topic/common.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/public/css/topic/layer.css" rel="stylesheet"/>
    <title>topic</title>
</head>
<body>
<%--头部--%>
<jsp:include page="include/header.jsp"></jsp:include>
<%--头部end--%>
<!--内容-->
<div id="main">
    <div class="wenda clearfix">

        <div class="js-layout-change">
            <!--右边内容-->
            <div class="l wenda-main">
                <div class="wd-top-slogan">
                    <span>程序员自己的问答社区</span>
                    <a class="js-quiz" href="${pageContext.request.contextPath}/createcomment/show" style="font-size: 22px;color: #F7F3F3;">发表话题</a>
                </div>
                <div class="nav">
                    <a href="javascript:void(0);" class="chat active" name="hot">最热</a>
                    <a href="javascript:void(0)" class="chat" name="new">最新</a>
                    <a href="javascript:void(0)" class="chat" name="${userId}">我的话题</a>
                    <!--<a href="/wenda/waitreply">等待回答</a>-->

                </div>
                <!--左侧列表内容-->
                <div class="wenda-list">
                    <%--加载内容--%>
                    <div class="chatContent">
                        <%--<div class="ques-answer">
                            <!--用户头像-->
                            <div class="tag-img">
                                <a href="/wenda/17" target="_blank">
                                    <img src="${pageContext.request.contextPath}/static/staticWEB/img/home/563aff440001e80700900090.jpg" title="JavaScript">
                                </a>
                            </div>
                            <!--用户头像end-->
                            <!--话题标题-->
                            <div class="ques-con">
                                <a href="/wenda/detail/338503" class="ques-con-content" target="_blank"
                                   title="testarea没有value值，那么才能在js中展示呢？">关于testarea的取值问题</a>
                            </div>
                            <!--话题标题end-->

                            <div class="answer-con first" data-answer-id="218070" id="answer-con">
                                <!--话题内容-->
                                <div class="answer-content">
                                    关于testarea的取值问题关于testarea的取值问题关于testarea的取值问题关于testarea的取值问题关于testarea的取值问题
                                    关于testarea的取值问题关于testarea的取值问题关于testarea的取值问题关于testarea的取值问题关于testarea的取值问题
                                    关于testarea的取值问题关于testarea的取值问题关于testarea的取值问题关于testarea的取值问题关于testarea的取值问题
                                </div>
                                <!--话题内容end-->
                                <!--图片-->
                                <div  class="topicimg answer-content">
                                    <img src="${pageContext.request.contextPath}/static/staticWEB/img/home/563aff440001e80700900090.jpg">
                                    <img src="${pageContext.request.contextPath}/static/staticWEB/img/home/552133900001743101800180-100-100.jpg">
                                    <img src="${pageContext.request.contextPath}/static/staticWEB/img/home/552133900001743101800180-100-100.jpg">
                                    <img src="${pageContext.request.contextPath}/static/staticWEB/img/home/563aff440001e80700900090.jpg">

                                </div>
                                <!--图片end-->
                                <div style="position: static;" class="ctrl-bar clearfix">
                                    <!--点赞-->
                                    <a title="赞" href="javascript:;" class="js-pl-praise list-praise r" data-id="82399">
                                        <em class="numShow">赞</em>
                                        <span>90</span>
                                    </a>
                                    <!--点赞end-->
                                    <!--收藏-->
                                    <a title="收藏" href="javascript:;" class="js-pl-praise list-praise r" data-id="82399">
                                        <em class="numShow">收藏</em>
                                        <span>90</span>
                                    </a>
                                    <!--收藏ends-->
                                    <!--评论-->
                                    <a title="评论" href="${pageContext.request.contextPath}/commentdetail/show" class="js-pl-praise list-praise r" data-id="82399">
                                        <em class="numShow">评论</em>
                                        <span>2</span>
                                    </a>
                                    <!--评论end-->
                                    <!--浏览-->
                                    <span class="agree-with " data-ques-id="338503" data-answer-id="218070"
                                          data-hasop="">
                                    <em>108</em>
                                    <b>浏览</b>
                                </span>
                                    <!--浏览end-->
                                    <span class="oppose " data-ques-id="338503" data-answer-id="218070" data-hasop="">
                                    <em>时间：2016-11-17</em>
                                </span>
                                    <span class="shrink">收起</span>
                                </div>
                                <!---->
                            </div><!--.answer-con end-->
                        </div>--%>
                    </div>
                    <%--加载内容--%>
                    <%--页数--%>
                    <div class="page">
                    </div>
                    <%--页数end--%>
                </div>
            </div>
            <!--右边内容end-->
            <!--左边内容-->
            <div class="r wenda-slider">
                <div class="user-about">
                    <div class="user-info">
                        <div class="user-pic">
                            <a href="/u/1361691/bbs">
                                <img src="http://img.mukewang.com/552133900001743101800180-100-100.jpg" alt="哈米的小宇宙">
                            </a>
                        </div>
                        <div class="user-name">
                            <a href="/u/1361691/bbs">哈米的小宇宙</a>
                        </div>
                        <div class="integral-info clearifx">
                            <a href="/u/1361691/credit" class="integral">积分：1</a>
                            <a href="/mall/index" class="integral-mall">积分商城</a>
                        </div>
                    </div><!--.user-info end-->
                    <div class="user-action">
                        <span class="ques"><a href="/u/1361691/bbs">提问</a><!-- <i></i>--></span>
                        <span class="reply"><a href="/u/1361691/bbs?sort=reply">回答</a></span>
                        <span class="follow"><a href="/u/1361691/bbs?sort=follow">关注</a></span>
                    </div><!--.user-action end-->
                </div><!--.user-about end-->
                <div class="hot-ques">
                    <h3 class="title">热门问题</h3>
                    <ul>
                        <li>
                            <p class="content"><a target="_blank" href="/wenda/detail/310803">问答专场
                                |我是讲师Liuyubobobo，你有什么想和我讨论的？</a></p>
                            <div class="info-bar clearfix">
                                <a target="_blank" href="/wenda/detail/310803" class="answer-num">163 回答</a>
                                <a target="_blank" href="/wenda/detail/310803" class="follow-num">28 关注</a>
                                <a target="_blank" href="/wenda/14" class="from">来自 Html5</a>
                            </div>
                        </li>
                        <li>
                            <p class="content"><a target="_blank" href="/wenda/detail/328864">本人13岁，现在学还来得及吗？</a></p>
                            <div class="info-bar clearfix">
                                <a target="_blank" href="/wenda/detail/328864" class="answer-num">139 回答</a>
                                <a target="_blank" href="/wenda/detail/328864" class="follow-num">4 关注</a>
                                <a target="_blank" href="/wenda/2" class="from">来自 PHP</a>
                            </div>
                        </li>
                        <li>
                            <p class="content"><a target="_blank" href="/wenda/detail/327235">前端找不到实习，想放弃了怎么办?</a></p>
                            <div class="info-bar clearfix">
                                <a target="_blank" href="/wenda/detail/327235" class="answer-num">114 回答</a>
                                <a target="_blank" href="/wenda/detail/327235" class="follow-num">29 关注</a>
                                <a target="_blank" href="/wenda/17" class="from">来自 JavaScript</a>
                            </div>
                        </li>
                        <li>
                            <p class="content"><a target="_blank" href="/wenda/detail/338299">java好学吗.??pp</a></p>
                            <div class="info-bar clearfix">
                                <a target="_blank" href="/wenda/detail/338299" class="answer-num">61 回答</a>
                                <a target="_blank" href="/wenda/detail/338299" class="follow-num">3 关注</a>
                                <a target="_blank" href="/wenda/3" class="from">来自 JAVA</a>
                            </div>
                        </li>
                    </ul><!--ul end-->
                </div><!--.hot-ques end-->
            </div>
            <!--左边内容end-->
        </div>
    </div>
</div>
<!--图片放大-->
<div id="popup">
    <div class="bg"><img src="" alt=""/></div>
</div>
<!--图片放大end-->
<!--内容end-->
<%--尾部--%>
<jsp:include page="include/footer.jsp"></jsp:include>
<%--尾部end--%>
<!--加载js-->
<script src="${pageContext.request.contextPath}/static/public/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/public/js/chat/chatpage.js"></script>
<script type="text/javascript">

</script>
</body>
</html>
