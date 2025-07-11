package AutoWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	
	private Address address;

	private Aadhaar aadhaar;
	
	@Autowired
	Person(Aadhaar a)
	{
		this.aadhaar = a;
	}
	
	public void setAddress(Address a)
	{
		this.address = a;
	}

	public Aadhaar getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(Aadhaar aadhaar) {
		this.aadhaar = aadhaar;
	}

	@Override
	public String toString() {
		return "Person [address=" + address + ", aadhaar=" + aadhaar + "]";
	}
}
