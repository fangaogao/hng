package com.hng.front.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.hng.base.BaseAction;
import com.hng.entity.Member;
import com.hng.entity.Users;
import com.hng.service.IMemberService;
import com.hng.service.IUserService;
import com.hng.util.Constants;

@Controller
@Scope("prototype")
public class IUserAction extends BaseAction {
	@Autowired
	private IUserService userService;
	@Autowired
	private IMemberService memberService;
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
	
	//用户注册
	public String register() throws Exception {
		if(user!=null){
			//邮箱注册，忽略大小写
			user.setLoginName(user.getLoginName().toLowerCase());
			//若用户名已存在则返回错误信息
			if(userService.isReName(user)){
				request.setAttribute("regMsg", "该用户名已被注册过!");
				result =  ERROR;
			}else if(userService.isReEmail(user)){
				request.setAttribute("regMsg", "该邮箱已被注册过!");
				result =  ERROR;
			}else{
				//保存用户信息
				userService.register(user);
				//保存会员信息
				memberService.saveMember(user);
				result = SUCCESS;
			}
		}else{
			result = ERROR; 
		}
		return result;
	}
	
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
}
