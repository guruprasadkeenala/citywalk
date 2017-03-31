package com.citywalk.backend.repositary.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.citywalk.backend.modal.User;
import com.citywalk.backend.repositary.UserRepositary;

@Repository
public class UserRepositaryImpl implements UserRepositary {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(User user) {
		entityManager.persist(user);
	}

	@Transactional
	public User getUser(User user) {
		User user1 = entityManager.find(User.class, user.getId());
		return user1;
	}

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * private Session getSession() { return sessionFactory.getCurrentSession();
	 * }
	 * 
	 * @Override public void save(User user) throws CitywalkException {
	 * getSession().save(user); }
	 */

}
