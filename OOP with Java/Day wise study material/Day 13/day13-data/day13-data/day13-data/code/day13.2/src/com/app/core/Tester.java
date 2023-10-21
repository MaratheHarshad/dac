package com.app.core;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {

		/*
		 * 
		 * Emp e =new Mgr(); e.computeSalary(); e=new TempWorker(); e.computeSalary();
		 * 
		 * 
		 * 
		 * ArrayList<Emp> l1=new ArrayList<>();//what's the inferred type of the RHS ? :
		 * ArrayList<Mgr> l2=new ArrayList<>();//what's the inferred type of the RHS ? :
		 * l1=l2; Object o=new Mgr(); ArrayList<Object> l3=new ArrayList<>();//what's
		 * the inferred type of the RHS ? : l3=l2; l3=l1;
		 */
		
		Emp e = new Mgr(1000);
		e.computeSalary();
		e = new TempWorker(1000);
		e.computeSalary();
		
		ArrayList<Emp> l1=new ArrayList<>();
		ArrayList<Mgr> l2=new ArrayList<>();
		
//		Type mis-match errors on line 30,34,35
//		l1 = l2;
		
		ArrayList<Object> l3=new ArrayList<>();
		
//		l3 = l2;
//		l3 = l1;
		
		
		
		ArrayList<?> l5=new ArrayList<>();//what's the implicit type of the RHS ? : 
		l5.add(null);
		
		ArrayList<Mgr> l6=new ArrayList<>();
		l5 = l6;
		
		l6.add(new Mgr(2000));
//		l5.add(new Mgr(1999));

	}

}
