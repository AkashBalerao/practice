package ConstructorInjection;

public class Person {
	private int personId;
	private String personName;
	private Aadhaar aadhaar;
	
	public Person(int personId, String personName, Aadhaar a) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.aadhaar=a;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", aadhaar=" + aadhaar + "]";
	}
	
}
