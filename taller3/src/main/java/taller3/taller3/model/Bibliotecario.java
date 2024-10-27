package taller3.taller3.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "bibliotecario")
public class Bibliotecario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Constructores, Getters y Setters
    public Bibliotecario() {}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
