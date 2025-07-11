package HospitalManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient {
	
	private int patient_id;
	private String first_name;
	private String last_name;
	private Date dob;
	private Date reg_date;
	private String disease;
	
	Patient(Builder builder){
		this.patient_id = builder.patient_id;
		this.first_name = builder.first_name;
		this.last_name = builder.last_name;
		this.dob = builder.dob;
		this.reg_date = builder.reg_date;
		this.disease = builder.disease;
	}
	
	public static class Builder
	{
		private int patient_id;
		private String first_name;
		private String last_name;
		private Date dob;
		private Date reg_date;
		private String disease;
		
		Builder(String first_name)
		{
			this.first_name = first_name;
		}
		
		Builder(int patient_id, String first_name)
		{
			this.patient_id = patient_id;
			this.first_name = first_name;
		}
		
		public Builder lastName(String last_name)
		{
			if(last_name!=null) this.last_name = last_name;
			return this;
		}
		
		public Builder dateOfBirth(Date dob)
		{
			if(dob!=null) this.dob = dob;
			return this;
		}
		
		public Builder regDate(Date reg_date)
		{
			if(reg_date!=null) this.reg_date = reg_date;
			return this;
		}
		
		public Builder disease(String disease)
		{
			if(disease != null) this.disease = disease;
			return this;
		}
		
		public Patient build()
		{
			return new Patient(this);
		}
		
	}
	
	void display() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	    System.out.println("=====================================");
	    System.out.println("         Patient Information         ");
	    System.out.println("=====================================");
	    System.out.println("First Name     : " + (first_name != null ? first_name : "N/A"));
	    System.out.println("Last Name      : " + (last_name != null ? last_name : "N/A"));
	    System.out.println("Date of Birth  : " + (dob != null ? sdf.format(dob) : "N/A"));
	    System.out.println("Registered On  : " + (reg_date != null ? sdf.format(reg_date) : "N/A"));
	    System.out.println("Disease        : " + (disease != null ? disease : "N/A"));
	    System.out.println("=====================================");
	}

}
