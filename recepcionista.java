package CentroHemoterapiav2;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elina
 */
public class Recepcionista extends Persona implements Runnable {

    public Recepcionista(String n, Clinica c) {
        super(n, c);
    }

    private void darTurno(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Especialista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run(){
        while(true){
            this.clinica.atenderTelefono();
            darTurno();
            this.clinica.colgarTelefono();
        }
    }
}
