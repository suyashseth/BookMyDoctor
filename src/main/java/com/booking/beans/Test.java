package com.booking.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		
		
		
		
		Patient p = new Patient();
		p.setAge(20);
		p.setCity("Bangalore");
		p.setDiseases("Fever");
		p.setEmail("qwer@gmail.com");
		p.setFirstname("Subh");
		p.setGender("male");
		p.setLastname("labh");
		p.setPassword("1234");
	
		
		
		
//				Doctor d = new Doctor();
//				d.setCity("Bangalore");
//				d.setEmail("drShobhit@gmail.com");
//				d.setFirstname("Sudheer");
//				d.setHospital("Aarogya");
//				d.setLastname("jain");
//				d.setPassword("1234");
//				d.setSpeciality("Ortho");
				manager.persist(p);
		//Admin a= new Admin();
		//Appointment a1 = new Appointment();
		manager.getTransaction().commit();



	}
}
