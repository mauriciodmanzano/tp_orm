package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DetalleHistoriaClinica implements Serializable {
    private static  final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleHD;

    private Date fechaAtencion;
    private String sintomas;
    private String diagnostico;
    private String observaciones;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_historiaClinica")
    private HistoriaClinica historiaClinica;

    public DetalleHistoriaClinica(Date fechaAtencion, String sintomas, String diagnostico, String observaciones) {
        this.fechaAtencion = fechaAtencion;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
}

