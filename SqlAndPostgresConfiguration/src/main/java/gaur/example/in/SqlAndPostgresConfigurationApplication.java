package gaur.example.in;

import java.security.PrivateKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gaur.example.in.dao.repo.postgres.PostgresRepo;
import gaur.example.in.dao.repo.sql.StudentRepo;
import gaur.example.in.entity.postgres.AdditionalInfo;
import gaur.example.in.entity.sql.Student;

@SpringBootApplication
public class SqlAndPostgresConfigurationApplication implements CommandLineRunner{
	
	@Autowired
	private StudentRepo sRepo;
	
	@Autowired
	private PostgresRepo pRepo;

	public static void main(String[] args) {
		
		
		SpringApplication.run(SqlAndPostgresConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Student student = new Student(1, "Amrish Gaur", "amrishgaur0576@gmail.com", "9457900668");
		sRepo.save(student);
		
		
		AdditionalInfo info = new AdditionalInfo(11, "2022", "MCA", "VBSPU", true);
		pRepo.save(info);
		// TODO Auto-generated method stub
		
	}

}
