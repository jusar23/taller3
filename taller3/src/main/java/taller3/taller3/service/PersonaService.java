package taller3.taller3.service;
import taller3.taller3.model.Persona;
import taller3.taller3.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PersonaService {
    @Autowired
    private PersonaRepository PersonaRepository;
    // Crear un nuevo usuario
    public Persona createPersona(Persona persona) {
        return PersonaRepository.save(persona);
    }
    // Obtener un usuario por ID
    public Optional<Persona> getPersonaById(Long id) {
        return PersonaRepository.findById(id);
    }
    // Obtener todos los usuarios
    public List<Persona> getAllPersonas() {
        return PersonaRepository.findAll();
    }
    // Actualizar un usuario
    public Persona updatePersona(Long id, Persona personaDetails) {
        Persona persona = PersonaRepository.findById(id).orElseThrow();
        persona.setNombre(personaDetails.getNombre());
        persona.setApellido(personaDetails.getApellido());
        persona.setTipo(personaDetails.getTipo());
        return PersonaRepository.save(persona);
    }
    // Eliminar un usuario
    public void deletePersona(Long id) {
        PersonaRepository.deleteById(id);
    }
}

