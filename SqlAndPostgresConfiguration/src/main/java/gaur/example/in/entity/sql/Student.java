package gaur.example.in.entity.sql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	
	private String name;
	private String email;
	private String contact;
	
	public Student (Integer id,String name,String email,String contact) {
		this.sid=id;
		this.name=name;
		this.email=email;
		this.contact=contact;
	}

}
