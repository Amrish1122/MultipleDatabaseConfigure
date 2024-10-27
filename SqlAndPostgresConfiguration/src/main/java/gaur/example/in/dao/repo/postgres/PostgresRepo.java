package gaur.example.in.dao.repo.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import gaur.example.in.entity.postgres.AdditionalInfo;

public interface PostgresRepo extends JpaRepository<AdditionalInfo, Integer> {

}
