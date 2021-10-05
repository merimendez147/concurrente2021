package CentroHemoterapiav2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elina
 */
public class Clinica {

    Semaphore semRecepcion;
    Semaphore semTelefono;
    Semaphore semEntrevista;
    Semaphore semDonacion;
    Semaphore semSalaExtraccion;
    Semaphore semExtraccion;
    Semaphore semDesayuno;
    Sillas sillas;

    public Clinica(int cantSillas) {
        this.sillas = new Sillas(cantSillas);
        this.semRecepcion = new Semaphore(1, true);
        this.semTelefono = new Semaphore(0, true);
        this.semEntrevista = new Semaphore(0, true);
        this.semDonacion = new Semaphore(1, true);
        this.semSalaExtraccion = new Semaphore(0, true);
        this.semExtraccion = new Semaphore(0, true);
        this.semDesayuno = new Semaphore(0, true);
    }

    public void solicitarTurno() {
        try {
            semRecepcion.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        semTelefono.release();

    }

    public boolean esAdmitido() {
        return this.sillas.ocuparSilla();
    }

    public void esperaEntrevista() {
        try {
            semDonacion.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void irALaEntrevista() {
        semEntrevista.release();
        this.sillas.liberarSilla();
    }

    public void irALaSalaExtraccion() {
        try {
            semSalaExtraccion.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        semExtraccion.release();
        semDonacion.release();
    }

    public void irALaSalaDesayunar() {
        try {
            semDesayuno.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atenderTelefono() {
        try {
            semTelefono.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void colgarTelefono() {
        semRecepcion.release();
    }

    public void entrevistar() {
        try {
            semEntrevista.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminarEntrevista() {
        semSalaExtraccion.release();
    }

    public void atenderDonante() {
        try {
            semExtraccion.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void darCertificado() {
        semDesayuno.release();
    }
}
