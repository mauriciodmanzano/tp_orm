 package main;

import entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaTpOrm");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Domicilio domicilioMedico = new Domicilio("Maipu", "San Martin", 256);
            Medico medico1 = new Medico("Alberto", "Cormillot", 12654723,
                    314, 155874963, domicilioMedico);
            Especialidad nutricionista = new Especialidad("Nutricionista");
            nutricionista.getMedicos().add(medico1);
            medico1.getEspecialidades().add(nutricionista);

            Domicilio domicilioEmpleado = new Domicilio("Godoy Cruz", "Sarmiento", 560);
            Empleado empleado1 = new Empleado("Jorge", "Gomez", 30561497,
                    561428,600000, domicilioEmpleado);

            em.persist(empleado1);

            Domicilio domicilioPaciente = new Domicilio("Lavalle", "El barrial", 568);
            Paciente paciente1 = new Paciente("Estefania", "Cabrera", 26549862,
                    1, domicilioPaciente);
            DetalleHistoriaClinica detalle1 = new DetalleHistoriaClinica(new Date(2024-1900, 9, 15),
                    "Dolor de panza", "Intoxicación", "consumir dieta liviana");
            HistoriaClinica historia1 = new HistoriaClinica(25, new Date(2024-1900, 9,26));
            historia1.getDetalleHistoriaClinica().add(detalle1);
            historia1.setPaciente(paciente1);
            detalle1.setHistoriaClinica(historia1);
            paciente1.setHistoriaClinica(historia1);

            Turno turno1 = new Turno(new Date(2024, 9, 20), 8, 30, paciente1, medico1);
            paciente1.getTurnos().add(turno1);
            medico1.getTurnos().add(turno1);

            em.persist(paciente1);

            em.flush(); //Limpiamos la coneccion

            em.getTransaction().commit(); //Hacemos el comit,transacción se cierra y todos los cambios
                                            // pendientes se aplican de manera definitiva en la base de datos.

        }catch (Exception e){
            em.getTransaction().rollback(); //Hacemos un rollback, en caso de que falle algo al momento de persistir
                                // los datos, aquí volvemos atrás y evitamos que se produzca un daño en la base de datos.
        }

        em.close(); //Cerramos conecciones.
        emf.close();

    }
}
