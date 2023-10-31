package tester;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import core.Entry;

public class Test {

	public static void main(String[] args) {
		
		try(
			BufferedReader bf = new BufferedReader(new FileReader("D:\\java\\practice_qs\\BankAccount\\src\\data"))){
			
			List<Entry> list = new ArrayList<>();
			
		
//			create and read the header
			
			String s = bf.readLine();
			
			
			
			while((s = bf.readLine()) != null) {

				String []  str = s.split(",");
				
				list.add(new Entry(str[0], str[1],Double.parseDouble(str[str.length - 2]), Double.parseDouble(str[str.length - 1])));
			
			}
			
			
//			Sum of all deposits = 54000.0
//					Max deposit amount= 50000.0
//					Shopping expenses = 12000.0
//					Date on which max amount withdrawn= 02-01-2023
			
		
			double sum = list.stream().mapToDouble(e -> e.getDepositAmount()).sum();
			
			System.out.println("sum of all deposites : " + sum);
			
			
			
			
			
			double maxDeposite = list.stream().mapToDouble(e -> e.getDepositAmount()).max().orElseThrow();
			
			System.out.println("max deposite amount : " + maxDeposite);
			
			
			
			
			
			double expenses = list.stream().filter(e -> e.getNarration().equals("Shopping")).mapToDouble(e -> e.getWithdrawalAmount()).sum();
			
			System.out.println("shopping expensed " + expenses);
			
			
			
			
			
			
			
			Entry e = list.stream().max((o1,o2) -> ((Double)o1.getWithdrawalAmount()).compareTo(o2.getWithdrawalAmount())).orElseThrow();
			
			System.out.println("Date on which max amount withdrawn : " + e.getTransactionDate());
			
			
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main over");
		
	}

}
