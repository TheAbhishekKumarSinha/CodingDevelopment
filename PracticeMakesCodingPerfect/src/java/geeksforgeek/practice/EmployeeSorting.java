package java.geeksforgeek.practice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class EmployeeSorting {

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(scan.nextLine());
		for(int testCaseCounter =0;testCaseCounter<noOfTestCases;testCaseCounter++ ){
		    int noOfEmployees =Integer.parseInt(scan.nextLine());
		    String[] employeeData = scan.nextLine().split(" ");
		    List<Employee> sortedData = new ArrayList<Employee>();
		    for (int employeeCounter =1;employeeCounter <employeeData.length;employeeCounter=employeeCounter+2){
		    	int salary =Integer.parseInt(employeeData[employeeCounter]);
		    	String empName = employeeData[employeeCounter-1];
		    	Employee emp = new Employee(salary,empName);
		        sortedData.add(emp);
		    }
		    Collections.sort(sortedData,new NameComparator());  
		    for(Employee emp:sortedData) {
		    	System.out.print(emp.getName()+" "+ emp.getSalary()+" ");
		    }
		    System.out.println("");
		    
		}
	}
	static class Employee {
		private int salary;
		private String name;
		
		public Employee(int salary,String name) {
			this.salary = salary;
			this.name = name;
		}
		public Integer getSalary() {
			return salary;
		}


		public void setSalary(Integer salary) {
			this.salary = salary;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}
	}
	static class NameComparator implements Comparator<Employee>{
		


		@Override
		public int compare(Employee emp1, Employee emp2) {
			int compareResult=emp1.getSalary().compareTo(emp2.getSalary());
			if(compareResult==0) {
				compareResult=emp1.getName().toUpperCase().compareTo(emp2.getName().toUpperCase());
			}
			return compareResult;
		}
	}

}
