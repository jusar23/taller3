package taller3.taller3.service;
import taller3.taller3.model.Bibliotecario;
import taller3.taller3.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class BibliotecarioService {
    @Autowired
    private BibliotecarioRepository BibliotecarioRepository;
    // Crear un nuevo Bibliotecario
    public Bibliotecario createBibliotecario(Bibliotecario bibliotecario) {
        return BibliotecarioRepository.save(bibliotecario);
    }
    // Obtener un Bibliotecario por ID
    public Optional<Bibliotecario> getBibliotecarioById(Long id) {
        return BibliotecarioRepository.findById(id);
    }
    // Obtener todos los Bibliotecarios
    public List<Bibliotecario> getAllBibliotecarios() {
        return BibliotecarioRepository.findAll();
    }
    // Actualizar un Bibliotecario
    public Bibliotecario updateBibliotecario(Long id, Bibliotecario bibliotecarioDetails) {
        Bibliotecario bibliotecario = BibliotecarioRepository.findById(id).orElseThrow();
        return BibliotecarioRepository.save(bibliotecario);
    }
    // Eliminar un Bibliotecario
    public void deleteBibliotecario(Long id) {
        BibliotecarioRepository.deleteById(id);
    }
}