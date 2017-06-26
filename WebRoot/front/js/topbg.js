var passportUrl = "";
$(document).ready(function(){
    var userId=null;
    var username=null;
    var local = document.location.href ;
    var index = local.indexOf(".cn/") ;
    index = index < 0 ? (local.indexOf(".com") + ".com/".length) : ( index + ".cn/".length);
    var sdomain = local.substring(0,index + 1);
    var domain = 'cnhnb.com';

    passportUrl = "";

    if(sdomain.indexOf("cnhnkj") >= 0){
        domain = 'cnhnkj.cn';
        passportUrl = "";
    }else if(sdomain.indexOf("zym888") >= 0){
        domain = 'zym888.com';
        //passportUrl = "http://passport.zym888.com";
        passportUrl = "";
    }else if(sdomain.indexOf("lvsema") >= 0){
        domain = 'lvsema.cn';
        //passportUrl = "http://passport.zym888.com";
        passportUrl = "";
    }
    //请登录链接
    if($(".tp-log")){
        var loginObj = $(".tp-log a");
        loginObj.each(function(){
            var loginUrl =  $(this).attr("href");
            if(typeof(logoutUrl) != undefined && loginUrl.indexOf("returnUrl")>=0){
                $(this).attr("href",loginUrl.replace(loginUrl.split("returnUrl=")[1],local));
            }
        });
    }

    get(passportUrl);

    //退出登录链接

    if($(".manage-buy")){
        var operObj = $(".manage-buy dd a");
        operObj.each(function(index){
            var logoutUrl = $(this).attr("href");
            if(typeof(logoutUrl) != undefined && logoutUrl.indexOf("returnUrl")>=0){
                $(this).attr("href",logoutUrl.replace(logoutUrl.split("returnUrl=")[1],local));
            }
        });
    }


    //登录
    $("#topmenu_wel .tp-tit").hover(function(){
        $(this).addClass("hover").find("div.tp-cont").show();
    },function(){
        $(this).removeClass("hover").find("div.tp-cont").hide();
    });

    //鼠标透明效果
    $("#topmenu li").hover(function(){
        $(this).addClass("hover").find("div.tp-cont").show();
    },function(){
        $(this).removeClass("hover").find("div.tp-cont").hide();
    });

});

function get(passportUrl){
    $.ajax({
        url: passportUrl + "/loginInfo",  // 跨域URL   
        type: 'POST',
        dataType: 'jsonp',
        jsonp : "callback",
        jsonpCallback: "getLoginUserInfo",
        success: function (data) {
            if(data){
                userId = data.userId;
                username = data.username;
                if(userId!=null&&userId!=""){
                    $(".topbar-name").show();
                    $(".userName").html(username);
                    $(".topbar-login").hide();
                    //QQd登录弹出框
                    if($("#userLoginToolbar")){
                        $("#userLoginToolbar").hide();
                    }
                    //系统未读消息
                    $.getJSON(passportUrl + "/loginInfo/getusermsg?userid='"+userId+"'&callback=?", function(data) {
                        if (data.success) {
                            $(".msgnum").html(data.msgcount);
                        } else {
                            $(".msgnum").html(0);
                        }
                    });
                    $("#releaseLogin").show();
                    $("#releaseNoLogin").hide();
                    startpush();
                }else{
                    $(".topbar-name").hide();
                    $(".topbar-login").show();
                    $("#releaseLogin").hide();
                    $("#releaseNoLogin").show();
                    if($("#userLoginToolbar")){
                        $("#userLoginToolbar").shoe();
                    }
                }
            }else{
                $(".topbar-name").hide();
            }
        }
    });
};
function getLoginUserInfo(data){};

