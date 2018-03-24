package org.springhibernate.controllers.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springhibernate.jdbc.pojo.Users;

public class HelperClass {
	static List<Users> users =new ArrayList<Users>();
	public static List<Users> userList() throws IOException{
		
		File file= new File("C:/Users/$iLeNtKiLlEr/Documents/workspace/SpringHibernate/FilesIO/abhi.csv");
		FileReader reader= new FileReader(file);
		String thisLine="";
		BufferedReader BufReader = new BufferedReader(reader); 
		if(BufReader.readLine() != null){
			
		}
		String[] userString=null;
		while ((thisLine = BufReader.readLine()) != null) {
			Users user= new Users();
			System.out.println(thisLine);
			userString=thisLine.split(",");
			user.setUserid(userString[0]);
			user.setUsername(userString[1]);
			user.setPassword(userString[2]);
			users.add(user);
			
		}   
		BufReader.close();
		reader.close();
		return users;

	}

}
