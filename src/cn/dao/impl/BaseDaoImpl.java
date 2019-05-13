package cn.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport {

	private Class clazz;//用于接收运行期泛型类型

	public BaseDaoImpl() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	//增加
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	//删除
	public void delete(T t) {
		
		getHibernateTemplate().delete(t);
		
	}
	//根据id删除
	public void delete(Serializable id) {
		T t = this.getById(id);//先取,再删
		getHibernateTemplate().delete(t);
	}

	//修改
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	//根据id进行查询
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}
	//查询符合条件的总记录数
	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数,总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前设置的聚合函数
		dc.setProjection(null);
		
		if(list!=null && list.size()>0){
			Long count = list.get(0);
			return count.intValue();
		}else{
			return null;
		}
	}
	//查询分页列表数据
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		
		List<T> list = (List<T>)getHibernateTemplate().findByCriteria(dc, start, pageSize);
		
		return list;
	}
	//增加或修改
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

}
