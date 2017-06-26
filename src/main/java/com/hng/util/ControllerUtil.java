package com.hng.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 视图工具, ajax交互, 输出结果
 * @author wlp
 *
 */
public final class ControllerUtil {

	private static final Logger logger = Logger.getLogger(ControllerUtil.class);
	
	private ControllerUtil() {
		
	}
	
	/**
	 * 输出字符串
	 * @param response
	 * @param str
	 */
	public static void out(HttpServletResponse response, String str) {
		OutputStream os = null; 
		try {
			response.setContentType("text/plain");
			os = response.getOutputStream();
			os.write(str.getBytes("UTF-8"));
			os.flush();
		} catch (IOException e) {
			logger.error(e, e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error(e, e);
				}
			}
		}
	}
	
	/**
	 * 输出集合json串
	 * @param response
	 * @param collection
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void out(HttpServletResponse response, Collection collection) {
		out(response, JSONUtil.listToJson(collection));
	}
	
	/**
	 * 输出对象字符串
	 * @param response
	 * @param object
	 */
	public static void out(HttpServletResponse response, Object object) {
		out(response, object.toString());
	}
}
