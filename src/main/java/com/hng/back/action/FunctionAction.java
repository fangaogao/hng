package com.hng.back.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hng.base.BaseAction;
import com.hng.entity.Functions;
import com.hng.entity.Users;
import com.hng.service.IFunctionService;
import com.hng.util.Constants;
import com.hng.util.ControllerUtil;

@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction {
	@Autowired
	private IFunctionService funService;
	private Functions fun;
	private String result;
	
	//功能管理页面
	public String index() throws Exception {
		Users user = (Users) session.getAttribute(Constants.CURRENT_USER);
		if (user == null)
			return ERROR;
		return SUCCESS;
	}
	
	
	//获取功能列表
	public void getFunctions() throws Exception{
		// 分页信息
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int maxResults = StringUtils.isBlank(rows) ? 20 : Integer.parseInt(rows);
		int firstResult = StringUtils.isBlank(page) ? 0 : (Integer.parseInt(page) - 1) * maxResults;
		ControllerUtil.out(response, funService.getFunctions(fun, firstResult, maxResults));
	}
	
	public Functions getFun() {
		return fun;
	}


	public void setFun(Functions fun) {
		this.fun = fun;
	}


}
