package TrueId.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class CloseResources extends Thread{
	Connection con;
	
	CloseResources(Connection c)
	{
		this.con = c;
	}
	
	public void run()
	{
		try {
			System.out.println("closing connection.....");
			if(!con.isClosed())
			{
				con.close();				
			}
			System.gc();
			System.out.println(con);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

public class SqlBasic 
{
//	static Connection con;
    public static void main( String[] args ) throws SQLException
    {
    	Runtime rt = Runtime.getRuntime();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	String query = "SELECT * FROM employees WHERE employee_id = 100";
    	
    	Connection con = null;
    	try {
    		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
    		
    		//Making a shutdownhook
    		Thread t = new Thread(new CloseResources(con));
    		rt.addShutdownHook(t);
    		
    		System.out.println(con);
    		Statement stmt = con.createStatement();
    		
    		System.out.println("enter our id:");
    		
    		query += "'"+sc.nextLine()+"'";
    		
    		ResultSet rs = stmt.executeQuery(query);
    		
    		System.out.println("Id\tFirst Name\tcommission_pct");
    		while(rs.next())
    		{
    			int id = rs.getInt("employee_id");
    			String firstname = rs.getString("First_name");
    			String lastname = rs.getString("last_name");
    			double comission_cpt = rs.getFloat("commission_pct");
    			System.out.printf("%d\t%s\t%f\t%s\n",id,firstname,comission_cpt,lastname);
//    			System.out.println(firstname);
    		}
    		
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
    	System.exit(0);
    	
    }
}
