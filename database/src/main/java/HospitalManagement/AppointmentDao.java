package HospitalManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppointmentDao {
	
	private Connection con;
	
	AppointmentDao(Connection c)
	{
		this.con = c;
		delete_appointments();
	}
	
	public void add_appointment(Appointment ap)
	{
		try {
			PreparedStatement pstmt = con.prepareStatement("Insert into appointments(patient_id, doctor_id, appointment_date) values(?, ?, ?)");
			
			pstmt.setInt(1, ap.getPatientId());
			pstmt.setInt(2, ap.getDoctorId());	
			pstmt.setTimestamp(3,  ap.getAppointmentDate());
			
			int rs = pstmt.executeUpdate();
			
			if(rs==1)
			{
				System.out.println("Appointment Booked!");
			}else {
				System.out.println("Appointment Failed!");
			}
			pstmt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void display_appointment_by_id(int id)
	{
		Appointment ap = null;
		try(PreparedStatement pstmt = con.prepareStatement(
	            "SELECT a.appointment_id, a.patient_id, a.doctor_id, a.appointment_date, " +
	            "p.first_name AS patient_name, p.dob, " +
	            "d.first_name AS doctor_name, d.specialization " +
	            "FROM appointments a " +
	            "JOIN patients p ON a.patient_id = p.patient_id " +
	            "JOIN doctors d ON a.doctor_id = d.doctor_id " +
	            "WHERE a.patient_id = ?"
	        )) {
			 
			
			pstmt.setInt(1, id);
			
			try(ResultSet rs = pstmt.executeQuery())
			{
				if (rs != null && rs.next()) {
		            System.out.println("------ Appointment Details ------");
		            System.out.println("Appointment ID   : " + rs.getInt("appointment_id"));
		            System.out.println("Patient ID       : " + rs.getInt("patient_id"));
		            System.out.println("Patient Name     : " + rs.getString("patient_name"));
		            System.out.println("Patient DOB      : " + rs.getDate("dob"));
		            System.out.println("Doctor ID        : " + rs.getInt("doctor_id"));
		            System.out.println("Doctor Name      : " + rs.getString("doctor_name"));
		            System.out.println("Specialization   : " + rs.getString("specialization"));
		            System.out.println("Appointment Date : " + rs.getTimestamp("appointment_date"));
		            System.out.println("--------------------------------");
		        } else {
		            System.out.println("No appointment found for Patient ID: " + id);
		        }		
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public int get_noof_appointments_ofDoc_byDate(int did, Date d)
	{
		String query = "select count(*) from appointments where doctor_id = ? and appointment_date = ?";
	    try (PreparedStatement pstmt = con.prepareStatement(query)) {
	        pstmt.setInt(1, did);
	        pstmt.setDate(2, new java.sql.Date(d.getTime()));

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;

	}
	
	public Timestamp get_doctor_available_timestamp(int doctorId) {
	    LocalDate date = LocalDate.now();

	    LocalTime[] timeSlots = {
	        LocalTime.of(9, 0),
	        LocalTime.of(11, 0),
	        LocalTime.of(14, 0),
	        LocalTime.of(16, 0),
	        LocalTime.of(18, 0)
	    };

	    while (true) {
	        for (LocalTime time : timeSlots) {
	            LocalDateTime dateTime = LocalDateTime.of(date, time);
	            Timestamp appointmentTimestamp = Timestamp.valueOf(dateTime);

	            if (!is_Time_Slot_Booked(doctorId, appointmentTimestamp)) {
	                return appointmentTimestamp;
	            }
	        }

	        date = date.plusDays(1);
	    }
	}

	
	private boolean is_Time_Slot_Booked(int doctorId, Timestamp timestamp) {
	    String query = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_date = ?";
	    try (PreparedStatement pstmt = con.prepareStatement(query)) {
	        pstmt.setInt(1, doctorId);
	        pstmt.setTimestamp(2, timestamp);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public void delete_appointments()
	{
		String query = "delete from appointments where appointment_date < TO_CHAR(SYSDATE, 'DD-MM-YYYY')";
	    try (PreparedStatement pstmt = con.prepareStatement(query)) {
	        pstmt.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void delete_appointments_by_doctorid(int id)
	{
		String query = "delete from appointments where doctor_id = "+id;
	    try (PreparedStatement pstmt = con.prepareStatement(query)) {
	        pstmt.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
