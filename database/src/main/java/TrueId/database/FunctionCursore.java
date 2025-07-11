package TrueId.database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class FunctionCursore {
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		
		String query = "Select image from image_store where id = 1";
		
		Connection con = null;
		byte img[]=null;
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\JAVA Traning\\database\\bird2.jpg");
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");

		    CallableStatement clstmt = con.prepareCall("{ ? = call get_empAboveSal(?) }");

		    clstmt.registerOutParameter(1, Types.REF_CURSOR);

		    clstmt.setInt(2, 100);

		    clstmt.execute();

		    ResultSet rs = (ResultSet) clstmt.getObject(1);
		    
		    while(rs.next())
		    {
		    	String s1 = rs.getString(2);
		    	String s2 = rs.getString(3);
		    	String s3 = rs.getString(4);
		    	System.out.println(s1+" "+s2+" "+s3);
		    }
		    clstmt.close();
		    con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
}
