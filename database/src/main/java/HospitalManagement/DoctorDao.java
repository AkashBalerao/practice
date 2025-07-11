package HospitalManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

class DoctorNotAdded extends Exception{
	DoctorNotAdded(String msg)
	{
		super(msg);
	}
}

class DoctorNotDeleted extends Exception{
	DoctorNotDeleted(String msg)
	{
		super(msg);
	}
}

public class DoctorDao {
	
	private Connection con;
	
	DoctorDao(Connection c)
	{
		this.con = c;
	}
	
	public ArrayList<Doctor> getAllDoctors()
	{
		ArrayList<Doctor> allDocs = new ArrayList<>();
		try {
			String query = "Select doctor_id, first_name, last_name, specialization, hire_date from doctors";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				allDocs.add(new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return allDocs;
	}
	
	public void addDoctor(String first_name, String last_name, String specialization, Date hire_date)
	{
		try {
			if(con!=null)
			{
				PreparedStatement pstmt = con.prepareStatement("insert into doctors(first_name, last_name, specialization, hire_date) values(?, ?, ?, ?)");
				pstmt.setString(1, first_name);
				pstmt.setString(2, last_name);
				pstmt.setString(3, specialization);
				pstmt.setDate(4, hire_date);
				
				int rs = pstmt.executeUpdate();
				
				if(rs!=1)
				{
					throw new DoctorNotAdded("Doctor not added");
				}else {
					System.out.println("Doctor Added");
				}
			}else {
				System.out.println("no connection");
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		} catch (DoctorNotAdded e) {
			e.printStackTrace();
		}
	}
	
	public boolean deleteDoctor(int id) {
	    String sql = "DELETE FROM doctors WHERE doctor_id = ?";
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        int rs = pstmt.executeUpdate();

	        if (rs <= 0) {
	            throw new DoctorNotDeleted("Doctor not deleted");
	        } else {
	            System.out.println("Doctor Deleted!");
	            return true;
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Message: " + e.getMessage());
	        e.printStackTrace();
	    }catch(DoctorNotDeleted es)
	    {
	    	es.printStackTrace();
	    }
	    return false;
	}

	public void displayAppointmentDetails(int idv) {
		try {
			if(con!=null)
			{
				PreparedStatement pstmt = con.prepareStatement("Select d.first_name as doctor_name, p.first_name as patient_name, a.appointment_date from doctors d join appointments a on d.doctor_id = a.doctor_id join patients p on p.patient_id = a.patient_id where d.doctor_id = ?");
				
				pstmt.setInt(1, idv);
				
				ResultSet rs = pstmt.executeQuery();
				
				
				boolean found = false;

				while (rs.next()) {
				    if (!found) {
				        System.out.printf("\n%-20s %-20s %-20s %-20s%n", "Doctor Name", "Patient Name", "Appointment Date", "Appointment Time");
				        System.out.println("---------------------------------------------------------------------------------");
				        found = true;
				    }

				    String doctorName = rs.getString("doctor_name");
				    String patientName = rs.getString("patient_name");
				    Timestamp appointmentDateTime = rs.getTimestamp("appointment_date");

				    String appointmentDate = appointmentDateTime.toLocalDateTime().toLocalDate().toString();
				    String appointmentTime = appointmentDateTime.toLocalDateTime().toLocalTime().toString();

				    System.out.printf("%-20s %-20s %-20s %-20s%n", doctorName, patientName, appointmentDate, appointmentTime);
				}

				if (!found) {
				    System.out.println("No appointments found for the given doctor.");
				}

				
			}else {
				System.out.println("no connection");
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Doctor getDoctorById(int id)
	{		
		Doctor d = null;
		try {
			
			PreparedStatement pstmt = con.prepareStatement("Select * from doctors where doctor_id = ?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next())
			{
				d = new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return d;
	}

}
