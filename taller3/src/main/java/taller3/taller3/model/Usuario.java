package taller3.taller3.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prestamos;
    // Constructores, Getters y Setters
    public Usuario() {}
    public Usuario(Number pestamos) {
        this.prestamos = prestamos;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPrestamos() {
        return prestamos;
    }
    public void setPrestamos(String prestamos) {
        this.prestamos = prestamos;
    }
}
