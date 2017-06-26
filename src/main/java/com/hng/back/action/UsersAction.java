package com.hng.back.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.hng.base.BaseAction;
import com.hng.entity.Functions;
import com.hng.entity.Users;
import com.hng.service.IFunctionService;
import com.hng.service.IUserService;
import com.hng.util.Constants;

@Controller
@Scope("prototype")
public class UsersAction extends BaseAction {
	@Autowired
	private IUserService userService;
	@Autowired
	private IFunctionService functionService;
	private Users user;

	public String result = ERROR;
	
	// 用户登录
	public String login() throws Exception {
		if(user!=null&&user.getLoginName()!=null&&StringUtils.hasText(user.getLoginName())
				&&user.getPassword()!=null&&StringUtils.hasText(user.getPassword())){		
			user = userService.login(user);
			if(user!=null){
				//账户是可用状态，将当前用户信息存入session中
				if(user.getStatus()!=null&&"1".equals(user.getStatus())){
					request.getSession().setAttribute(Constants.CURRENT_USER, user);
					//获取该角色的权限
					List<Functions> funs = functionService.getRoleFuns(user.getRoles());
					request.getSession().setAttribute(Constants.USER_FUNS, funs);
					result =  SUCCESS;
				}else{
					request.setAttribute("loginMsg", "当前账户不可用");
					result =  ERROR;
				}
			}else{
				request.setAttribute("loginMsg", "用户名或密码错误");
				result =  ERROR;
			}
		}else{
			result =  ERROR;
		}		
		return result;
	}
	
	//用户注销
	public String logout() throws Exception {
		if(user!=null){
			request.getSession().removeAttribute(Constants.CURRENT_USER);
			request.getSession().removeAttribute(Constants.USER_FUNS);
		}
		return SUCCESS;
	}
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
}
