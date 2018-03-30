package org.springhibernate.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springhibernate.jdbc.pojo.Users;
import org.springhibernate.spring.jdbc.mappers.PreparedStatementSetter;
import org.springhibernate.spring.jdbc.mappers.UserMapper;

@Controller
public class LoginJdbcDataAccess {

    private DataSource dataSource;
    private JdbcTemplate jdbctemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbctemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbctemplate() {
        return jdbctemplate;
    }

    public void setJdbctemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    public Users getUser(String userid, String password) throws Exception {
        String sql = "SELECT * FROM USERS WHERE USERID=?";
        Users user = this.jdbctemplate.queryForObject(sql, new Object[] { userid }, new UserMapper());
        return user;
    }

    public void updateUser(String[] ColumnName, String[] whereclause, String tableName, String[] columnValue,
            String[] whereClauseValue) {
        String Sql = "UPDATE " + tableName + " SET ";
        for (int i = 0; i <= ColumnName.length - 1; i++) {
            Sql = Sql + ColumnName[i] + "=" + "'" + columnValue[i] + "',";
        }
        Sql = Sql.substring(0, Sql.length() - 1) + " WHERE ";
        for (int i = 0; i <= whereclause.length - 1; i++) {
            Sql = Sql + whereclause[i] + "='" + whereClauseValue[i] + "' AND ";
        }
        Sql = Sql.substring(0, Sql.length() - 4);
        this.jdbctemplate.update(Sql);
        System.out.println(Sql);
    }

    public int[] batchUpdate(final List<Users> users) {
        String sql = "INSERT INTO BFDBUSR.USERS(userid,username,password,unsuccessfulLoginAttempts,userLocked,userLockedReason,usercreationdate,lastlogintime) "
                + "values(?,?,?,?,?,?,?,?)";
        int[] updatecount = jdbctemplate.batchUpdate(sql, new PreparedStatementSetter(users));
        return updatecount;
    }

}
