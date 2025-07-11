package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "StoreIdGen")
	@SequenceGenerator(name = "StoreIdGen",allocationSize = 1,initialValue = 1001)
	Integer id;
	
	@Column(length = 20)
	String name;
	
	Integer count;
}
