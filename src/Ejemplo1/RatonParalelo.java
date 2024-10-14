package Ejemplo1;

public class RatonParalelo extends Thread {
    private String nombre;
    private int tiempoAlimentacion;

    // Constructor que recibe string nombrem int tiempAlimentacion
    public RatonParalelo(String nombre, int tiempoAlimentacion){
        this.nombre=nombre;
        this.tiempoAlimentacion=tiempoAlimentacion;
    }

    @Override // Es un método le la clase Thread
    public void run(){
        // Esto es lo que se va a paralelizar
        this.comer();
    }

    // Metodo comerrun();
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
        RatonParalelo Arturo = new RatonParalelo("Arturo", 4);
        RatonParalelo Bob = new RatonParalelo("Bob", 5);
        RatonParalelo Carlos = new RatonParalelo("Carlos", 3);
        RatonParalelo David = new RatonParalelo("David", 7);


        /* Arturo.run(); no paraleliza, sI puesiera esto todo el rato se ejecutaria secuencialmente.
        IMPORTANTE: hay que llamar a start para que se cree el hilo.
         */
        Arturo.start();
        Bob.start();
        Carlos.start();
        David.start();



        /* Crear hilos start();en Java
        1. La CLASE THREAD
        Lo que crea el Hilo es el método start
        El problema es que no puedo heredar de más clases aparte de Thread. Tiene problema de herencia
        Interface Runnable y Interface Callable

        Ojo que heredar de la clase Thread imposibilita
        heredar de otras clases (pq Java no admite
        herencia múltiple). Lo que hay son interfaces.
        Runnable y Callable. Ver otros ejemplos.

        Nota: otros lenguajes de programación si admiten
        herencia multiple C++, C#, Ruby.


         */




    }
}
