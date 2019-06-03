package com.booking.dao;

import java.util.List;

import com.booking.beans.Appointment;
import com.booking.beans.Doctor;
import com.booking.beans.Patient;

public interface DAO {

	public boolean bookAppointment(Appointment appointment);

	public boolean addPatient(Patient patient);

	public boolean addDoctor(Doctor doctor);
	
	public Doctor doctorLogin(String mail ,String passsword);

	public Appointment checkAppointment(int id);

	public Patient patientLogin(int id,String password);

	public List<Doctor> listAllDoctor();

	public List<Patient> listAllPatient();

	public boolean deleteAppointment();

	public boolean deleteDoctor(int did);

	public List<Appointment> viewAllAppointment();

	public boolean selectAppintment();

	public List<Doctor> searchDoctorByCity(String city);

	public List<Doctor> searchDoctorBySpeciality(String speciality);

	


}
