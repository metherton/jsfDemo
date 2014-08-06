package com.martinetherton.persist;

import javax.persistence.EntityManager;

import com.martinetherton.model.Partner;
import com.martinetherton.model.User;

public interface UserRepository {
	
    void setEntityManager(EntityManager entityManager);

	User getUserWith(String bsn);

	void add(User user);

	void addPartner(Partner newPartner);

	Partner getPartnerWith(long id);

	User getUserWithId(long id);

}
