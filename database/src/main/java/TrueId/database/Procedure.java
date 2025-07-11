package TrueId.database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class Procedure {
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		
//		String query = "Select image from image_store where id = 1";
		
		Connection con = null;
		byte img[]=null;
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\JAVA Traning\\database\\bird2.jpg");
		try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
				
				CallableStatement cstmnt = con.prepareCall("{call get_first_last_names(?,?,?)}");
				
				cstmnt.setInt(1, 100);
				
				cstmnt.registerOutParameter(2, Types.NVARCHAR);
				
				cstmnt.registerOutParameter(3, Types.NVARCHAR);
				
				cstmnt.execute();
				
				String firstName = cstmnt.getString(2);
	            String lastName = cstmnt.getString(3);
	
	            System.out.println("First Name: " + firstName);
	            System.out.println("Last Name: " + lastName);
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
