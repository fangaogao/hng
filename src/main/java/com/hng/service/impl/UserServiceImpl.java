package com.hng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hng.dao.IDao;
import com.hng.entity.Roles;
import com.hng.entity.Users;
import com.hng.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	/**
	 * 注入dao
	 */
	@Autowired
	private IDao dao;
	
	/**
	 * 登录
	 * @param user 要登录的用户信息
	 * @return 返回登录成功者的信息，为null则登录不成功
	 */
	@Override
	public Users login(Users user) {
		String hql = "from Users u where u.loginName=? or u.email=? and u.password=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getLoginName());
		params.add(user.getLoginName());
		params.add(user.getPassword());
		List users = dao.query(hql, params);
		if(users!=null&&users.size()>0){
			return (Users)users.get(0);
		}
		return null;
	}

	@Override
	//注册
	public Users register(Users user) {
		user.setRoles(new Roles(4));
		user.setRoleName("会员");
		user.setStatus("1");
		dao.save(user);
		return user;
	}
	
	//用户名是否已存在
	@Override
	public boolean isReName(Users user) {
		String hql = "from Users u where u.loginName=?";
		List<Users> users = dao.query(hql, user.getLoginName());
		if(users!=null&&users.size()>0)
			return true;
		return false;
	}
	//邮箱是否已存在
	@Override
	public boolean isReEmail(Users user) {
		String hql = "from Users u where u.email=?";
		List<Users> users = dao.query(hql, user.getEmail());
		if(users!=null&&users.size()>0)
			return true;
		return false;
	}

}
