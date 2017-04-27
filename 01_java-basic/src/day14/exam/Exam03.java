package day14.exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) throws IOException {
		BufferedReader fi = new BufferedReader(new FileReader(new File("ioload/person.txt")));
		List<Person> persons = new ArrayList<Person>();
		
		String data ="";
		while((data = fi.readLine()) != null) {
			String[] s = data.trim().split(":");
			persons.add(new Person(s[0], s[1]));
		}
		fi.close();
		
		
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		while(!isExit) {
			System.out.println("항목을 선택하세요. (1.지역명 2.이름 3.종료) : ");
			int menu = Integer.parseInt(sc.nextLine());
			String temp = "";
			switch(menu) {
			case 1:
				System.out.println("지역명을 입력하세요 : ");
				temp = sc.nextLine();
				showResult(searchLocation(persons, temp), temp);
				break;
			case 2:
				System.out.println("이름을 입력하세요 : ");
				temp = sc.nextLine();
				showResult(searchName(persons, temp), temp);
				break;
			case 3:
				System.out.println("프로그램을 종료 합니다.");
				isExit = true;
				break;
			}
		}
		sc.close();
	}
	
	public static void showResult(List<Person> oldList, String input) {
		
		System.out.println("--------------------------------------- ");
		System.out.println("사용자 입력문 : " + input);
		System.out.printf("%s 검색된 결과 : %d명 \n" ,input, oldList.size());
		for(Person p : oldList) {
			System.out.println(p.toString());
		}
		System.out.println("--------------------------------------- ");
		 
	}
	
	public static List<Person> searchLocation(List<Person> oldList, String location) {
		List<Person> result = new ArrayList<Person>();
		
		for(Person p : oldList) {
			if(p.compareLocation(location))
				result.add(p);
		}
		
		return result;
	}
	
	public static List<Person> searchName(List<Person> oldList, String name) {
		List<Person> result = new ArrayList<Person>();
		
		for(Person p : oldList) {
			if(p.compareName(name))
				result.add(p);
		}
		
		return result;
	}
}

class Person {
	private String name;
	private String location;
	public Person(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	public boolean compareName(String name) {
		if(this.name.contains(name))
			return true;
		else 
			return false;
	}
	
	public boolean compareLocation(String location) {
		if(this.location.contains(location))
			return true;
		else 
			return false;
	}
	
	public String toString() {
		return String.format(" 이름 : %s, 거주지 : %s", name, location);
	}
}
