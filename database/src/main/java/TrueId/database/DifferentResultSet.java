package TrueId.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DifferentResultSet {
	 public static void main( String[] args ) throws SQLException
	    {
	    	Runtime rt = Runtime.getRuntime();
	    	
	    	Scanner sc = new Scanner(System.in);
	    	
	    	String query = "SELECT salary FROM employees WHERE employee_id = ";
	    	
	    	Connection con = null;
//	    	try {
	    		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
	    		
	    		Thread t = new Thread(new CloseResources(con));
	    		rt.addShutdownHook(t);
	    		
	    		System.out.println(con);
	    		Statement stmt = con.createStatement(
	    			    ResultSet.TYPE_SCROLL_INSENSITIVE,
	    			    ResultSet.CONCUR_UPDATABLE
	    			);

	    		
	    		System.out.println("enter our id:");
	    		
	    		query += "'"+sc.nextLine()+"'";
	    		
	    		System.out.println("Enter new sal: ");
	    		
	    		int sal = sc.nextInt();
	    		
	    		ResultSet rs = stmt.executeQuery(query);
	    		
	    		rs.next();
	    		
	    		rs.first();
	    		
	    		rs.updateDouble("salary", sal);
	    		rs.updateRow(); 
	    		
//	    	}catch(Exception e)
//	    	{
//	    		e.printStackTrace();
//	    	}		    	
	    }
}
