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

			
			
			System.out.println("populating data");
			
			List<Student> list = StudentUtils.populateList();
			Map<String, Student> map = StudentUtils.populateMap();
			
			System.out.println("Displaying all student details using list");
			
			
			list.stream().forEach(i -> System.out.println(i + " "));
			
			System.out.println("Displaying all student details using map");
			
			
			map.forEach((k,v)-> System.out.println(v));
			
			

//2. Display all student details(list) sorted as per GPA 
//Use custom ordering
			
			
			
			

	//3. Write a tester to print average of  gpa of students for the specified course/subject
	//i/p : course
			
			System.out.println("Enter course name ");
			
			Course crs = Course.valueOf(sc.next().toUpperCase());
			System.out.println("Average of students marks");
			
			double d = list.stream().filter(student -> student.getEnrolledCourse() == crs).mapToDouble(student -> student.getMarks()).average().orElse(0);
			
			System.out.println(d);
			

			
		}
	}
}
