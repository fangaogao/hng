package com.hng.front.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hng.base.BaseAction;
import com.hng.entity.City;
import com.hng.service.ICityService;
import com.hng.util.ControllerUtil;


@Controller
@Scope("prototype")
public class ICityAction extends BaseAction {
	@Autowired
	private ICityService cityService;
	
	public String result = SUCCESS;
	
	//获取省份列表
	public void getProvince() throws Exception {
		ControllerUtil.out(response,cityService.getProvince());
	}
	//获取省份列表
	public void getCity() throws Exception {
		Integer provinceId = Integer.valueOf(request.getParameter("provinceId"));
		ControllerUtil.out(response,cityService.getCity(new City(provinceId)));
	}
	//获取省份列表
	public void getArea() throws Exception {
		Integer pCityId = Integer.valueOf(request.getParameter("pCityId"));
		ControllerUtil.out(response,cityService.getArea(new City(pCityId)));
	}
}
