package ec.com.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "estudiante")
public class Estudiante {

    @Id
    @SequenceGenerator ( name = "seq_estudiante_generador", sequenceName = "seq_estudiante",allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seq_estudiante_generador")
    @Column (name = "estu_id")
    private Integer id;

    @Column (name = "estu_nombre")
    private String nombre;

    //getters anda getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
    return "Estudiante [id=" + id + ", nombre=" + nombre + "]";
    }



}
