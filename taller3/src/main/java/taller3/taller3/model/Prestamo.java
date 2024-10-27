package taller3.taller3.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "libro_id")
    private Libro libro;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "prestamo_usuario",joinColumns = @JoinColumn(name="prestamo_id"),inverseJoinColumns = @JoinColumn(name="usuario_id"))
    private Usuario usuario;
    private Date fecha_prestamo;
    private Date fecha_devolucion;

    // Constructores, Getters y Setters
    public Prestamo() {
    }

    public Prestamo(Long id, Libro libro, Usuario usuario, Date fecha_prestamo, Date fecha_devolucion) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }
}