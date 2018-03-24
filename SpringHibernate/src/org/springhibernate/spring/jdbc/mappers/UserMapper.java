package org.springhibernate.spring.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springhibernate.jdbc.pojo.Users;

public class UserMapper implements RowMapper<Users>{

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setUserid(rs.getString("userid"));
		users.setUsername(rs.getString("username"));
		users.setPassword(rs.getString("password"));
		users.setUnsuccessfulLoginAttempts(rs.getInt("unsuccessfulLoginAttempts"));
		users.setUserLocked(rs.getString("userLocked"));
		users.setUserLockedReason(rs.getString("userLockedReason"));
		return users;
	}

}
