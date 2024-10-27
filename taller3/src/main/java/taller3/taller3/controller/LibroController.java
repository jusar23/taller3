package taller3.taller3.controller;
import taller3.taller3.model.Libro;
import taller3.taller3.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/biblioteca/Libros")
public class LibroController {
    @Autowired
    private LibroService libroService;
    // Crear un nuevo Libro
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.createLibro(libro);
    }
    // Obtener todos los Libros
    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }
    // Obtener un Libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = libroService.getLibroById(id);

        return libro.map(ResponseEntity::ok).orElseGet(() ->

                ResponseEntity.notFound().build());
    }
    // Actualizar un Libro
    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody
    Libro libroDetails) {
        return ResponseEntity.ok(libroService.updateLibro(id, libroDetails));
    }
    // Eliminar un Libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }
}
