package taller3.taller3.repository;
import taller3.taller3.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long>{
}
