package taller3.taller3.service;
import taller3.taller3.model.Libro;
import taller3.taller3.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class LibroService {
    @Autowired
    private LibroRepository LibroRepository;
    // Crear un nuevo usuario
    public Libro createLibro(Libro libro) {
        return LibroRepository.save(libro);
    }
    // Obtener un usuario por ID
    public Optional<Libro> getLibroById(Long id) {
        return LibroRepository.findById(id);
    }
    // Obtener todos los usuarios
    public List<Libro> getAllLibros() {
        return LibroRepository.findAll();
    }
    // Actualizar un usuario
    public Libro updateLibro(Long id, Libro libroDetails) {
        Libro libro = LibroRepository.findById(id).orElseThrow();
        libro.setTitulo(libroDetails.getTitulo());
        libro.setAutor(libroDetails.getAutor());
        libro.setIsbn(libroDetails.getIsbn());
        libro.setDisponible(libroDetails.isDisponible());
        return LibroRepository.save(libro);
    }
    // Eliminar un libro
    public void deleteLibro(Long id) {
        LibroRepository.deleteById(id);
    }
}

