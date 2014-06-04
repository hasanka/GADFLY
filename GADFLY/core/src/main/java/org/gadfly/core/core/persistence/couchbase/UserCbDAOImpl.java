package org.gadfly.core.core.persistence.couchbase;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.core.persistence.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

/**
 * 
 * @author HasankaMac
 *
 */
public class UserCbDAOImpl implements UserDAO {

	@Autowired
	private CouchbaseTemplate couchbaseTemplate;
	
	@Override
	public void saveUser(User user) {
		couchbaseTemplate.save(user);
	}

	
	
}

