<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/back/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        发布信息 - 襄阳市惠农谷
    </title>

    <meta name="copyright" content="Copyright 2008-2015 - Nongnet_Inc">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="front/js/iframe.js"></script>
	<script type="text/javascript" src="back/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"  charset="utf-8" src="front/js/pubInfo.js"></script>
    <link rel="stylesheet" type="text/css" href="back/js/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="front/css/pubInfo.css" media="all">
        
    <script type="text/javascript">
	    $(function(){
	    	
	    	$('#first').combobox({
	    		valueField:'clasId',
	    		textField:'clasName',
	    		url:'front/clas/getFirstClas.action',
	    		editable : false,
	    		panelHeight:'auto',
	    		onSelect: function(rec){
	    			$('#second').combobox({
						url :"front/clas/getSecondClas.action?"
										+ "firstId="+ $('#first').combobox('getValue'),
						valueField:'clasId',
			    		textField:'clasName',
			    		editable : false,
			    		panelHeight:'auto',
			    		onSelect: function(rec){
			    			$('#third').combobox({
			    				url :"front/clas/getThirdClas.action?"
									+ "secondId="+ $('#second').combobox('getValue'),
								valueField:'clasId',
					    		textField:'clasName',
					    		editable : false,
					    		panelHeight:'auto',
					    		onSelect: function(rec){
					    			//设置input里的值
					    			$('#third').val($('#third').combobox('getValue'));
					    		}
			    			});
			    			//设置input里的值
			    			$('#second').val($('#second').combobox('getValue'));
			    			$('#third').val('');
			    		}
					});
	    			//设置input里的值
	    			$('#first').val($('#first').combobox('getValue'));
	    			$('#second').val('');
	    			$('#third').val('');
	    			//清空第三个select
	    			$('#third').combobox('clear');
	    			$('#third').combobox('loadData',{});
	    		}
	    	});
	    	
	    	$('#province').combobox({
	    		valueField:'cityId',
	    		textField:'cityName',
	    		url:'front/city/getProvince.action',
	    		editable : false,
	    		panelHeight:'auto',
	    		onSelect: function(rec){
	    			$('#city').combobox({
						url :"front/city/getCity.action?"
										+ "provinceId="+ $('#province').combobox('getValue'),
						valueField:'cityId',
			    		textField:'cityName',
			    		editable : false,
			    		panelHeight:'auto',
			    		onSelect: function(rec){
			    			$('#area').combobox({
			    				url :"front/city/getArea.action?"
									+ "pCityId="+ $('#city').combobox('getValue'),
								valueField:'cityId',
					    		textField:'cityName',
					    		editable : false,
					    		panelHeight:'auto',
					    		
					    		onSelect: function(rec){
					    			//设置input里的值
					    			$('#area').val($('#area').combobox('getValue'));
					    		}
			    			});
			    			//设置input里的值
			    			$('#city').val($('#city').combobox('getValue'));
			    			$('#area').val('');
			    		}
					});
	    			//设置input里的值
	    			$('#province').val($('#province').combobox('getValue'));
	    			$('#city').val('');
	    			$('#area').val('');
	    			$('#area').combobox('clear');
	    			$('#area').combobox('loadData',{});
	    		}
	    	});
	    	
	    	
	    	
		});
	    
	   
    </script>
</head>

<body>
<div class="content" >

