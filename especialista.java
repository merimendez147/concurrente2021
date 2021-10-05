package CentroHemoterapiav2;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elina
 */
public class Especialista extends Persona implements Runnable {

    public Especialista(String n, Clinica c) {
        super(n, c);
    }

    private void realizarControl(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Especialista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run(){
        while(true){
             this.clinica.entrevistar();
             realizarControl();
             this.clinica.terminarEntrevista();
        }
    }
}
