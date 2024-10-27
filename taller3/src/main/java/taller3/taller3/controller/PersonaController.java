package taller3.taller3.controller;
import taller3.taller3.model.Persona;
import taller3.taller3.service.PersonaService;
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
@RequestMapping("/biblioteca/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;
    // Crear un nuevo Persona
    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.createPersona(persona);
    }
    // Obtener todos las Personas
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }
    // Obtener un Persona por ID
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> persona = personaService.getPersonaById(id);

        return persona.map(ResponseEntity::ok).orElseGet(() ->

                ResponseEntity.notFound().build());
    }
    // Actualizar un Persona
    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody
    Persona personaDetails) {
        return ResponseEntity.ok(personaService.updatePersona(id, personaDetails));
    }
    // Eliminar un Persona
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }
}