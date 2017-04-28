package day15.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam03 {
//	문제 개요 : 직원의 정보가 저장되어있는 파일(employee.txt)의 내용을 읽어서 직원의 이
//	름이 메소드의 매개변수로 입력받은 성(lastName)과 동일한 사람의 정보를 출력하는 메소드를
//	구현합니다.
	// data/employee.txt 
	public static void main(String[] args) throws Exception {
//		Employee e = new Employee("김상욱", 33, "편집부", 3000);
//		System.out.println(e.compare('김'));
		searchEmployeeInfo("data/employee.txt", "김");
	}
	
	public static void searchEmployeeInfo(String readFileName, String lastName)
			throws Exception {
		List<Employee> foundList = readData(new File(readFileName), lastName);
		
		for(Employee e:foundList) {
			System.out.println(e.toString());
		}
		System.out.println("=============================");
		System.out.printf("%s가진 사람은 총 %d 입니다.", lastName, foundList.size());
		System.out.println("=============================");
		
		
	}
	
	private static List<Employee> readData(File f, String lastName) throws FileNotFoundException {
		List<Employee> searchedList = new ArrayList<Employee>();
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			String[] sp = s.nextLine().split(":");
			Employee e = new Employee(sp[0], Integer.parseInt(sp[1]), sp[2], Integer.parseInt(sp[3]));
			if(e.compare(lastName.toCharArray()[0]))
				searchedList.add(e);
		}
		s.close();
		
		return searchedList;
	}
}

class Employee {
	private String name;
	private int age;
	private String depart;
	private int salary;
	
	public Employee(String name, int age, String depart, int salary) {
		this.name = name;
		this.age = age;
		this.depart = depart;
		this.salary = salary;
	}
	
	public boolean compare(char lastName) {
		if(name.toCharArray()[0] == lastName) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the depart
	 */
	public String getDepart() {
		return depart;
	}

	/**
	 * @param depart the depart to set
	 */
	public void setDepart(String depart) {
		this.depart = depart;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	public String toString() {
		return String.format("이름 : %s\t 나이:%d\t 부서:%s\t 월급:%d\t", name, age, depart, salary); 
	}
}
