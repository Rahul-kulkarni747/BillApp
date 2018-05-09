package com.mycom.spring.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractORMDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	public <T> Serializable save(T entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}

	public <T> T update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}

	public <T> T saveOrupdate(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	public <T> void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public <T> void delete(Serializable id, Class<T> entityClass) {
		T entity = fetchById(id, entityClass);
		delete(entity);
	}

	public <T> List<T> fetchAll(Class<T> entityClass) {
		return sessionFactory.getCurrentSession().createQuery(" FROM " + entityClass.getName()).list();
	}

	@SuppressWarnings("rawtypes")
	public <T> List<T> fetchAll(String query) {
		return sessionFactory.getCurrentSession().createNativeQuery(query).list();
	}

	@SuppressWarnings("unchecked")
	public <T> T fetchById(Serializable id, Class<T> entityClass) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);
	}

	public <T> T fetch(Class<T> clazz) {
		return (T) sessionFactory.openSession().createQuery(" FROM " + clazz.getName()).list().get(0);
	}

	public <T> List<T> fetch(Class<T> clazz, String hqlQuery, Object[] values) {

		return null;
	}

	public <T> List<T> findByNativeSql(Class<T> clazz, String sqlQuery, Object[] values) {
		Query query = sessionFactory.getCurrentSession().createNativeQuery(sqlQuery, clazz);
		int index = 0;

		if (values != null) {
			for (Object value : values) {
				query.setParameter(index, value);
				index++;
			}
		}

		return query.list();
	}


	public <T> T fetchByKey(String string, Object value, Class<T> entityClass) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(entityClass);
		Root<T> root = criteria.from(entityClass);
		criteria.select(root).where(builder.equal(root.get(string), value));
		Query<T> q = sessionFactory.getCurrentSession().createQuery(criteria);
		return (T) q.uniqueResult();
	}

	public <T> List<T> fetchAllByKey(String string, Object value, Class<T> entityClass) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(entityClass);
		Root<T> root = criteria.from(entityClass);
		criteria.select(root).where(builder.equal(root.get(string), value));
		Query<T> q = sessionFactory.getCurrentSession().createQuery(criteria);
		return q.getResultList();
	}

	public <T> List<T> fetchAllByKeyMap(Map<String, Object> map, Class<T> entityClass) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(entityClass);
		Root<T> root = criteria.from(entityClass);
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			criteria.select(root).where(builder.equal(root.get(entry.getKey()), entry.getValue()));
		}
		Query<T> q = sessionFactory.getCurrentSession().createQuery(criteria);
		return q.list();
	}

}
