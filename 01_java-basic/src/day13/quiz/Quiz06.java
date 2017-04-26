package day13.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz06 {
	public static void main(String[] args) {
		List<Student> list = Collections.synchronizedList(new ArrayList<Student>());
		
		list.add(new Student("배영만", 264));
		list.add(new Student("배수근", 257));
		list.add(new Student("배근영", 227));
		
		Collections.sort(list);
		Collections.reverse(list);
		
		System.out.println("성적발표");
		System.out.println("====================");
		int grade = 1;
		for(Student s : list) {
			System.out.printf("%d . %s \n", grade++, s.toString());
		}
		System.out.println("====================");
	}
}
