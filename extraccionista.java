package CentroHemoterapiav2;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elina
 */
public class Extraccionista extends Persona implements Runnable {

    public Extraccionista(String n, Clinica c) {
        super(n, c);
    }

    private void extraerSangre() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Extraccionista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run(){
        while(true){
             this.clinica.atenderDonante();
             extraerSangre();
             this.clinica.darCertificado();
        }
    }
    
}
