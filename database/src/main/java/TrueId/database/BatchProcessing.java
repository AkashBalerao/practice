package TrueId.database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BatchProcessing {
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
			
			PreparedStatement pstmt = con.prepareStatement("Insert into patients(patient_id, first_name, last_name, dob, registration_date) values(?, ?, ?, ?, ?)");
			
			int noOfPatients = Integer.parseInt(br.readLine());
			
			for(int i=0; i<noOfPatients; i++)
			{
				System.out.println("Enter id:");
	    		
	    		int id = Integer.parseInt(br.readLine());
	    		
	    		System.out.println("Enter first_name:");
	    		
	    		String first_name = br.readLine();
	    		
	    		System.out.println("Enter last_name:");
	    		
	    		String last_name = br.readLine();
	    		
	    		System.out.println("Enter date of birth:");
	    		String dat = br.readLine();
	    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	    		LocalDate DOB = LocalDate.parse(dat, dtf);
	    		Date dob = Date.valueOf(DOB);
	    		
	    		Date reg_date = Date.valueOf(LocalDate.now());
	    		
	    		pstmt.setInt(1, id);
	    		pstmt.setString(2, first_name);
	    		pstmt.setString(3, last_name);
	    		pstmt.setDate(4, dob);
	    		pstmt.setDate(5, reg_date);
	    		
	    		pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
