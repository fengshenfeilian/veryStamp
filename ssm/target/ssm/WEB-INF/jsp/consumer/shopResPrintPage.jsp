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
        <li class="dash"><a href="/consumer/showInfo" class="" title=""><span>信息管理</span></a>
            <ul class="sub">
                <li ><a href="/consumer/showInfo" title="">我的信息</a></li>
                <li class=""><a href="/consumer/gochangepassword" title="">修改密码</a></li>
            </ul>
        </li>
        <li class="tables"><a href="#" title="" class="active"><span>新建订单</span></a>
            <ul class="sub">
                <li class="this"><a href="/consumer/printShopOrder" title="">打印店家资源</a></li>
                <li class=""><a href="/consumer/printMyOrder" title="">打印自有资源</a></li>
            </ul>
        </li>
        <li class="tables"><a href="/consumer/myOrder" title="" class=""><span>我的订单</span></a></li>
        <li class="tables"><a href="/consumer/showcredit" title="" class=""><span>财务管理</span></a>
        </li>
    </ul>
</div>

<!-- 右侧区域 -->
<div id="rightSide">
    <!-- 顶部导航栏 -->
    <div class="topNav">
        <div class="wrapper">
            <div class="welcome"><a href="#" title=""><img src="/static/images/userPic.png" alt="" /></a><span>欢迎<strong>【<c:out value="${consumer.userName}"/>】</strong>使用本系统</span></div>

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

    <div class="line"></div>

    <div class="wrapper">
        <div class="widget">
            <div class="title"><img src="/static/images/icons/dark/frames.png" alt="" class="titleIcon" /><h6>资源信息</h6></div>
            <div class="formRow">
                <label style="width: 10%">资源名称</label>
                <label>${resource.resName}</label>
                <div class="clear"></div>
            </div>
            <div class="formRow">
                <label style="width: 10%">打印店</label>
                <label>${shop.userName}</label>
                <div class="clear"></div>
            </div>
            <div class="formRow">
                <label style="width: 10%">单份页数</label>
                <label>${resource.pageCount}</label>
                <div class="clear"></div>
            </div>
            <div class="formRow">
                <label style="width: 10%">资源价格</label>
                <label>${resource.totalPrice}</label>
                <div class="clear"></div>
            </div>
            <div class="formRow">
                <label style="width: 10%">资源描述</label>
                <label>${resource.description}</label>
                <div class="clear"></div>
            </div>
        </div>
    </div>

    <%--表单：打印当前资源--%>
    <div class="wrapper">
        <div class="widget">
            <div class="formRow"><h5>打印</h5></div>
            <form action="${pageContext.request.contextPath}/consumer/createShopResOrder?resId=${resource.resId}" id="validate" method="post" enctype="multipart/form-data">
                <fieldset>
                    <div class="formRow">
                        <label for="printLayout" style="width:10%">打印格式</label>
                        <select class="validate[required]" id="printLayout" name="printLayout" >
                            <option value="single" selected="selected">单面</option>
                            <option value="double">双面</option>
                        </select>
                        <div class="clear"></div>
                    </div>
                    <div class="formRow">
                        <label for="printNumber" style="width:10%">打印份数</label>
                        <input type="number" name="printNumber" class="validate[required]" id="printNumber" min="1" value="1" style="width:16%"/>
                        <div class="clear"></div>
                    </div>
                    <div class="formRow">
                        <label for="getTime" style="width:10%">取货时间</label>
                        <input type="datetime-local" name="getTime" class="validate[required]" id="getTime" style="width:16%"/>
                        <div class="clear"></div>
                    </div>
                    <div class="formRow">
                        <input type="submit" value="创建订单" class="blueB logMeIn" />
                        <div class="clear"></div>
                    </div>
                </fieldset>
            </form>
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