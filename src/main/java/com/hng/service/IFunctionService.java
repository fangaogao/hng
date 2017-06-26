package com.hng.service;

import java.util.List;

import com.hng.bean.Page;
import com.hng.entity.Functions;
import com.hng.entity.Roles;

public interface IFunctionService {
	/**
	 * 获取该角色的权限
	 * @param role
	 * @return
	 */
	public List<Functions> getRoleFuns(Roles role);
	
	/**
	 * 获取所有权限
	 * @return
	 */
	public Page getFunctions(Functions fun,int firstResult, int maxResults);
	
	
}
