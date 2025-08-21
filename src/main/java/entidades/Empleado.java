package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Empleado extends Persona implements Serializable {
    private static  final  long serialVersionUID = 1L;

/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;
 */
    private int nroLegajo;
    private double sueldo;

    public Empleado(String nombre, String apellido, long dni, int nroLegajo, double sueldo, Domicilio domicilio) {
        super(nombre, apellido, dni, domicilio);
        this.nroLegajo = nroLegajo;
        this.sueldo = sueldo;
    }

    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
