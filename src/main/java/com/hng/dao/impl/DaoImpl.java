package com.hng.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LobHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hng.dao.IDao;

/**
 * IDao实现, 参见com.oracle.csg.li.base.dao.IDao
 */
@Repository("dao")
@SuppressWarnings({"rawtypes", "unchecked"})
public class DaoImpl implements IDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    /**
     * 获取hibernate session
     * @return
     */
	public Session getSession() {
        return this.sessionFactory.getCurrentSession();
//		return this.sessionFactory.openSession();
    }

	@Override
	public <T> T queryById(Class<T> entityClass, Serializable id) {
        return (T) getSession().get(entityClass, id);
    }

    @Override
	public <T> void save(T t) {
        getSession().save(t);
    }

    @Override
	public <T> void update(T t) {
        getSession().update(t);
    }

    @Override
	public <T> void delete(T t) {
        getSession().delete(t);
    }

    @Override
	public List query(String hql, Collection params) {
    	//创建hql查询
        Query query = getSession().createQuery(hql);
        //设置参数
        setQueryParams(query, params);
        return query.list();
    }
    
    @Override
    public List query(String hql, Object... params) {
    	//创建hql查询
    	Query query = getSession().createQuery(hql);
    	//设置参数
    	setQueryParams(query, params);
    	return query.list();
    }
    
    @Override
    public List query(Class clazz, Criterion... params) {
    	//创建Criteria查询
    	Criteria criteria = getSession().createCriteria(clazz);
    	//设置参数
    	setCriteriaParams(criteria, params);
    	return criteria.list();
    }
    
    @Override
    public List query(Class clazz, Collection<Criterion> params) {
    	//创建Criteria查询
    	Criteria criteria = getSession().createCriteria(clazz);
    	//设置参数
    	setCriteriaParams(criteria, params);
    	return criteria.list();
    }
    
    @Override
    public List query(String hql, Collection params, int firstResult, int maxResults) {
    	//创建查询
    	Query query = getSession().createQuery(hql);
    	//设置参数
    	setQueryParams(query, params);
    	//设置查询起始记录
    	query.setFirstResult(firstResult);
    	//设置查询�?��条数
    	query.setMaxResults(maxResults);
    	return query.list();
    }
    
    @Override
    public List query(Class clazz, Collection<Criterion> params, int firstResult, int maxResults) {
    	//创建查询
    	Criteria criteria = getSession().createCriteria(clazz);
    	//设置参数
    	setCriteriaParams(criteria, params);
    	//设置查询起始记录
    	criteria.setFirstResult(firstResult);
    	//设置查询�?��条数
    	criteria.setMaxResults(maxResults);
    	
    	return criteria.list();
    }
    
    @Override
    public int queryCount(String hql, Collection params) {
    	//创建查询
    	Query query = getSession().createQuery(hql);
    	//设置参数
    	setQueryParams(query, params);
    	return query.list().size();
    }
    
    @Override
    public int queryCount(Class clazz, Collection<Criterion> params) {
    	//创建查询
    	Criteria criteria = getSession().createCriteria(clazz);
    	//设置参数
    	setCriteriaParams(criteria, params);
    	//设置查询函数
    	criteria.setProjection(Projections.rowCount());
    	return ((Long) criteria.uniqueResult()).intValue();
    }
    
    @Override
    public int execute(String hql, Object... params) {
    	//创建查询
    	Query query = getSession().createQuery(hql);
    	//设置参数
    	setQueryParams(query, params);
    	return query.executeUpdate();
    }
    
    @Override
    public List query(DetachedCriteria detachedCriteria, Criterion... params) {
    	//创建查询
    	Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
    	if (null != params) {
	    	for (Criterion criterion : params) {
	    		criteria.add(criterion);
	    	}
    	}
    	return criteria.list();
    }
    
    @Override
    public List query(String hql) {
    	//创建查询
    	Query query = getSession().createQuery(hql);
    	return query.list();
    }
    
    @Override
    public List query(Class clazz) {
    	//创建查询
    	Criteria criteria = getSession().createCriteria(clazz);
    	return criteria.list();
    }

    /**
     * 设置hql查询参数
     * @param query
     * @param params
     */
    private void setQueryParams(Query query, Collection params) {
        if (null == params) {
            return;
        }
        int i = 0;
        for (Object object : params) {
        	query.setParameter(i++, object);
		}
    }
    
    /**
     * 设置hql查询参数
     * @param query
     * @param params
     */
    private void setQueryParams(Query query, Object... params) {
    	if (null == params) {
    		return;
    	}
    	for (int i = 0; i < params.length; i++) {
    		query.setParameter(i, params[i]);   		
    	}
    }
    
    /**
     * 设置Criteria查询参数
     * @param criteria
     * @param params
     */
    private void setCriteriaParams(Criteria criteria, Collection<Criterion> params) {
    	if (null == params) {
    		return;
    	}
    	for (Criterion criterion : params) {
    		criteria.add(criterion);
		}
    }
    
    /**
     * 设置Criteria查询参数
     * @param criteria
     * @param params
     */
    private void setCriteriaParams(Criteria criteria, Criterion... params) {
    	if (null == params) {
    		return;
    	}
    	for (Criterion criterion : params) {
    		criteria.add(criterion);
    	}
    }

	@SuppressWarnings("unused")
	@Override
	public void save(Long id, InputStream is) {
//    	LobHelper lobHelper = getSession().getLobHelper();
//    	Blob blob = null;
//		try {
//			blob = lobHelper.createBlob(is,is.available());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	Photo photo = new Photo();
////    	photo.setData(blob);
//    	//根据主键判断保存或是更新
//    	if (id==null) {
//        	save(photo);
//        }else{
//        	photo.setId(id);
//        	update(photo);
//        }
	}

}
