<%@ page language="java" pageEncoding="UTF-8" %>
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
    <!-- Shared on MafiaShare.net  --><!-- Shared on MafiaShare.net  -->
</head>

<body>

<!-- 左侧菜单栏 -->
<div id="leftSide">
    <div class="logo"><a href="/student/home"><img src="/static/images/logo.png" alt="" /></a></div>

    <div class="sidebarSep"></div>

    <!-- 左侧导航栏 -->
    <ul id="menu" class="nav">
        <li class="tables"><a href="/user/registerPage" ><span>用户注册</span></a></li>
        <li class="tables"><a href="/user/shopRegisterPage" class="active"><span>商户注册</span></a></li>

    </ul>
</div>

<div id="rightSide">
    <!-- 导航栏 -->
    <div class="topNav">
        <div class="wrapper">
            <div class="userNav">
                <ul>
                    <li><a href="/user/loginPage" title=""><img src="/static/images/icons/topnav/mainWebsite.png" alt="" /><span>登录</span></a></li>
                    <li><a href="/user/registerPage" title=""><img src="/static/images/icons/topnav/profile.png" alt="" /><span>注册</span></a></li>
                    <li><a href="/user/contactPage" title=""><img src="/static/images/icons/topnav/profile.png" alt="" /><span>联系我们</span></a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <div class="line"></div>
    <div class="wrapper">
        <div class="widget">
            <form  method="post" id="validate" class="form" action="${pageContext.request.contextPath}/user/shopRegister" enctype="multipart/form-data">
                <%-- 邮箱号必须全局唯一 --%>
                <div class="formRow">
                    <label style="width:10%">邮箱</label>
                    <input type="text" class="validate[required,custom[email]]" name="emailValid" id="emailValid"/>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label style="width:10%">商户名</label>
                    <input type="text" name="userName"/>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label style="width:10%">手机号</label>
                    <input type="text" class="validate[required,custom[onlyNumberSp]]" name="numsValid" id="numsValid"/>
                    <div class="clear"></div>
                </div>

                <div class="formRow">
                    <label style="width:10%">联系地址</label>
                    <input type="text" name="address"/>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label for="pass">单面打印价格</label>
                    <div class="loginInput"><input type="text" name="singlePagePrice" class="validate[required]" id="pass" /></div>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label for="pass">双面打印价格</label>
                    <div class="loginInput"><input type="text" name="doublePagePrice" class="validate[required]" id="pass" /></div>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label style="width:10%">密码</label>
                    <input type="password" class="validate[required]" name="password1" id="password1"/>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label style="width:10%">确认密码</label>
                    <input type="password" class="validate[required,equals[password1]]" name="password2" id="password2"/>
                    <div class="clear"></div>
                </div>

                <div class="formRow">
                    <label style="width:10%">营业开始时间</label>
                    <input type="time" name="startTime"/>
                    <div class="clear"></div>
                </div>
                <div class="formRow">
                    <label style="width:10%">营业截止时间</label>
                    <input type="time" name="endTime"/>
                    <div class="clear"></div>
                </div>

                <div class="loginControl">
                    <input type="submit" value="注册" class="dblueB logMeIn" />
                    <div class="clear"></div>
                </div>
            </form>
        </div>
    </div>

    <!-- Footer line -->
    <div id="footer">
        <div class="wrapper">All right reserved by Marco</div>
    </div>
</div>






</body>
</html>