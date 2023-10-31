package tester;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.acts.core.Course;
import com.acts.core.Student;

import utils.StudentUtils;

/*
 * 
Solve : 
1. Display all student details from a student list

2. Display all student details(list) sorted as per GPA 
Use custom ordering

3. Write a tester to print average of  gpa of students for the specified course/subject
i/p : course


4 Print name of specified subject  topper
Hint : studentList ---stream --filter --max(comp based on GPA)

5 Print no of  failures for the specified subject chosen  from user , use student map
(gpa < 5 : failed case)
Hint : studentMap -- values---Collection<Student> ----stream --filter(subject/course)---filter(GPA) --count 

6. Display all student details from a student map
Hint --studentMap--forEach

 */

public class Test {
	
	public static void main(String[] args) {
		
		
		try(Scanner sc = new Scanner(System.in)){
			

//1. Display all student details from a student list

			
			System.out.println();
			
			System.out.println("populating data");
			
			List<Student> list = StudentUtils.populateList();
			Map<String, Student> map = StudentUtils.populateMap();
			
			System.out.println("Displaying all student details using list");
			
			
			list.stream().forEach(i -> System.out.println(i + " "));
			
			System.out.println("Displaying all student details using map");
			
			
			map.forEach((k,v)-> System.out.println(v));
			
			

//2. Display all student details(list) sorted as per GPA 
//Use custom ordering
			
			System.out.println();
			
			System.out.println("Students details as per sorted marks, desc");
			
			list.stream().sorted((o1,o2)-> ((Integer)o2.getMarks()).compareTo(o1.getMarks())).forEach(System.out::println);
			
			
			

	//3. Write a tester to print average of  gpa of students for the specified course/subject
	//i/p : course
			
			System.out.println();
			
			System.out.println("Enter course name to find average of marks");
			
			Course crs = Course.valueOf(sc.next().toUpperCase());
			System.out.println("Average of students marks");
			
			double d = list.stream().filter(student -> student.getEnrolledCourse() == crs).mapToDouble(student -> student.getMarks()).average().orElse(0);
			
			System.out.println(d);
			
			

//4 Print name of specified subject  topper
//Hint : studentList ---stream --filter --max(comp based on GPA)

			System.out.println();
			System.out.println("Enter name of course to get the topper ");
			Course c =  Course.valueOf(sc.next().toUpperCase());
			Student topper = list.stream().filter(student -> student.getEnrolledCourse() == c).max((o1,o2)-> ((Integer)o1.getMarks()).compareTo(o2.getMarks())).orElseThrow();
			System.out.println("Topper is : " + topper);
			
			
			

//5 Print no of  failures for the specified subject chosen  from user , use student map
//(gpa < 5 : failed case)
			
			System.out.println();
			System.out.println("Enter name of course to get the list of failed students ");
			Course cr =  Course.valueOf(sc.next().toUpperCase());
			map.values().stream().filter(student -> student.getEnrolledCourse() == cr).filter(student -> student.getMarks() < 620).forEach(System.out::println);
			
			
//			6. Display all student details from a student map
//			Hint --studentMap--forEach
			
			System.out.println();
			
			System.out.println("Details of students from map");
			map.forEach((k,v) -> System.out.println(v));
			
			
		}
	}
	
}



