package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Paciente extends Persona implements Serializable {
    private static  final  long serialVersionUID = 1L;
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;
*/
    private int nroSocio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_historiaClinica")
    private HistoriaClinica historiaClinica;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Turno> turnos;

    public Paciente(String nombre, String apellido, long dni, int nroSocio, Domicilio domicilio) {
        super(nombre, apellido, dni, domicilio);
        this.nroSocio = nroSocio;
        this.turnos=new ArrayList<>();
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
}
