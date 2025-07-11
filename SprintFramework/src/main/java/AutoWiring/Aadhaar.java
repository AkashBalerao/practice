package AutoWiring;

import org.springframework.beans.factory.annotation.Autowired;

public class Aadhaar {
	
	String number;

	private Person p;
	
	Aadhaar(Person a)
	{
		this.p = a;
	}
	

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Aadhaar [name=" + ", number=" + number + "]";
	}
}
