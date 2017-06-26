package com.hng.dao;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

/**
 * 数据库dao
 * 处理数据库交�?
 * @author wlp
 *
 */
@SuppressWarnings("rawtypes")
public interface IDao {

	/**
	 * 根据主键获取实体对象
	 * @param entityClass 实体�?
	 * @param id 主键
	 * @return 实体类对�?
	 */
	<T> T queryById(Class<T> entityClass, Serializable id);

	/**
	 * 保存实体�?
	 * @param t 实体�?
	 */
	<T> void save(T t);

	/**
	 * 更新实体�?
	 * @param t 实体�?
	 */
	<T> void update(T t);

	/**
	 * 删除实体�?
	 * @param t 实体�?
	 */
	<T> void delete(T t);

	/**
	 * 根据hql查询列表数据
	 * @param hql hql语句
	 * @param params 参数
	 * @return
	 */
	List query(String hql, Collection params);
	
	/**
	 * 根据类查询列表数�? 使用Criteria查询
	 * @param clazz 实体�?
	 * @param params Criterion参数�?
	 * @return
	 */
	List query(Class clazz, Collection<Criterion> params);
	
	/**
	 * 根据hql查询列表数据
	 * @param hql hql语句
	 * @param params 参数
	 * @return
	 */
	List query(String hql, Object... params);
	
	/**
	 * 根据类查询列表数�? 使用Criteria查询
	 * @param clazz 实体�?
	 * @param params Criterion参数�?
	 * @return
	 */
	List query(Class clazz, Criterion... params);
	
	/**
	 * 根据hql查询总数
	 * @param hql hql语句
	 * @param params 参数
	 * @return
	 */
	int queryCount(String hql, Collection params);
	
	/**
	 * 根据类查询�?�? 使用Criteria查询
	 * @param clazz 实体�?
	 * @param params Criterion参数�?
	 * @return
	 */
	int queryCount(Class clazz, Collection<Criterion> params);

	/**
	 * 根据hql查询列表
	 * @param hql hql语句
	 * @param params 参数
	 * @param firstResult �?��记录�?
	 * @param maxResults �?��记录�?
	 * @return
	 */
	List query(String hql, Collection params, int firstResult, int maxResults);
	
	/**
	 * 根据类查询列�? 使用Criteria查询
	 * @param clazz 实体�?
	 * @param params 参数
	 * @param firstResult �?��记录�?
	 * @param maxResults �?��记录�?
	 * @return
	 */
	List query(Class clazz, Collection<Criterion> params, int firstResult, int maxResults);
	
	/**
	 * 执行hql语句, 主要用于更新操作
	 * @param hql
	 * @param params
	 * @return
	 */
	int execute(String hql, Object... params);
	
	/**
	 * 根据DetachedCriteria查询列表
	 * @param detachedCriteria DetachedCriteria
	 * @param params 参数
	 * @return
	 */
	List query(DetachedCriteria detachedCriteria, Criterion... params);
	
	/**
	 * 根据hql查询列表
	 * @param hql
	 * @return
	 */
	List query(String hql);
	
	/**
	 * 根据实体类查询列�?
	 * @param clazz
	 * @return
	 */
	List query(Class clazz);

	/**
	 * 更新或�?保存照片数据
	 * @param id 照片id，为null则表示为保存，否则为更新
	 * @param is 照片的输入流 数据
	 * @return
	 */
	void save(Long id, InputStream is);

}