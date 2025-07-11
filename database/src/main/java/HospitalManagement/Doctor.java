package HospitalManagement;

import java.util.Date;

public class Doctor {
	private int doctor_id;
	private String first_name;
	private String last_name;
	private String specialization;
	private Date hire_date;
	
	Doctor(String first_name, String last_name, String specialization, Date hire_date)
	{
		this.first_name = first_name;
		this.last_name = last_name;
		this.specialization = specialization;
		this.hire_date = hire_date;
	}
	
	Doctor(int doctor_id, String first_name, String last_name, String specialization, Date hire_date)
	{
		this.doctor_id = doctor_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.specialization = specialization;
		this.hire_date = hire_date;
	}
	
	public void displayDocs() {
		System.out.printf("%-10s %-15s %-15s %-20s %-15s%n", 
		    doctor_id, first_name, last_name, specialization, hire_date);
	}

}
