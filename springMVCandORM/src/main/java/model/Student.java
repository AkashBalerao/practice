package model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Student {

	@NotBlank(message = "name cannot be blank")
	String name;
	
	@Email(message = "email should be valid")
	@NotBlank(message = "email should not be empty")
	String email;
	
	@Min(value = 18,message = "age must be 18 and greater")
	int age;
}
