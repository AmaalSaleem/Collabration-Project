package com.niit.CollabrationBackEnd.DAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollabrationBackEnd.DAO.BlogCommentDAO;


@Repository("blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public BlogCommentDAOImpl() {
		super();
	}
	
	
	
	
}
