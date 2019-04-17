package com.cg.ums.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.ums.dao.JPAUtil;
import com.cg.ums.entities.User;

public class UserDaoImpl implements UserDao {

	private EntityManager entityManager;

	public UserDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public List<User> findByName(char lastCharac) {
		String qStr = "SELECT user FROM User user WHERE user.name = :pName ";
		TypedQuery<User> query = entityManager.createQuery(qStr, User.class);
		query.setParameter("pName", "%" + lastCharac + "%");
		return query.getResultList();

	}

	@Override
	public Long findCount() {

		String qStr = "SELECT COUNT(user.id) FROM User user";
		TypedQuery<Long> query = entityManager.createQuery(qStr, Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	@Override
	public List<User> findAllByEmailAsc() {
		String qStr = "SELECT user from User user ORDER BY user.email";
		TypedQuery<User> query = entityManager.createQuery(qStr, User.class);
		return query.getResultList();

	}

}
