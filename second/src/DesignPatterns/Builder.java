package DesignPatterns;

class User{
	private final String userId;
	private final String name;
	private final int salary;
	
	private User(UserBuilder userBuilder)
	{
		this.userId = userBuilder.userId;
		this.name = userBuilder.name;
		this.salary = userBuilder.salary;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}
	
	static class UserBuilder{
		private String name;
		private String userId;
		private int salary;
		
		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public UserBuilder setUserId(String userId) {
			this.userId = userId;
			return this;
		}
		public UserBuilder setSalary(int salary) {
			this.salary = salary;
			return this;
		}
		
		public User build()
		{
			User u = new User(this);
			return u;
		}
	}
}

public class Builder {
	public static void main(String [] args)
	{
		User u1 = new User.UserBuilder().setName("Vishal").setUserId("User123").setSalary(100000).build();	
		System.out.println(u1.getName()+" : "+u1.getSalary()+" : "+u1.getUserId());
	}
}
