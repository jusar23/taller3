package taller3.taller3.service;
import taller3.taller3.model.Prestamo;
import taller3.taller3.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository PrestamoRepository;
    // Crear un nuevo usuario
    public Prestamo createPrestamo(Prestamo prestamo) {
        return PrestamoRepository.save(prestamo);
    }
    // Obtener un usuario por ID
    public Optional<Prestamo> getPrestamoById(Long id) {
        return PrestamoRepository.findById(id);
    }
    // Obtener todos los usuarios
    public List<Prestamo> getAllPrestamos() {
        return PrestamoRepository.findAll();
    }
    // Actualizar un usuario
    public Prestamo updatePrestamo(Long id, Prestamo prestamoDetails) {
        Prestamo prestamo = PrestamoRepository.findById(id).orElseThrow();
        prestamo.setLibro(prestamoDetails.getLibro());
        prestamo.setUsuario(prestamoDetails.getUsuario());
        prestamo.setFecha_prestamo(prestamoDetails.getFecha_prestamo());
        prestamo.setFecha_devolucion(prestamoDetails.getFecha_devolucion());
        return PrestamoRepository.save(prestamo);
    }
    // Eliminar un usuario
    public void deletePrestamo(Long id) {
        PrestamoRepository.deleteById(id);
    }
}