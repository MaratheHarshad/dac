package utils;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.acts.core.Student;
import com.acts.core.Course;

import custom_exceptions.StudentHandlingException;


public class StudentUtils {
	
	
	// populate students data
	

	public static List<Student> populateList(){
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("101", "Harshad", "Marathe", 847, Course.DAC , LocalDate.parse("2002-04-02")));
		list.add(new Student("88", "Khagesh", "Patil", 643, Course.DAC , LocalDate.parse("2001-02-02")));
		list.add(new Student("100", "Manish", "Ahir", 630, Course.DAC , LocalDate.parse("2002-02-10")));
		list.add(new Student("200", "Amey", "Pote", 600, Course.DBDA, LocalDate.parse("2002-02-10")));
		list.add(new Student("201", "Raj", "Rajput", 700, Course.DBDA, LocalDate.parse("2002-02-10")));
		list.add(new Student("82", "Jatin", "Mitrani", 104, Course.DAC , LocalDate.parse("2002-02-10")));
		list.add(new Student("24", "kunal", "ahirrat", 240, Course.DAC , LocalDate.parse("2002-02-10")));
		
		return list;
		
		
	}
	
	
	public static HashMap<String,Student> populateMap(){
		
		 HashMap<String,Student> map = new HashMap<>();
		 	
		 populateList().stream().forEach(student-> map.put(student.getPrn(), student));
		 
		 
		 return map;
		
		
	}

	
	
//add a method for parsing string --> Course (enum)
	public static Course parseAndValidateCourse(String course)
	{
		return Course.valueOf(course.toUpperCase());
	}
	
	//add a method for parsing string --> LocalDate (dob)
	public static LocalDate parseDob(String dob)
	{
		return LocalDate.parse(dob);
	}
	//add a method for checking for dup student(PRN)
	public static void checkForDup(String prn1,HashMap<String, 
			Student> students1) throws StudentHandlingException
	{
		if(students1.containsKey(prn1))
			throw new StudentHandlingException("Dup PRN !!!!!");
		System.out.println("no dup....");
	}
	
	
	
	
}
