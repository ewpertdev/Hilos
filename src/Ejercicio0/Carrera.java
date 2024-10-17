package Ejercicio0;

 class CarreraCoches implements Runnable {
    private String nombreCoche;
    private int velocidad=1;
    private int distanciaTotal;
    private int distanciaRecorrida;

    public CarreraCoches (String nombreCoche, int velocidad, int distanciaTotal, int distanciaRecorrida)
     {
        this.nombreCoche=nombreCoche;
        this.velocidad=velocidad;
        this.distanciaTotal=distanciaTotal;
        this.distanciaRecorrida = 0;
    }

     @Override
     public void run() {
        while(distanciaRecorrida<distanciaTotal){
            try {
                Thread.sleep(velocidad);
                distanciaRecorrida++;
                System.out.println(nombreCoche +" ha avanzado "+ distanciaRecorrida);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Error");
            }

        }
     }

     public class Carrera {
        public static void main(String[] args){
            CarreraCoches RX7 = new CarreraCoches("Mazda RX7", 161, 100);
            CarreraCoches Bici = new CarreraCoches("Bici rápido", 180, 200);

            for (int i = 0; ;i++){

            }


        }

     }
 }
