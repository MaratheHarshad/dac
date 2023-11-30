package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Employee;

public class AddressDaoImpl implements AddressDao {

	@Override
	public String assignEmpAddress(Long empId, Address adr) {
		String mesg="assigning adr failed : invalid emp id";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			// get persistent emp from DB
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
				// emp exists : persistent
				// establish uni dir link adr --> emp
				adr.setEmp(emp);
				session.persist(adr);
				mesg="Assigned adr to emp "+emp.getFirstName();
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String getEmpAddress(Long empId) {
		
		String mesg="get emp address failed";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			// get persistent emp from DB
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
				// emp exists : persistent
				// establish uni dir link adr --> emp
				
				// empId will work
				// because sharing of primary key
				// @MapsId annotation
				
				Address adr = session.get(Address.class, empId);
				
				if(adr == null) {
					mesg = "address is not specified for this employee";
				}else {
					// if adr exists
					mesg = "Address of employee : " + adr.toString();
				}
				
				
				
			}else {
				// in case of emp is not exist
				mesg = "employee is not exist with this empid";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public List<String> getLastNamesOfEmployeesByCity(String city) {
		

		List<String> lastNames = null;
		
		// write jpql
		
		String jpql = "select a.emp.lastName from Address a where a.city = :city";
		
		
		
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			
			// fetch list of last names using 
			
			
			lastNames = session.createQuery(jpql, String.class).setParameter("city", city).getResultList();

			
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		
		return lastNames;
	}

}
