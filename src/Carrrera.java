import java.util.Random;

public class Carrrera {

	public static void main(String[] args) throws InterruptedException {
		// lo vi en tiktok y quise probarlo 
		final int LONGITUD_PISTA = 30; 
        final int NUM_BUSES = 3; //pongo 3 buses pa la carrera
        String[] buses = {
            "   ______  ",
            "  |   |__|  ",
            "  |_O__O_|  "
        };

        int[] posiciones = new int[NUM_BUSES];
        Random random = new Random();

        while (true) {
            //limpiar consola
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("------------------------------------------------------------------------");

            //mostrar los buses en la pista
            for (int i = 0; i < NUM_BUSES; i++) {
                //sacar el id del bus
                System.out.println(" ".repeat(posiciones[i]) + "Bus " + (i + 1));
                for (String linea : buses) {
                    // imprimir el bus con el id
                    System.out.println(" ".repeat(posiciones[i]) + linea);
                }
                 
                System.out.println(); //el espacio entre buses
            }

            //comprobar si algún bus ha llegado a la meta
            for (int i = 0; i < NUM_BUSES; i++) {
                if (posiciones[i] >= LONGITUD_PISTA) {
                    System.out.println("El Bus " + (i + 1) + " ha ganado la carrera!!!!");
                    return; 
                }
            }

            //actualizar posiciones de los buses aleatoriamente
            for (int i = 0; i < NUM_BUSES; i++) {
                posiciones[i] += random.nextInt(3); //sin trampas, avance aleatorio: 0, 1 o 2 espacios
            }

            Thread.sleep(300); //PAUSA para simular el movimiento serrano (300 ms)
        }
	}

}
