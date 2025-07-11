package JDBCTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DoctorDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public int insert(Doctor d)
	{
		String query = "insert into doctors(first_name, last_name, specialization) values(?,?,?)";
		
		int result = template.update(query, d.getFirst_name(), d.getLast_name(), d.getSpecialization());
		
		return result;
	}
}
