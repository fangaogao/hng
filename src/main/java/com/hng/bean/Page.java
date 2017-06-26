package com.hng.bean;

import java.io.Serializable;
import java.util.List;

import com.hng.util.JSONUtil;

/**
 * 分页页面
 * @author wlp
 *
 */
@SuppressWarnings("rawtypes")
public class Page implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -673990973346715840L;
    
    /**
     * 总记录数
     */
    private int total;
    /**
     * 当前页面结果集
     */
    private List result;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
    
    /**
     * 重写toString()方法
     */
    @SuppressWarnings("unchecked")
	public String toString() {
    	return "{\"total\":" + total + ", \"rows\":" + JSONUtil.listToJson(result) + "}";
    }
}
