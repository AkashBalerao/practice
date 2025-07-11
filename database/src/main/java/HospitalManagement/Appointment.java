package HospitalManagement;

import java.sql.Timestamp;
import java.util.Date;

public class Appointment {
	private int appointment_id;
	private int patient_id;
	private int doctor_id;
	private Timestamp appointment_date;
	
	Appointment(int app_id, int p_id, int d_id, Timestamp app_date)
	{
		this.appointment_id = app_id;
		this.patient_id = p_id;
		this.doctor_id = d_id;
		this.appointment_date = app_date;
	}
	
	Appointment(int p_id, int d_id, Timestamp app_date)
	{
		this.patient_id = p_id;
		this.doctor_id = d_id;
		this.appointment_date = app_date;
	}

	public int getAppointmentId() {
		return appointment_id;
	}

	public int getPatientId() {
		return patient_id;
	}

	public int getDoctorId() {
		return doctor_id;
	}

	public Timestamp getAppointmentDate() {
		return appointment_date;
	}

}
