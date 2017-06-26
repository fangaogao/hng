package com.hng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hng.bean.Page;
import com.hng.dao.IDao;
import com.hng.entity.Roles;
import com.hng.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IDao dao;
	
	//获取角色列表
	@Override
	public Page getRoleList(Roles role, int firstResult, int maxResults) {
		String hql = "from Roles role";
		List<Roles> roles = dao.query(hql, null, firstResult, maxResults);
		int count = dao.queryCount(hql, null);
		Page page = new Page();
		page.setResult(roles);
		page.setTotal(count);
		return page;
	}

}
