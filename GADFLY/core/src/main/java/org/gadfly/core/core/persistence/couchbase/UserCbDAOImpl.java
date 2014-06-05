package org.gadfly.core.core.persistence.couchbase;

import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.to.UserDTO;
import org.gadfly.core.core.persistence.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

import com.couchbase.client.protocol.views.Query;

/**
 * 
 * @author HasankaMac
 *
 */
public class UserCbDAOImpl implements UserDAO {

	@Autowired
	private CouchbaseTemplate couchbaseTemplate;
	
	@Override
	public User saveUser(User user) {
		 couchbaseTemplate.save(user);
		 return couchbaseTemplate.findById(user.getId(),User.class);
		
	}

	@Override
	public List<User> searchUsers(UserDTO dto) {
		return (List<User>)couchbaseTemplate.findByView("users", "searchUsers", new Query(), User.class);
	}

	
	
}

