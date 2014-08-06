package com.martinetherton.persist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.martinetherton.flows.AowBean;
import com.martinetherton.model.Partner;
import com.martinetherton.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private EntityManager entityManager;	
	
	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public User getUserWith(String bsn) {
		Query query = entityManager.createQuery("select u from User u where u.bsn = :bsn");
		query.setParameter("bsn", bsn);
		User user = (User) query.getSingleResult();
		return user;
	}

	@Override
	public void add(User user) {
		entityManager.merge(user);
	}

	@Override
	public void addPartner(Partner newPartner) {
		entityManager.persist(newPartner);
	}

	@Override
	public Partner getPartnerWith(long id) {
		return entityManager.find(Partner.class, id);
	}

	@Override
	public User getUserWithId(long id) {
		return entityManager.find(User.class, id);
	}

}
