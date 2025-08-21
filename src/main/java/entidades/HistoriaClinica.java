package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class HistoriaClinica implements Serializable {
    private static  final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistoriaClinica;

    private int numero;
    private Date fechaAlta;

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL)
    private List<DetalleHistoriaClinica> detalleHistoriaClinica;

    @OneToOne(mappedBy = "historiaClinica")
    private Paciente paciente;

    public HistoriaClinica(int numero, Date fechaAlta) {
        this.numero = numero;
        this.fechaAlta = fechaAlta;
        this.detalleHistoriaClinica = new ArrayList<>();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<DetalleHistoriaClinica> getDetalleHistoriaClinica() {
        return detalleHistoriaClinica;
    }

    public void setDetalleHistoriaClinica(List<DetalleHistoriaClinica> detalleHistoriaClinica) {
        this.detalleHistoriaClinica = detalleHistoriaClinica;
    }
}
