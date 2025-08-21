package entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Domicilio implements Serializable{
    private static  final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDomicilio;

    private String localidad;
    private String calle;
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Persona persona;


    public Domicilio(String localidad, String calle, int numero) {
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
    }

     public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
