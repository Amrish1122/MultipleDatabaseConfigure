package gaur.example.in.dao.repo.sql;

import org.springframework.data.jpa.repository.JpaRepository;

import gaur.example.in.entity.sql.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
}
