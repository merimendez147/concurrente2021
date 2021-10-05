package CentroHemoterapiav2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elina
 */
public class Sillas {

    private int cantSillas;
    private final Semaphore sem = new Semaphore(1);

    public Sillas(int cant) {
        this.cantSillas = cant;
    }

    public int getCant() {
        return cantSillas;
    }

    public void setCant(int cant) {
        this.cantSillas = cant;
    }

    public void liberarSilla() {
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Sillas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cantSillas++;
        sem.release();
    }

    public boolean ocuparSilla() {
        boolean libre = false;
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Sillas.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cantSillas > 0) {
            cantSillas--;
            libre = true;
        }
        sem.release();
        return libre;
    }
}
