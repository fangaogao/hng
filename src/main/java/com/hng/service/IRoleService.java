package com.hng.service;

import com.hng.bean.Page;
import com.hng.entity.Roles;

public interface IRoleService {

	/**
	 * 获取角色列表
	 * @return
	 */
	public Page getRoleList(Roles role,int firstResult, int maxResults);
}