<table  align="center" cellpadding="0" cellspacing="0" width="797">
    <tbody>
        <tr>
            <td>
                <div style="margin: 6px;">
                    <div class="rightdivxx">
                        <div id="ContentMain_PanelFabu">
                            <form method="post" action="front/buyInfo/saveBuyInfo.action" id="pubInfo" name="pubInfo" onSubmit="return regSubmit('pubInfo');">
                                <table cellpadding="4" cellspacing="0" width="770">
                                    <tbody>
    <tr>
        <td>
            <div style="width: 750px;">
                <div class="singlelinediv">
                    <div class="fabu_title">
                        <span class="orange">信息标题：</span>
                    </div>
                    <div class="fabu_input">

                        <input value="${buyInfo.buyTitle }" name="buyInfo.buyTitle" id="infoTitle" style="width: 400px;"
                               type="text"> <em class="star">*</em><br>
                        <span class="inputsm">信息主题是吸引人的关键，可详加修饰，越长越好，但不要超过25字</span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="singlelinediv">
                    <div class="fabu_title">
                        <span class="orange">选择品种：</span>
                    </div>
                    <div class="fabu_input">
                    	<input id="first" class="easyui-combobox" name="first" value="" style="width:100px;">
    					<input id="second" class="easyui-combobox" name="second" value="" style="width:120px;">
    					<input id="third" class="easyui-combobox" name="buyInfo.agriculClas.clasId" value="" style="width:100px;">
                        <em class="star">*</em>
                        <span class="red">分类必须填写</span>
                        <br>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="singlelinediv">
                    <div class="fabu_title">
                        	有&nbsp; 效 期：
                    </div>
                    <div class="fabu_input">
                       <select name="buyInfo.expiryInterval" value="${buyInfo.expiryInterval }">
                           <option value="7">7天</option>
                           <option value="30">30天</option>
                           <option value="60">60天</option>
                           <option value="90">90天</option>
                       </select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="singlelinediv">
                    <div class="fabu_title">
                         供&nbsp; 应 量：
                    </div>
                    <div class="fabu_input">
                        <input class="datainput" id="quantity1" name="buyInfo.minQuantity" value="${buyInfo.minQuantity }"/>
                        至 <input class="datainput" id="quantity2" name="buyInfo.maxQuantity" value="${buyInfo.maxQuantity }"/>
                        /<input class="datainput" name="buyInfo.quantityUnit" value="${buyInfo.quantityUnit }"/>(单位)
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="singlelinediv">
                    <div class="fabu_title">
                        产品报价：
                    </div>
                    <div class="fabu_input">
                        <input class="datainput" id="price1" name="buyInfo.minPrice" value="${buyInfo.minPrice }"/>
                        至 <input class="datainput" id="price2" name="buyInfo.maxPrice"  value="${buyInfo.maxPrice }"/>
                        /元
                    </div>
                    <div class="clear"></div>
                </div>
            </div>


            <div style="margin: 10px 0px;">
                <span class="orange">信息内容：</span>
                &nbsp;<span class="inputsm">信息内容请尽量详细，内容不得少于10个字，有利于百度收录和信息排名</span>
            </div>
            <div style="margin-bottom: 10px; width: 750px;">
            <textarea id="txtContent" name="buyInfo.description" value="${buyInfo.description }" cols="120" rows="20">联系我时请说明是在 襄阳市惠农谷 上看到的，谢谢！</textarea>
            </div>
           
            <div>
                <table width="690">
                    <tbody>
                   <!--  <tr>
                        <td class="style2">
                            发布企业：
                        </td>
                        <td class="style3">
                            <input value="" name="ctl00$ContentMain$txtCompany" id="txtCompany" style="width: 320px;"
                                   type="text">
                        </td>
                        <td class="style2">
                            联系电话：
                        </td>
                        <td class="style4">
                            <input value="" name="ctl00$ContentMain$txtTel" id="txtTel" style="width: 160px;"
                                   type="text">
                        </td>
                    </tr> -->
                    <tr>
                   		 <td class="style2">
                            <span class="orange">联 系 人：</span>
                        </td>
                        <td class="style3">
                            <input value="${buyInfo.contacts }" name="buyInfo.contacts" id="txtContact"  style="width: 200px;"
                                   type="text"><em class="star">*</em>
                        </td>
                        <td class="style2">
                            <span class="orange">手机号码：</span>
                        </td>
                        <td class="style4">
                            <input value="${buyInfo.phone }" name="buyInfo.phone" id="txtMov"  style="width: 180px;"
                                   type="text"><em class="star">*</em>
                        </td>
                        
                    </tr>
                    <tr>
                        <td class="style2">
                            <span class="orange">期望货源地：</span>
                        </td>
                        <td class="style3">
                            <div id="">
	                            <input id="province" class="easyui-combobox" name="buyInfo.cityByProvinceId.cityId" style="width:65px;">
	    						<input id="city" class="easyui-combobox" name="buyInfo.cityByCityId.cityId" style="width:65px;">
	    						<input id="area" class="easyui-combobox" name="buyInfo.cityByAreaId.cityId" style="width:65px;">
                                <em class="star">*</em>
                            </div>


                        </td>
                        <td class="style2">
                            QQ号码：
                        </td>
                        <td class="style4">
                            <input value="${buyInfo.qq }" name="buyInfo.qq" id="txtQQ" type="text" style="width: 180px;">
                        </td>
                    </tr>
                    <tr>
                        <td class="style2">
                            详细地址：
                        </td>
                        <td class="style3">
                            <input value="${buyInfo.address }" name="buyInfo.address" id="txtAddress" style="width: 200px;"
                                   type="text">
                        </td>
                        <td class="style2">
                            电子邮件：
                        </td>
                        <td class="style4">
                            <input value="${buyInfo.email }" name="buyInfo.email" id="txtEmail" style="width: 180px;"
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                    	<td colspan="2">
                            <div class="submit-wrapper">
	                   	 		<div class="c1">
	                                	<button hidefocus="true" class="submit" name="submit">存草稿</button>
	                            </div>
                            </div>
                        </td>
                        <td colspan="2">
                            <div class="submit-wrapper">
                                <div class="c2">
                                    <button onclick="regSubmit('pubInfo');" hidefocus="true" class="submit" name="submit">立即发布信息</button>
                                </div>
                            </div>
                        </td>
                        <input type="hidden" id="status" name="buyInfo.status" value="1"></input>
                    </tr>
                    </tbody>
                </table>
            </div>
</td>
</tr>
</tbody>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </tbody>
</table>

</div>

<script type="text/javascript" src="front/js/windows.js"></script>
</body>
</html>
