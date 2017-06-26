<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%request.setAttribute("base", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>襄阳市惠农谷信息服务平台-无法完成操作</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Cache-Control" content="No-cache" />
		<style rel="stylesheet">
img { border:none;}

/* 内容 */
.full{width:600px; position:absolute;top: 50%;left:50%;margin-left: -300px;margin-top: -220px;}
.full dl.error{width:560px;  background:url(${base}/public/result/404/pic_contbg.gif) 0 0 repeat-y; border-bottom:1px solid #ebebeb;}
.full dl.error dt{height:44px; line-height:44px;  background:url(${base}/public/result/404/pic_bg.gif) -20px -18px no-repeat; text-align:left; padding:0 15px; vertical-align:center;}
.full dl.error dt img{padding-top:13px; width:167px; height:20px;  background:url(${base}/public/result/404/pic_bg.gif) -20px -309px no-repeat;}
.full dl.error dd{text-align:center;}
.full dl.error dd span.error404{padding:50px 30px 40px 0; display:inline-block;}
.full dl.error dd span.error404 img{width:203px; height:76px;  background:url(${base}/public/result/404/pic_bg.gif) -176px -130px no-repeat;}

.full dl.error dd span.error500{padding:50px 10px 40px 0; display:inline-block;}
.full dl.error dd span.error500 img{width:203px; height:76px;  background:url(${base}/public/result/404/pic_bg.gif) -20px -375px no-repeat;}

.full dl.error dd span.errortext404{padding:85px 0 40px 0; display:inline-block;}
.full dl.error dd span.errortext404 img{width:122px; height:39px;  background:url(${base}/public/result/404/pic_bg.gif) -426px -130px no-repeat;}

.full dl.error dd span.errortext500{padding:85px 0 40px 0; display:inline-block;}
.full dl.error dd span.errortext500 img{width:250px; height:39px;  background:url(${base}/public/result/404/pic_bg.gif) -240px -375px no-repeat;}

.full dl.error dd span.btn_back{padding:0 0 50px 0; display:inline-block;}
.full dl.error dd span.btn_back img{width:122px; height:42px;  background:url(${base}/public/result/404/pic_bg.gif) -432px -179px no-repeat;}

.full dl.error ul.error li {
	font-family : cursive;
	list-style :none;
	text-align: left; 
	background:url(${base}/public/result/404/pic-error-nav.gif) 0px center no-repeat; 
	padding-left: 20px;
}

/***弹出窗口***/
.error_pop{width:360px; border:1px solid #bebebe; background:#f5f5f5; padding:20px; text-align:center; top:50%; }
.error_pop .left{width:120px; padding-right:20px; display:inline-block;}
.error_pop .left img.error{width:120px; height:119px;  background:url(${base}/public/result/404/pic_bg.gif) -20px -90px no-repeat;}
.error_pop .right{width:166px; padding:0; display:inline-block; vertical-align:top; padding-top:30px;}
.error_pop .right img.text{margin-bottom:20px; width:166px; height:18px;  background:url(${base}/public/result/404/pic_bg.gif) -20px -258px no-repeat;}
.error_pop .right img.close{cursor:pointer;  width:87px; height:32px;  background:url(${base}/public/result/404/pic_bg.gif) -222px -251px no-repeat;}

.mesWindow{width:402px; height:162px;}
</style>
	<script type="text/javascript">
	function nav_list(id, style) {
		var id=document.getElementById(id);
		id.style.display= style;
	}
	var isIe=(document.all)?true:false;
	//设置select的可见状态
	function setSelectState(state) {
		var objl=document.getElementsByTagName('select');
		for(var i=0;i<objl.length;i++) {
			objl[i].style.visibility=state;
		}
	}
	function mousePosition(ev) {
		if(ev.pageX || ev.pageY) {
			return {x:ev.pageX, y:ev.pageY};
		}
		return {
			x:ev.clientX + document.body.scrollLeft - document.body.clientLeft,y:ev.clientY + document.body.scrollTop - document.body.clientTop
		};
	}
	//弹出方法
	function showMessageBox(wTitle,content,pos,wWidth) {
		closeWindow();
		var bWidth=parseInt(document.documentElement.scrollWidth);
		var bHeight=parseInt(document.documentElement.scrollHeight);
	
		if(isIe){
			setSelectState('hidden');
		}
		if(document.getElementById('back')!=null) //如果弹出层存在
		{
			document.getElementById('back').style.display = ""; //就让弹出层显示出来
		}
		else{
			var back=document.createElement("div");       //否则就创建新的层
			back.id="back";
			//var styleStr="top:0px;left:0px;position:absolute;background:#666;width:"+bWidth+"px;height:"+bHeight+"px;";
			var styleStr="top:0px;left:0px;position:fixed;background:#666;width:100%;height:100%;";
			styleStr+=(isIe)?"filter:alpha(opacity=0);":"opacity:0;";
			back.style.cssText=styleStr;
			document.body.appendChild(back);
			showBackground(back,50);
		}
		var mesW=document.createElement("div");
		mesW.id="mesWindow";
		mesW.className="mesWindow";
		mesW.innerHTML=content;
		var v_top=(document.body.clientHeight-mesW.clientHeight)/2;
		v_top+=document.documentElement.scrollTop;
		document.body.appendChild(mesW);
		styleStr="top:"+(document.body.clientHeight/2-mesW.clientHeight/2)+"px;left:"+(document.body.clientWidth/2-mesW.clientWidth/2)+"px;position:fixed;left:50%; top:50%; z-index:9999; margin-left:-"+(mesW.offsetWidth / 2)+"px; margin-top:-"+(mesW.offsetHeight / 2)+"px;";
		mesW.style.cssText=styleStr;
	}
	//让背景渐渐变暗
	function showBackground(obj,endInt) {
		if(isIe) {
			obj.filters.alpha.opacity+=5;
			if(obj.filters.alpha.opacity<endInt) {
				setTimeout(function(){showBackground(obj,endInt)},5);
			}
		}else{
			var al=parseFloat(obj.style.opacity);al+=0.05;
			obj.style.opacity=al;
			if(al<(endInt/100)) {
				setTimeout(function(){showBackground(obj,endInt)},5);
			}
		}
	}
	//关闭窗口
	function closeWindow() {
		if(document.getElementById('back')!=null) {
			document.getElementById('back').style.display="none";
			//document.getElementById('back').parentNode.removeChild(document.getElementById('back'));
		}
		if(document.getElementById('mesWindow')!=null) {
			document.getElementById('mesWindow').parentNode.removeChild(document.getElementById('mesWindow'));
		}
		if(isIe){
			setSelectState('');
		}
	}
	//测试弹出
	function testMessageBox(ev) {
		var objPos = mousePosition(ev);
		messContent="<div class='error_pop'><span class='left'><img src='${base}/public/result/404/pic_dot.gif' alt='404' title='404' class='error' /></span><span class='right'><img src='${base}/public/result/404/pic_dot.gif' class='text' alt='您访问的地址不存在' title='您访问的地址不存在' /><img src='${base}/public/result/404/pic_dot.gif' alt='关闭' title='关闭' onclick='closeWindow();' class='close' /></span></div>";
		showMessageBox('窗口标题',messContent,objPos,350);
	}
	</script>
</head>

<body leftmargin=0 topmargin=0>
	<center>
		<div class="full">
			<dl class="error">
				<dt><img src="${base}/public/result/404/pic_dot.gif" alt="  提示页面" title="  提示页面" /></dt>
				<dd>
					<span class="error500">
						<img src="${base}/public/result/404/pic_dot.gif" alt="500" title="500" />
					</span>
					<span class="errortext500">
					<img src="${base}/public/result/404/pic_dot.gif" alt="你懂的" title="你懂的" />
					</span>
				</dd>
				<s:actionerror cssClass="error"/>
				<dd style="margin-top: 30px;">
					<span class="btn_back">
						<a href="#" onclick="history.back();return false;" target="blank">
							<img src="${base}/public/result/404/pic_dot.gif" alt="返回" title="返回" />
						</a>
					</span>
				</dd>
			</dl>
		</div>
	</center>
</body>
</html>
