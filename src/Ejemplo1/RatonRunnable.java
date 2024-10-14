package Ejemplo1;

public class RatonRunnable implements Runnable {
    private String nombre;
    private int tiempoAlimentacion;

    // Constructor que recibe string nombrem int tiempAlimentacion
    public RatonRunnable(String nombre, int tiempoAlimentacion){
        this.nombre=nombre;
        this.tiempoAlimentacion=tiempoAlimentacion;
    }

    
    //AUTO GENERATED porque es un método que la interface obliga a implementar
    @Override
    public void run() {
        this.comer();
        
    }

    // Metodo comer
    public void comer(){
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse\n", nombre);
            Thread.sleep(tiempoAlimentacion*1000);
            System.out.printf("El ratón %s ha terminado a alimentarse\n", nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        RatonRunnable Arturo = new RatonRunnable("Arturo", 4);
        RatonRunnable Bob = new RatonRunnable("Bob", 5);
        RatonRunnable Carlos = new RatonRunnable("Carlos", 3);
        RatonRunnable David = new RatonRunnable("David", 7);

        /* De alguna forma hay que utilizar THREAD  que es la clase que crea hilos.
            Lo que podemos utilizar es el constructor de THREAD.

            THREAD tiene un constructor que admite un argumento de tipo Runnable.

            VAMOS A CREAR HILOS DANDO UN ARGUMENTO ALGO QUE SEA RUNNABLE

         */

        // Creo un hilo t1 dando un argumento Arturo
        Thread t1 = new Thread(Arturo);
        Thread t2= new Thread(Bob);
        Thread t3= new Thread(Carlos);
        Thread t4=new Thread(David);

        // (new Thread(Bob)).start(); otra forma (menos recomendable) de hacer en una sola línea/inmediatamente
        // Encola el hilo para su ejecución paralela

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Ventajas:
        // Desventajas:


    }


}
