package taller3.taller3.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller3.taller3.model.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
