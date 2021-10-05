package CentroHemoterapiav2;



/**
 *
 * @author elina
 */
public class Main {

    public static void main(String[] args) {
        int cantidaddesillas = 2;
        Clinica clinica = new Clinica(cantidaddesillas);
        Thread recepcionista = new Thread(new Recepcionista("Recepcionista", clinica));
        recepcionista.start();
        Thread especialista = new Thread(new Especialista("Especialista", clinica));
        especialista.start();
        Thread extraccionista = new Thread(new Extraccionista("Extraccionista", clinica));
        extraccionista.start();
        int cantDonantes = 6;
        Thread[] donantes = new Thread[cantDonantes];
        for (int i = 0; i < donantes.length; i++) {
            donantes[i] = new Thread(new Donante("Donante"+i, clinica));
        }
        for (int i = 0; i < donantes.length; i++) {
            donantes[i].start();
        }      
    }

}
