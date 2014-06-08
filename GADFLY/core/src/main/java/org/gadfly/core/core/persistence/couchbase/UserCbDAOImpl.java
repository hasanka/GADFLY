package org.gadfly.core.core.persistence.couchbase;

import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.to.UserDTO;
import org.gadfly.core.core.persistence.dao.UserDAO;
import org.gadfly.core.core.util.EncriptData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.Stale;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;

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
		 user.setPassword(EncriptData.encriptString(user.getPassword()));
		 couchbaseTemplate.save(user);
		 return couchbaseTemplate.findById(user.getId(),User.class);
	}

	@Override
	public List<User> searchUsers(UserDTO dto) {
		Query query = new Query();
		query.setIncludeDocs(true);
		query.setStale(Stale.FALSE);
		return (List<User>)couchbaseTemplate.findByView("users", "searchUsers", query, User.class);
	}

	@Override
	public boolean authenticateUser(UserDTO dto) {
		Query query = new Query();
		query.setIncludeDocs(false);
		query.setStale(Stale.FALSE);
		ComplexKey key = ComplexKey.of(dto.getUserName(), EncriptData.encriptString(dto.getPassword())).forceArray(true);
		query.setKey(key);
		ViewResponse responce = couchbaseTemplate.queryView("users", "authentcateUser", query);
		for (ViewRow viewRow : responce) {
			boolean result = Boolean.valueOf(viewRow.getValue());
			return result;
		}
		return false;
	}

	
	
}

