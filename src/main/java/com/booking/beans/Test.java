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
		Doctor d = new Doctor();
		Admin a= new Admin();
		manager.getTransaction().commit();
		
		
		
	}
}
