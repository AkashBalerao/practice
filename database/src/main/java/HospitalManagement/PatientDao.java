package HospitalManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class PatientNotAdded extends Exception{
	PatientNotAdded(String msg)
	{
		super(msg);
	}
}

class PatientNotDeleted extends Exception{
	PatientNotDeleted(String msg)
	{
		super(msg);
	}
}

public class PatientDao {
	
	private Connection con;
	
	PatientDao(Connection c)
	{
		this.con = c;
	}
	
	public Patient getPatientById(int id)
	{		
		Patient p = null;
		try {
			
			PreparedStatement pstmt = con.prepareStatement("Select * from patients where patient_id = ?");
			pstmt.setInt(1, id);


			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
			    Patient.Builder builder = new Patient.Builder(rs.getInt("patient_id"), rs.getString("first_name"));

			    String lastName = rs.getString("last_name");
			    Date dob = rs.getDate("dob");
			    Date regDate = rs.getDate("registration_date");
			    String disease = rs.getString("disease");

			    if (lastName != null) builder.lastName(lastName);
			    if (dob != null) builder.dateOfBirth(dob);
			    if (regDate != null) builder.regDate(regDate);
			    if (disease != null) builder.disease(disease);

			    p = builder.build();
			}

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return p;
	}
	
	public ArrayList<Patient> getAllPatients()
	{
		ArrayList<Patient> allPatients = new ArrayList<>();
		try {
			
			PreparedStatement pstmt = con.prepareStatement("Select * from patients");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				allPatients.add(buildPatientFromResultSet(rs));	
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return allPatients;
	}
	
    Patient buildPatientFromResultSet(ResultSet rs) throws SQLException {
	    return new Patient.Builder(rs.getInt("patient_id"), rs.getString("first_name"))
	            .lastName(rs.getString("last_name"))
	            .dateOfBirth(rs.getDate("dob"))
	            .regDate(rs.getDate("registration_date"))
	            .disease(rs.getString("disease"))
	            .build();
    }
	
	
	public void addPatient(String first_name, String last_name, Date dob, Date reg_date,String disease) 
	{
		try {
			
			if(con!=null)
			{
				PreparedStatement pstmt = con.prepareStatement("insert into patients(first_name, last_name, dob, registration_date, disease) values(?, ?, ?, ?, ?)");
				pstmt.setString(1, first_name);
				pstmt.setString(2, last_name);
				pstmt.setDate(3, dob);
				pstmt.setDate(4, reg_date);
				pstmt.setString(5, disease);
				
				int rs = pstmt.executeUpdate();
				
				if(rs!=1)
				{
					throw new PatientNotAdded("Patient not added");
				}else {
					System.out.println("Patient Added");
				}
			}else {
				System.out.println("no connection");
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		} catch (PatientNotAdded e) {
			e.printStackTrace();
		}
		
	}
	
//	public void deletePatient(int id) 
//	{
//		if(con!=null)
//		{
//			try {
//				String query = "delete from patients where patient_id = " + id;
//				Statement pstmt = con.createStatement();
//				
////				pstmt.setInt(1, id);
//				
//				int rs = pstmt.executeUpdate(query);
//				System.out.println("deleting");
//				
//				if(rs<=0)
//				{
//					throw new patientNotDeleted("Patient not deleted");
//				}else {
//					System.out.println("Patient Deleted!");
//				}
//				
//			}catch(Exception e)
//			{
//				e.printStackTrace();
//			} 
//		}else {
//			System.out.println("con closed");
//		}
//	}
	
	public void deletePatient(int id) {
	    String sql = "DELETE FROM patients WHERE patient_id = ?";
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	    	//con.setAutoCommit(false);
	        System.out.println("Attempting to delete patient with id: " + id);
	        pstmt.setInt(1, id);
	        int rs = pstmt.executeUpdate();
	        System.out.println("deleting");

	        if (rs <= 0) {
	            throw new PatientNotDeleted("Patient not deleted");
	        } else {
	            System.out.println("Patient Deleted!");
	            //con.commit();
	        }
	        
	    } catch (SQLException e) {
	    	System.out.println("SQLState: " + e.getSQLState());
	        System.out.println("Error Code: " + e.getErrorCode());
	        System.out.println("Message: " + e.getMessage());
	        e.printStackTrace();
	    }catch(PatientNotDeleted es)
	    {
	    	es.printStackTrace();
	    }
	}

	
	
}
