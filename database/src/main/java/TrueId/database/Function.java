package TrueId.database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class Function {
	
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		
		String query = "Select image from image_store where id = 1";
		
		Connection con = null;
		byte img[]=null;
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\JAVA Traning\\database\\bird2.jpg");
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");

		    CallableStatement clstmt = con.prepareCall("{ ? = call get_first_name(?) }");

		    clstmt.registerOutParameter(1, Types.NVARCHAR);

		    clstmt.setInt(2, 100);

		    clstmt.execute();

		    String temp = clstmt.getString(1);
		    System.out.println(temp);

		    clstmt.close();
		    con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
