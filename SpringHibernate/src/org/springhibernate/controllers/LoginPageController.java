package org.springhibernate.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import org.springhibernate.controllers.helper.HelperClass;
import org.springhibernate.jdbc.pojo.Users;
import org.springhibernate.pojo.User;
import org.springhibernate.spring.jdbc.LoginJdbcDataAccess;
import org.springhibernate.validators.LoginValidator;

@Controller
public class LoginPageController {
	
	private LoginJdbcDataAccess loginJdbcDataAccess;
	@Autowired
	public void setLoginJdbcDataAccess(LoginJdbcDataAccess loginJdbcDataAccess) {
		this.loginJdbcDataAccess = loginJdbcDataAccess;
	}
	
	@Autowired
	private LoginValidator validator;
	
	
	public LoginValidator getValidator() {
		return validator;
	}
	public void setValidator(LoginValidator validator) {
		this.validator = validator;
	}
	
	/*@RequestMapping(value="fogin",method=RequestMethod.GET)
	public String loginPage(@ModelAttribute("user1")User user, BindingResult result,HttpServletRequest request){
		return "Login";		
	}*/
		
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String loginCredentials(@ModelAttribute("user1")User user1, BindingResult result,HttpServletRequest request){
		//User users= new User();
		System.out.println("Username :"+user1.getUsername() +" "+"Password"+user1.getPassword());
		validator.validate(user1, result);
		if(result.hasErrors()){
			return "Login";
		}
		List<Users> users = null;
		try {
			users = HelperClass.userList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		/*loginJdbcDataAccess.batchUpdate(users);
		HttpSession session = request.getSession();*/
		return "HomePage"; 
		
	}
	
}
