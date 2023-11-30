package dao;

import java.util.List;

import pojos.Address;

public interface AddressDao {
	
	//add a method to link adr to emp
	String assignEmpAddress(Long empId,Address adr);
	
	// add a method to display emp address or error mesg in case of invalid id return appropriate msg
	String getEmpAddress(Long empId);
	
	// add a method to display last names of all emps from specified city.
//	i/p : city
	List<String> getLastNamesOfEmployeesByCity(String city);
}

