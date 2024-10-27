package taller3.taller3.service;
import taller3.taller3.model.Usuario;
import taller3.taller3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository UsuarioRepository;
    // Crear un nuevo usuario
    public Usuario createUsuario(Usuario usuario) {
        return UsuarioRepository.save(usuario);
    }
    // Obtener un usuario por ID
    public Optional<Usuario> getUsuarioById(Long id) {
        return UsuarioRepository.findById(id);
    }
    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return UsuarioRepository.findAll();
    }
    // Actualizar un usuario
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Usuario usuario = UsuarioRepository.findById(id).orElseThrow();
        usuario.setPrestamos(usuarioDetails.getPrestamos());
        return UsuarioRepository.save(usuario);
    }
    // Eliminar un usuario
    public void deleteUsuario(Long id) {
        UsuarioRepository.deleteById(id);
    }
}
