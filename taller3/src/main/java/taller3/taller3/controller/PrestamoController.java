package taller3.taller3.controller;
import taller3.taller3.model.Prestamo;
import taller3.taller3.service.PrestamoService;
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
@RequestMapping("/biblioteca/Prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoService PrestamoService;
    // Crear un nuevo Prestamo
    @PostMapping
    public Prestamo createPrestamo(@RequestBody Prestamo prestamo) {
        return PrestamoService.createPrestamo(prestamo);
    }
    // Obtener todos las Prestamos
    @GetMapping
    public List<Prestamo> getAllPersonas() {
        return PrestamoService.getAllPrestamos();
    }
    // Obtener un Prestamo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable Long id) {
        Optional<Prestamo> prestamo = PrestamoService.getPrestamoById(id);

        return prestamo.map(ResponseEntity::ok).orElseGet(() ->

                ResponseEntity.notFound().build());
    }
    // Actualizar un Prestamo
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@PathVariable Long id, @RequestBody
    Prestamo prestamoDetails) {
        return ResponseEntity.ok(PrestamoService.updatePrestamo(id, prestamoDetails));
    }
    // Eliminar un Persona
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        PrestamoService.deletePrestamo(id);
        return ResponseEntity.noContent().build();
    }
}