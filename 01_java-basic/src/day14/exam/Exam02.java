/*
 *   exam02.txt
 *   ------------------------------
 *   김기수:98:66:78
 *   이지수:88:56:88
 *   박수리:78:86:58
 *   ------------------------------
 * 
 *   파일의 내용을 읽어서 아래와 같은 형식으로 출력
 *   파일형식 : 이름:자바:SQL:Jdbc
 *   수료 기준 
 *   - 자바 : 70점 이상
 *   - SQL  : 80점 이상
 *   - Jdbc : 80점 이상
 *   단, 출력결과는 exam02-result.txt에 출력
 *   
 *   실행시의 결과 출력 형식
 *   
 *   김기수 : 자바(수료), SQL(미수료), Jdbc(미수료)
 *   이기수 : 자바(수료), SQL(미수료), Jdbc(수료)
 *   박수리 : 자바(수료), SQL(수료), Jdbc(미수료)
 */
package day14.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exam02 {
	public static void main(String[] args) throws IOException {
		BufferedReader fi = new BufferedReader(new FileReader(new File("ioload/exam02.txt")));
		BufferedWriter fw = new BufferedWriter(new FileWriter(new File("ioload/exam02-result.txt")));
		String data ="";

		List<Student> scores = new ArrayList<Student>();
		while((data = fi.readLine()) != null) {
			String[] s = data.trim().split(":");
			scores.add(new Student(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3])));
		}
		
		fi.close();
		
		for(Student s : scores) 
			fw.write(s.toString());
		
		fw.close();
	}
}

class Student {
	private int java;
	private int sql;
	private int jdbc;
	
	private String javaResult;
	private String sqlResult;
	private String jdbcResult;
	
	private void calculation(){
//		 - 자바 : 70점 이상
//		 - SQL  : 80점 이상
//		 - Jdbc : 80점 이상
		javaResult = java >= 70 ? "(수료)" : "(미수료)"; 
		sqlResult = sql >= 80 ? "(수료)" : "(미수료)"; 
		jdbcResult = jdbc >= 80 ? "(수료)" : "(미수료)"; 
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(name).append(" : ").append("자바").append(javaResult).append(", SQL").
		append(sqlResult).append(", JDBC").append(jdbcResult).append("\n");
		return sb.toString();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	private String name;
	
	public Student(String name, int java, int sql, int jdbc){
		this.name = name;
		this.java = java;
		this.sql = sql;
		this.jdbc = jdbc;
		
		calculation();
	}
}














