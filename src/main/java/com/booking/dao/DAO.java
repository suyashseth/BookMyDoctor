package com.booking.dao;

import java.util.List;

import com.booking.beans.Appointment;
import com.booking.beans.Doctor;
import com.booking.beans.Patient;

public interface DAO {

	public boolean bookAppointment(Appointment appointment);

	public boolean addPatient(Patient patient);

	public boolean addDoctor(Doctor doctor);

	public Appointment doctorLogin(int id,String password);

	public Patient patientLogin(int id,String password);

	public List<Doctor> listAllDoctor();

	public List<Patient> listAllPatient();

	public boolean deleteAppointment();

	public boolean deleteDoctor();

	public List<Appointment> viewAllAppointment();

	public boolean selectAppintment();

	public Doctor searchDoctorByCity(String city);
	
	public Doctor searchDoctorBySpeciality(String speciality);

	public boolean updateDoctor(Doctor doctor);
	
	public boolean updatePatient(Patient patient);
	
	


}
