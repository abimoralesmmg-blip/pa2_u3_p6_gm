package ec.com.uce.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "auditoria")
public class Auditoria {

    @Id
    @SequenceGenerator (name = "seq_auditoria_generador", sequenceName = "seq_auditoria", allocationSize = 1)
    @GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "seq_auditoria_generador")
    @Column (name = " audi_id")
    private Integer id;

    @Column (name = " audi_nombre")
    private String nombreMetodo;

    @Column (name = " audi_argumento")
    private String argumento;

    @Column (name = " audi_fechaHora")
    private LocalDateTime fechaHora;

    @Column(name = "audi_tiempoEjecucionMs")
    private Long tiempoEjecucionMs;

    //setters and getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Long getTiempoEjecucionMs() {
        return tiempoEjecucionMs;
    }

    public void setTiempoEjecucionMs(Long tiempoEjecucionMs) {
        this.tiempoEjecucionMs = tiempoEjecucionMs;
    }
    
    


}
