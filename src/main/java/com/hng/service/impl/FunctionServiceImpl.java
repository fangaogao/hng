package com.hng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hng.bean.Page;
import com.hng.dao.IDao;
import com.hng.entity.Functions;
import com.hng.entity.Roles;
import com.hng.entity.vo.FunctionVO;
import com.hng.service.IFunctionService;

@Service("functionService")
public class FunctionServiceImpl implements IFunctionService {
	@Autowired
	private IDao dao;
	
	//获取该角色的权限
	@Override
	public List<Functions> getRoleFuns(Roles role) {
		//先获取一级功能列表
		String hql = "select rf.functions from RoleFunction rf where rf.roles.roleId=? and LENGTH(rf.functions.levelCode)=2 "
				+ " and rf.roles.roleStatus=1 and rf.functions.funStatus=1";
		List<Functions> funs = dao.query(hql, role.getRoleId());
		//根据一级功能列表找二级功能列表
		for (Functions fun : funs) {
			String thql = "select rf.functions from RoleFunction rf where rf.roles.roleId=? and rf.functions.functions.functionId=?"
					+ " and rf.roles.roleStatus=1 and rf.functions.functions.funStatus=1";
			List<Object> params = new ArrayList<Object>();
			params.add(role.getRoleId());
			params.add(fun.getFunctionId());
			List<Functions> funs2 = dao.query(thql, params);
			fun.setFunctionses(funs2);
		}
		return funs;
	}

	//获取权限列表
	@Override
	public Page getFunctions(Functions fun,int firstResult, int maxResults) {
		String hql = "select new com.hng.entity.vo.FunctionVO(fun,fun.functions.functionId) from Functions fun";
		List<FunctionVO> funs = dao.query(hql, null, firstResult, maxResults);
		int count = dao.queryCount(hql, null);
		Page page = new Page();
		page.setResult(funs);
		page.setTotal(count);
		return page;
	}

}
