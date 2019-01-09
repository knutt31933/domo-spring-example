package com.example.demo.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.demo.bean.WebboardBean;
import com.example.demo.entity.Webboard;
import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;

@Repository
public class CustomRepo {
	@PersistenceContext
	EntityManager em;
	public List<Webboard> findAll(){
		List<Webboard> list = new ArrayList<>();
		String sql = "select id as id,"
				+ "title as title,"
				+ "story as story,"
				+ "author as author,"
				+ "is_active as isActive,"
				+ "create_date as createDate,"
				+ "create_by as createBy,"
				+ "update_date as updateDate,"
				+ "update_by as updateBy from webboard where is_active = :isActive ";
		Session session = em.unwrap(Session.class);
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter("isActive", "hello");
		
		sqlQuery.addScalar("title", StringType.INSTANCE);
		sqlQuery.addScalar("story", StringType.INSTANCE);
		sqlQuery.addScalar("author", StringType.INSTANCE);
		sqlQuery.addScalar("isActive", StringType.INSTANCE);
		sqlQuery.addScalar("createDate", StringType.INSTANCE);
		sqlQuery.addScalar("createBy", StringType.INSTANCE);
		sqlQuery.addScalar("updateDate", StringType.INSTANCE);
		sqlQuery.addScalar("updateBy", StringType.INSTANCE);
		
		sqlQuery.setResultTransformer(new FluentHibernateResultTransformer(Webboard.class));
		
		list = sqlQuery.getResultList();
		return list;
	}
	
	public List<WebboardBean> findByTitleAndAuthor(String title,String story,String author){
		List<WebboardBean> list = new ArrayList<>();
		
		String sql = "select id as id,"
				+ "title as title,"
				+ "story as story,"
				+ "author as author,"
				+ "is_active as isActive,"
				+ "create_date as createDate,"
				+ "create_by as createBy,"
				+ "update_date as updateDate,"
				+ "update_by as updateBy from webboard where is_active = :isActive ";
		
		if(!StringUtils.isEmpty(title)) {
			sql+="and title like :title ";
		}
		if(!StringUtils.isEmpty(story)) {
			sql+="and story like :story ";
		}
		if(!StringUtils.isEmpty(author)) {
			sql+="and author like :author ";
		}
		
		Session session = em.unwrap(Session.class);
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter("isActive", "hello");
		
		if(!StringUtils.isEmpty(title)) {
			sqlQuery.setParameter("title", "%"+title+"%");
		}
		if(!StringUtils.isEmpty(story)) {
			sqlQuery.setParameter("story", "%"+story+"%");
		}
		if(!StringUtils.isEmpty(author)) {
			sqlQuery.setParameter("author", "%"+author+"%");
		}
		
		sqlQuery.addScalar("title", StringType.INSTANCE);
		sqlQuery.addScalar("story", StringType.INSTANCE);
		sqlQuery.addScalar("author", StringType.INSTANCE);
		sqlQuery.addScalar("isActive", StringType.INSTANCE);
		sqlQuery.addScalar("createDate", StringType.INSTANCE);
		sqlQuery.addScalar("createBy", StringType.INSTANCE);
		sqlQuery.addScalar("updateDate", StringType.INSTANCE);
		sqlQuery.addScalar("updateBy", StringType.INSTANCE);
		
		sqlQuery.setResultTransformer(new FluentHibernateResultTransformer(WebboardBean.class));
		
		list = sqlQuery.getResultList();
		return list;
	}
}
