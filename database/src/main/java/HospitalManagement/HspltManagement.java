package HospitalManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class HspltManagement{
	
	Connection con;
    PatientDao pdao;
    DoctorDao ddao;
    AppointmentDao adao;
	
	HspltManagement(){
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
			pdao = new PatientDao(con);
            ddao = new DoctorDao(con);
            adao = new AppointmentDao(con);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	void addPatient(String first_name, String last_name, Date dob, Date reg_date,String disease) {
		pdao.addPatient(first_name, last_name, dob, reg_date, disease);
	}
	
	void deletePatient(int id) 
	{
		pdao.deletePatient(id);
	}
	
	void viewPatientDetails(int id)
	{
		Patient p = null;
		if(getPatientById(id))
		{
			p = pdao.getPatientById(id);
			p.display();
		}else {
			System.out.println("No patient with "+ id+" exists");
		}
	}
	
	void addDoctor(String first_name, String last_name, String specialization, Date hire_date)
	{
		ddao.addDoctor(first_name, last_name, specialization, hire_date);
	}
	
	void deleteDoctor(int id) 
	{
		if(ddao.deleteDoctor(id))
		{
			deleteAppointmentByDoctorId(id);
		}
		
	}

	public void viewDocAppointmentDetails(int idv) {
		if(getDoctorById(idv))
		{
			ddao.displayAppointmentDetails(idv);			
		}else {
			System.out.println("No Doctor Found with ID: "+idv);
		}
	}
	
	void getAllDoctors()
	{
		ArrayList<Doctor> alldocs = new ArrayList<>();
		alldocs = ddao.getAllDoctors();
		
		if(alldocs.size()>0)
		{
			System.out.printf("%-10s %-15s %-15s %-20s %-15s%n", 
				    "ID", "First Name", "Last Name", "Specialization", "Hire Date");
				System.out.println("-------------------------------------------------------------------------------");
		}
		
		for(Doctor d: alldocs)
		{
			d.displayDocs();
		}
		System.out.println();
	}
	
	boolean getPatientById(int id)
	{
		if(pdao.getPatientById(id)!=null)
		{
			return true;
		}
		return false;
	}

	public boolean getDoctorById(int did) {
		if(ddao.getDoctorById(did)!=null)
		{
			return true;
		}
		return false;
	}
	
	public void bookAppointment(int pid, int did)
	{
		Timestamp d = adao.get_doctor_available_timestamp(did);
		Appointment ap = new Appointment(pid, did, d);
		adao.add_appointment(ap);
	}
	
	public void deleteAppointmentByDoctorId(int id)
	{
		adao.delete_appointments_by_doctorid(id);
	}
	
	public void viewPatientAppointment(int id)
	{
		adao.display_appointment_by_id(id);
	}
}

