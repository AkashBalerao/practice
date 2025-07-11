package StandAloneCollections;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentDB {
	
	private List<String> names;
	private Map<String, Integer> courses;
	private Properties dpproperties;
	@Autowired
	private Integer age;
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public Map<String, Integer> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, Integer> courses) {
		this.courses = courses;
	}
	public Properties getDpproperties() {
		return dpproperties;
	}
	public void setDpproperties(Properties dpproperties) {
		this.dpproperties = dpproperties;
	}
	@Override
	public String toString() {
		return "StudentDB [names=" + names + ", courses=" + courses + ", dpproperties=" + dpproperties + "] +  age : "+age;
	}
}
