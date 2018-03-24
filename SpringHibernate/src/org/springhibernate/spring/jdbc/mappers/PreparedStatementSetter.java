package org.springhibernate.spring.jdbc.mappers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springhibernate.jdbc.pojo.Users;

public class PreparedStatementSetter implements BatchPreparedStatementSetter{
	List<Users> users;

	public PreparedStatementSetter(List<Users> users2) {
		this.users=users2;
	}

	@Override
	public int getBatchSize() {
		// TODO Auto-generated method stub
		return users.size();
	}

	@Override
	public void setValues(PreparedStatement ps, int i ) throws SQLException {
		int j=1;
		java.util.Date date= new java.util.Date();
		Users user= users.get(i);
		ps.setString(j++, user.getUserid());
		ps.setString(j++, user.getUsername());
		ps.setString(j++, user.getPassword());
		ps.setInt(j++, 0);
		ps.setString(j++,"0");
		ps.setString(j++, "");
		ps.setTimestamp(j++, new Timestamp(date.getTime()));
		ps.setTimestamp(j++, new Timestamp(date.getTime()));
	}
}
