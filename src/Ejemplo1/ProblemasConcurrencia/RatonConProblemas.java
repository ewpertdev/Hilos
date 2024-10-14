package Ejemplo1.ProblemasConcurrencia;


public class RatonConProblemas implements Runnable {
    private String nombre;
    private int tiempoAlimentacion;
    private int alimentoConsumido = 0;

    // Constructor que recibe string nombrem int tiempAlimentacion
    public RatonConProblemas(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }


    //AUTO GENERATED porque es un método que la interface obliga a implementar
    @Override
    public void run() {
        this.comer();

    }

    // Metodo comer
    public void comer() {
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse\n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            alimentoConsumido++; // hay que conseguir sincronizar esto pq da lugar a condicoines de carrera
            System.out.printf("El ratón %s ha terminado a alimentarse\n", nombre);
            System.out.printf("Alimento consumido: %d\n", alimentoConsumido);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        RatonConProblemas Arturo = new RatonConProblemas("Arturo", 4);
        RatonConProblemas Bob = new RatonConProblemas("Bob", 5);
        RatonConProblemas Carlos = new RatonConProblemas("Carlos", 3);
        RatonConProblemas David = new RatonConProblemas("David", 7);
        //
        for (int i = 0; i < 1000; i++) {
            (new Thread(Arturo)).start();
        }


        // Ventajas: 
        // Desventajas:


    }


}
