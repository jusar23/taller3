package taller3.taller3.controller;
import taller3.taller3.model.Bibliotecario;
import taller3.taller3.service.BibliotecarioService;
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
@RequestMapping("/biblioteca/bibliotecarios")
public class BibliotecarioController {
    @Autowired
    private BibliotecarioService bibliotecarioService;
    // Crear un nuevo Bibliotecario
    @PostMapping
    public Bibliotecario createBibliotecario(@RequestBody Bibliotecario bibliotecario) {
        return bibliotecarioService.createBibliotecario(bibliotecario);
    }
    // Obtener todos los Bibliotecarios
    @GetMapping
    public List<Bibliotecario> getAllBibliotecarios() {
        return bibliotecarioService.getAllBibliotecarios();
    }
    // Obtener un Bibliotecario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> getBibliotecarioById(@PathVariable Long id) {
        Optional<Bibliotecario>bibliotecario = bibliotecarioService.getBibliotecarioById(id);

        return bibliotecario.map(ResponseEntity::ok).orElseGet(() ->

                ResponseEntity.notFound().build());
    }
    // Actualizar un Bibliotecario
    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> updateBibliotecario(@PathVariable Long id, @RequestBody
    Bibliotecario bibliotecarioDetails) {
        return ResponseEntity.ok(bibliotecarioService.updateBibliotecario(id, bibliotecarioDetails));
    }
    // Eliminar un Bibliotecario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBibliotecario(@PathVariable Long id) {
        bibliotecarioService.deleteBibliotecario(id);
        return ResponseEntity.noContent().build();
    }
}