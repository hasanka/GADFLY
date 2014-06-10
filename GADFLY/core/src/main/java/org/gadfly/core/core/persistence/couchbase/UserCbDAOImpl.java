package org.gadfly.core.core.persistence.couchbase;

import java.util.List;

import org.gadfly.core.api.domain.User;
import org.gadfly.core.api.to.UserDTO;
import org.gadfly.core.core.exception.GadfyDaoException;
import org.gadfly.core.core.exception.GadfyException;
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

	private static final String ANY = "\uefff";
	
	@Autowired
	private CouchbaseTemplate couchbaseTemplate;
	
	@Override
	public User saveUser(User user) throws GadfyException {
		try {
			 user.setPassword(EncriptData.encriptString(user.getPassword()));
			 couchbaseTemplate.save(user);
			 return couchbaseTemplate.findById(user.getId(),User.class);
		} catch (Exception e) {
			throw new GadfyDaoException("Error in saving user details", "DATA_INSERT_EXCEPTION",e);
		}
		
	}

	@Override
	public List<User> searchUsers(UserDTO dto) throws GadfyException{
		try {
			Query query = new Query();
			query.setIncludeDocs(true);
			query.setStale(Stale.FALSE);
			String userName = dto.getUserName();
			String firstName = dto.getFirstName();
			String status = dto.getStatus();
			ComplexKey keyStart = ComplexKey.of(userName,firstName,status).forceArray(true);
			ComplexKey keyEnd = ComplexKey.of(userName+ANY,firstName+ANY,status+ANY).forceArray(true);
			query.setRangeStart(keyStart);
			query.setRangeEnd(keyEnd);
			return (List<User>) couchbaseTemplate.findByView("users", "searchUsers", query,User.class);
		} catch (Exception e) {
			throw new GadfyDaoException("Error in searching users", "DATA_RETRIVE_EXCEPTION",e);
		}
	}

	@Override
	public boolean authenticateUser(UserDTO dto) throws GadfyException {
		try {
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
		} catch (Exception e) {
			throw new GadfyDaoException("User authentication fail", "USER_AUTHENTICATION_EXCEPTION",e);
		}
		
	}

}

