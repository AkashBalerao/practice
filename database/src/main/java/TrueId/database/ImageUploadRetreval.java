package TrueId.database;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class ImageUploadRetreval {
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		String query = "Select image from image_store where id = 1";
    	
    	Connection con = null;
    	byte img[]=null;
    	
    	FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\JAVA Traning\\database\\bird2.jpg");
    	try {
    		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "hr");
    		
//    		Statement stmt = con.createStatement();
    		
//    		int rs = stmt.executeUpdate("CREATE TABLE image_store (id NUMBER, name VARCHAR2(100), image BLOB)");
    		
//    		int rs = stmt.executeUpdate("commit");
    		
//    		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\JAVA Traning\\database\\bird.jpg");
    		
    		
    		PreparedStatement pstmt = con.prepareStatement(query);
    		
//    		pstmt.setInt(1, 1);
//    		pstmt.setString(2, "firstfile");
//    		pstmt.setBinaryStream(3, fis, fis.available());
    		
    		ResultSet rs = pstmt.executeQuery();
    		
    		while(rs.next())
    		{
    			img = rs.getBytes("image");
    			
    			if(img!=null)
    			{
    				try {
    					con.close();
    					break;
    				}catch(Exception sq)
    				{
    					sq.printStackTrace();
    				}
    			}
    			System.out.println(img.length);
    		}
    		
//    		System.out.println(rs);
//    		System.out.println(img.length);
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println(e);
    	}
    	fos.write(img);
    	System.out.println(img.length);
	}
}
