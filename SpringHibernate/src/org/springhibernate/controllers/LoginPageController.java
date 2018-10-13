package org.springhibernate.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springhibernate.controllers.helper.HelperClass;
import org.springhibernate.jdbc.pojo.Customer;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@ModelAttribute("user1") User user, BindingResult result, HttpServletRequest request) {
        return "Login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginCredentials(@ModelAttribute("user1") User user1, BindingResult result,
            @ModelAttribute("customers") Customer cust, HttpServletRequest request, HttpSession session, ModelMap map) {
        // User users= new User();
        System.out.println("Username :" + user1.getUsername() + " " + "Password" + user1.getPassword());
        validator.validate(user1, result);
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()) {
            mav.setViewName("Login");
            return mav;
        }

        List<Users> users = null;
        try {
            users = HelperClass.userList();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        loginJdbcDataAccess.batchUpdate(users);
        session = request.getSession();

        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Struts 1");
        webFrameworkList.add("Struts 2");
        webFrameworkList.add("Apache Wicket");

        map.put("webFrameworkList", webFrameworkList);

        mav.setViewName("HomePage");
        return mav;

    }

}
