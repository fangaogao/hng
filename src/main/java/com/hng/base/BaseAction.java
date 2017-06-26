package com.hng.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.upload.FormFile;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 继承 struts的ActionSupport, 获取request, response
 * @author wlp
 *
 */
public class BaseAction extends ActionSupport {

    private static final long serialVersionUID = 7620009925942346125L;
    //上下�?
    ActionContext context = ActionContext.getContext();
    protected HttpServletRequest request = (HttpServletRequest) context
            .get(ServletActionContext.HTTP_REQUEST);
    protected HttpServletResponse response = (HttpServletResponse) context
            .get(ServletActionContext.HTTP_RESPONSE);
    protected HttpSession session = request.getSession();
    
	private FormFile uploadFile;
	public FormFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(FormFile uploadFile) {
		this.uploadFile = uploadFile;
	}

}
