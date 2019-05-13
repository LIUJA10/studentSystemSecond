package cn.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {

    void saveOrUpdate(T t);

    void save(T t);

    void delete(T t);

    void delete(Serializable id);

    void update(T t);

    T	getById(Serializable id);

    Integer	getTotalCount(DetachedCriteria dc);

    List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

}
