package gaur.example.in.entity.postgres;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdditionalInfo {
	
	private Integer infoId;
	private String batch;
	private String department;
	private String college;
	private boolean passout;
	
	
	public AdditionalInfo(Integer infoId,String batch,String department,String college,boolean passout) {
		this.infoId=infoId;
		this.batch=batch;
		this.department=department;
		this.college=college;
		this.passout=passout;
	}
	

}
