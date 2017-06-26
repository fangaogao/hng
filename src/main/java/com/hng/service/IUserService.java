package com.hng.service;

import com.hng.entity.Users;

public interface IUserService {
	/**
	 * 登录
	 * @param user 要登录的用户信息
	 * @return 返回登录成功者的信息，为null则登录不成功
	 */
	public Users login(Users user);
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public Users register(Users user);
	
	/**
	 * 用户名是否已存在
	 * @return
	 */
	public boolean isReName(Users user);

	/**
	 * 邮箱是否已存在
	 * @return
	 */
	public boolean isReEmail(Users user);
}
