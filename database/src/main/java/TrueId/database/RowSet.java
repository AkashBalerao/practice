package TrueId.database;

import java.sql.Connection;

import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;

public class RowSet {
	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			
			JdbcRowSet rowSet = new JdbcRowSetImpl();
			
			rowSet.setUrl("jdbc:oracle:thin:@localhost:1521/orclpdb");
	        rowSet.setUsername("hr");
	        rowSet.setPassword("hr");

	        rowSet.setCommand("SELECT first_name, salary FROM employees WHERE department_id = ?");
	        rowSet.setInt(1, 60);
	        rowSet.execute();

	        while(rowSet.next()) {
	            System.out.println("Name: " + rowSet.getString("first_name"));
	            System.out.println("Salary: " + rowSet.getDouble("salary"));
	        }

	        rowSet.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
