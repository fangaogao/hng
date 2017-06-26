package com.hng.back.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hng.base.BaseAction;
import com.hng.entity.Roles;
import com.hng.entity.Users;
import com.hng.service.IRoleService;
import com.hng.util.Constants;
import com.hng.util.ControllerUtil;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction {
	@Autowired
	private IRoleService roleService;
	private Roles role;
	private String result;
	
	//角色管理页面
	public String index() throws Exception {
		Users user = (Users) session.getAttribute(Constants.CURRENT_USER);
		if (user == null)
			return ERROR;
		return SUCCESS;
	}
	//获取角色列表
	public void getRoleList() throws Exception{
		// 分页信息
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int maxResults = StringUtils.isBlank(rows) ? 10 : Integer.parseInt(rows);
		int firstResult = StringUtils.isBlank(page) ? 0 : (Integer.parseInt(page) - 1) * maxResults;
		ControllerUtil.out(response, roleService.getRoleList(role, firstResult, maxResults));
	}
	
	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

}
