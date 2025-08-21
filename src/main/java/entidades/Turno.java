package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Turno implements Serializable {
    private static  final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurno;

    private Date fecha;
    private int hora;
    private int minutos;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_paciente")
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_medico")
    private Medico medico;

    public Turno(Date fecha, int hora, int minutos, Paciente paciente, Medico medico) {
        this.fecha = fecha;
        this.hora = hora;
        this.minutos = minutos;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
