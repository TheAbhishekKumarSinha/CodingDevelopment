package org.springhibernate.validators;

import org.springhibernate.jdbc.pojo.Users;
import org.springhibernate.pojo.User;
import org.springhibernate.spring.jdbc.LoginJdbcDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Controller
public class LoginValidator implements Validator {


	private LoginJdbcDataAccess loginJdbcDataAccess;
	@Autowired
	public void setLoginJdbcDataAccess(LoginJdbcDataAccess loginJdbcDataAccess) {
		this.loginJdbcDataAccess = loginJdbcDataAccess;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors error) {
		// TODO Auto-generated method stub
		User user = (User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "name.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "password.empty");
		Users user1= null;
		String[] columnName=null;
		String[] columnValue=null;
		String[] whereclause=null;
		String[] whereclauseValue= null;
		if(!error.hasErrors()){
			if(user.getUsername()!=null && user.getPassword()!=null){
				try {
					user1 = loginJdbcDataAccess.getUser(user.getUsername(), user.getPassword());
					if(user1.getUserid().equalsIgnoreCase(user.getUsername())){
						if(!user1.getPassword().equals(user.getPassword())){
							int invalidAttempt=user1.getUnsuccessfulLoginAttempts()+1;
							user1.setUnsuccessfulLoginAttempts(invalidAttempt);
							if(invalidAttempt>3){
								columnName= new String[]{"unsuccessfulLoginAttempts","userLocked","userLockedReason"};
								columnValue= new String[]{String.valueOf(invalidAttempt),"1","MAX ATTEMPT CROSSED"};
								error.rejectValue("username","userlocked.maximum", "User Locked: Maximum Attempt Breached");
								error.rejectValue("password","contact.admin", "Contact: Administrator");
							}else{
								columnName= new String[]{"unsuccessfulLoginAttempts"};
								columnValue= new String[]{String.valueOf(invalidAttempt)};
								error.rejectValue("password","", "Invalid Credentials.");
							}
							whereclause= new String[]{"userid"};
							whereclauseValue = new String[]{user1.getUserid()};
							loginJdbcDataAccess.updateUser(columnName, whereclause, "users", columnValue, whereclauseValue);

						}else{
							if(user1.getUserLocked().equals("1")){
								error.rejectValue("username","userlocked.maximum", "User Locked: Maximum Attempt Breached");
								error.rejectValue("password","contact.admin", "Contact: Administrator");
							}else{

								columnName= new String[]{"unsuccessfulLoginAttempts"};
								columnValue= new String[]{String.valueOf(0)};
								whereclause= new String[]{"userid"};
								whereclauseValue = new String[]{user1.getUserid()};				
								loginJdbcDataAccess.updateUser(columnName, whereclause, "users", columnValue, whereclauseValue);
							
							}
						}
					}else{
						error.rejectValue("password","", "Invalid Credentials.");
					}
				} catch (EmptyResultDataAccessException e) {
					// TODO Auto-generated catch block
					System.out.println("INVALID USER");
					error.rejectValue("password","", "Invalid Credentials.");
					e.printStackTrace();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}



}
