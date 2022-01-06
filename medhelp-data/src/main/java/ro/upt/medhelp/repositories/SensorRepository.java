package ro.upt.medhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upt.medhelp.dao.SensorDAO;

@Repository
public interface SensorRepository extends JpaRepository<SensorDAO, Long> {
}
