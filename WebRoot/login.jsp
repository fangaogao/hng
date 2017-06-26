<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>

<!-- 样式 -->
<link rel="stylesheet" type="text/css" href="back/css/login.css">

<!-- js -->
<script src="back/js/jquery/jquery-1.11.0.min.js"></script>
<script src="back/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript">
	$("#submit").click(function() {
		$("#loginForm").submit();
	});
	
</script>
</head>

<body id="signup"  >
	<img src="back/icon/beijing.jpg" class="back"/>
	<div class="container">
		<div class="row header">
			<div class="col-md-12">
				<h3 class="logo">
					<a>襄阳市惠农谷信息服务平台</a>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="wrapper clearfix">
					<div class="formy">
						<div class="row">
							<div class="col-md-12">
								<form id="loginForm" role="form" action="back/login.action"
									method="post">	
            								<p id="errorinfo" class="errorinfo"><span style="color:red;">${loginMsg }</span></p>	
            						
									<div class="form-group">			
										<span class="input-group-addon"><span
											class="icon icon-user"></span></span> <input type="text"
											class="form-control" id="userId" name="user.loginName"
											placeholder="用户名" />
									</div>
									<div class="form-group">
										<span class="input-group-addon"><i
											class="icon icon-lock"></i></span> <input type="password"
											class="form-control" id="password" name="user.password"
											placeholder="密码" />
									</div>
									<div class="submit">
										<button class="btn solid blue lbtn"  type="submit"
											style="width: 100px;">登 录</button>
									</div>
									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	function showErrorMsg() {
		var session_value = '<%=session.getAttribute("com.globalite.claim.errorkey")%>';
		if (session_value == null||session_value==undefined||session_value=="null"){
			return;
		}
		var errorinfo_p = document.getElementById("errorinfo");
		errorinfo_p.innerHTML = "<span style='color:red;'>"+session_value+"</span>";
	}
	showErrorMsg();
</script>
</body>
</html>