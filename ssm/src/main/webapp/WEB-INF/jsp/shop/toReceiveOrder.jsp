<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
    <title>好打印</title>
    <link href="/static/css/main.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="/static/js/jquery.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/spinner/ui.spinner.js"></script>
    <script type="text/javascript" src="/static/js/plugins/spinner/jquery.mousewheel.js"></script>

    <script type="text/javascript" src="/static/js/jquery-ui.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/charts/excanvas.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.flot.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.flot.orderBars.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.flot.pie.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.flot.resize.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.sparkline.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/forms/uniform.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.cleditor.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.validationEngine-en.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.validationEngine.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.tagsinput.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/autogrowtextarea.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.maskedinput.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.dualListBox.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.inputlimiter.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/chosen.jquery.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/wizard/jquery.form.js"></script>
    <script type="text/javascript" src="/static/js/plugins/wizard/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/wizard/jquery.form.wizard.js"></script>

    <script type="text/javascript" src="/static/js/plugins/uploader/plupload.js"></script>
    <script type="text/javascript" src="/static/js/plugins/uploader/plupload.html5.js"></script>
    <script type="text/javascript" src="/static/js/plugins/uploader/plupload.html4.js"></script>
    <script type="text/javascript" src="/static/js/plugins/uploader/jquery.plupload.queue.js"></script>

    <script type="text/javascript" src="/static/js/plugins/tables/datatable.js"></script>
    <script type="text/javascript" src="/static/js/plugins/tables/tablesort.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/tables/resizable.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/ui/jquery.tipsy.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.collapsible.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.progress.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.timeentry.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.colorpicker.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.jgrowl.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.breadcrumbs.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.sourcerer.js"></script>

    <script type="text/javascript" src="/static/js/plugins/calendar.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/elfinder.min.js"></script>

    <script type="text/javascript" src="/static/js/custom.js"></script>

    <script type="text/javascript" src="/static/js/charts/chart.js"></script>

    <!-- Shared on MafiaShare.net  --><!-- Shared on MafiaShare.net  -->
</head>

<body>
<!-- 左侧菜单栏 -->
<div id="leftSide">
    <div class="logo"><a href="/student/home"><img src="/static/images/logo.png" alt="" /></a></div>

    <div class="sidebarSep mt0"></div>

    <!-- 搜索框 -->
    <form action="" class="sidebarSearch">
        <input type="text" name="search" placeholder="search..." id="ac" />
        <input type="submit" value="" />
    </form>

    <div class="sidebarSep"></div>

    <!-- 左侧导航栏 -->
    <ul id="menu" class="nav">
        <li class="dash"><a href="/shop/showInfo" title=""><span>信息管理</span></a></li>
        <li class="tables"><a href="#" title="" class="active"><span>订单管理</span></a>
            <ul class="sub">
                <li class="this"><a href="/shop/showToPrintOrder" title="">待打印订单</a></li>
                <li><a href="/shop/showToReceiveOrder" title="">待取货订单</a></li>
                <li><a href="/shop/showCompletedOrder" title="">已完成订单</a></li>
            </ul>
        </li>
        <li class="tables"><a href="/shop/showResources"><span>资源管理</span></a>
        </li>
        <li class="tables"><a href="/shop/shopStatistics"><span>营业统计</span></a>
        </li>
    </ul>
</div>

<!-- 右侧区域 -->
<div id="rightSide">
    <!-- 顶部导航栏 -->
    <div class="topNav">
        <div class="wrapper">
            <div class="welcome"><a href="#" title=""><img src="/static/images/userPic.png" alt="" /></a><span>欢迎<strong>【<c:out value="${shop.userName}"/>】</strong>使用本系统</span></div>

            <div class="userNav">
                <ul>
                    <li><a href="#" title=""><img src="/static/images/icons/topnav/profile.png" alt="" /><span>账户</span></a></li>
                    <li><a href="#" title=""><img src="/static/images/icons/topnav/settings.png" alt="" /><span>设置</span></a></li>
                    <li><a href="../../login.jsp" title=""><img src="/static/images/icons/topnav/logout.png" alt="" /><span>注销</span></a></li>
                </ul>
            </div>

            <div class="clear"></div>
        </div>
    </div>

    <div class="wrapper">
        <div class="widget">
            <div class="title"><img src="" alt="" class="titleIcon" /><h6>修改订单资源页数</h6></div>
            <form action="${pageContext.request.contextPath}/shop/modifyPageCount" method="post" class="form">
                <fieldset>
                    <div class="formRow">
                        <label for="login">订单号</label>
                        <div class="loginInput"><input type="text" name="orderId" class="validate[required]" id="login" /></div>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label for="pass">单份页数</label>
                        <div class="loginInput"><input type="text" name="pageCount" class="validate[required]" id="pass" /></div>
                        <div class="clear"></div>
                    </div>

                    <div class="loginControl">
                        <input type="submit" value="修改页数" class="dredB logMeIn" />
                        <div class="clear"></div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
    <%--动态数据表--%>
    <div class="wrapper">
        <div class="widget">
            <div class="title"><img src="/static/images/icons/dark/frames.png" alt="" class="titleIcon" /><h6>待收货订单</h6></div>
            <table cellpadding="0" cellspacing="0" width="100%" class="display dTable" id="res1">
                <thead>
                <tr>
                    <td class="sortCol"><div>订单号<span></span></div></td>
                    <td class="sortCol"><div>下单时间<span></span></div></td>
                    <td class="sortCol"><div>资源名<span></span></div></td>
                    <td class="sortCol"><div>打印格式<span></span></div></td>
                    <td class="sortCol"><div>份数<span></span></div></td>
                    <td class="sortCol"><div>总页数<span></span></div></td>
                    <td class="sortCol"><div>总价<span></span></div></td>
                    <td class="sortCol"><div>预计取货时间<span></span></div></td>
                    <td class="sortCol"><div>操作<span></span></div></td>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.orderTime}</td>
                        <td>${order.resourceName}</td>
                        <td>${order.printFormat}</td>
                        <td>${order.printCount}</td>
                        <td>${order.totalPageCount}</td>
                        <td>${order.totalPrice}</td>
                        <td>${order.targetTakeTime}</td>
                        <td><a href="/shop/confirmReceive?orderId=${order.orderId}"><button class="blueB">打印</button></a></td>
                    </tr>
                </c:forEach>
                <c:if test="${message != null}">
                    <p>${message}</p>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>



    <!-- Footer line -->
    <div id="footer">
        <div class="wrapper">All rights reserved by <a href="http://hashmap.me">Marco Hao</a></div>
    </div>



    <div class="clear"></div>
</div>
</body>
</html>