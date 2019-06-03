package com.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.booking.beans.Appointment;
import com.booking.beans.Doctor;
import com.booking.beans.Patient;
import com.booking.factory.Manager;

public class DAOJPAImpl implements DAO{

	@Override
	public boolean bookAppointment(Appointment appointment) {

		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			manager.persist(appointment);
			manager.getTransaction().commit();
		    return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addPatient(Patient patient) {

		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			manager.persist(patient);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			manager.persist(doctor);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}		

	}

	@Override
	public Doctor doctorLogin(String mail, String password) {

		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			String log = "select d from Doctor d where email = :id and password = :password";
			Query query = manager.createQuery(log);
			query.setParameter("id",mail);
			query.setParameter("password",password);
			Doctor d = (Doctor) query.getSingleResult();
			return d;

		}catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}		

	}

	@Override
	public Patient patientLogin(int id, String password) {
		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			String log = "select p from Patient p where pid = :id and password = :password";
			Query query = manager.createQuery(log);
			query.setParameter("id",id);
			query.setParameter("password",password);
			Patient p = (Patient) query.getSingleResult();
			return p;

		}catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}		

	}

	@Override
	public List<Doctor> listAllDoctor() {
		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			String log = "select d from Doctor d";
			Query query = manager.createQuery(log);
			List<Doctor>doctor =  query.getResultList();
			return doctor;

		}catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}

	}

	@Override
	public List<Patient> listAllPatient() {
		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			String log = "select p from Patient d";
			Query query = manager.createQuery(log);
			List<Patient>patient =  query.getResultList();
			return patient;

		}catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public boolean deleteAppointment() {

		return false;
	}

	@Override
	public boolean deleteDoctor(int did) {
		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			String log = "Delete from Doctor d where did = :id";
			Query query = manager.createQuery(log);
			query.setParameter("id", did);
			int count = query.executeUpdate();
			if(count>0)
			{
				return true;
			}
			return false;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;

		}
	}

	@Override
	public List<Appointment> viewAllAppointment() {

		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			String log = "select p from Patient d";
			Query query = manager.createQuery(log);
			List<Appointment>appointments =  query.getResultList();
			return appointments;

		}catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public boolean selectAppintment() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Doctor> searchDoctorByCity(String city) {
		// TODO Auto-generated method stub
		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			String log = "select d from Doctor d where city = :city";
			Query query = manager.createQuery(log);
			query.setParameter("city",city);
			List<Doctor>doctor = query.getResultList();
			return doctor;

		}catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}

	}

	@Override
	public List<Doctor> searchDoctorBySpeciality(String speciality) {
		try
		{
			EntityManager manager = Manager.getManager();
			manager.getTransaction().begin();
			String log = "select d from Doctor d where speciality = :speciality";
			Query query = manager.createQuery(log);
			query.setParameter("speciality",speciality);
			List<Doctor>doctor = query.getResultList();
			return doctor;

		}catch(Exception e)
		{
			e.printStackTrace();
			return null;

		}
	}


	@Override
	public Appointment checkAppointment(int id) {
		return null;



	}



}
