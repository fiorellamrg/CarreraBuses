import java.util.Random;
import java.util.Scanner;

public class Carrrera {

	public static void main(String[] args) throws InterruptedException {
		// lo vi en tiktok y quise probarlo 
		Scanner sc = new Scanner(System.in);
		final int LONGITUD_PISTA = 30; 
        final int NUM_BUSES = 3; //pongo 3 buses pa la carrera
        String[] buses = {
            "   ______  ",
            "  |   |__|  ",
            "  |_O__O_|  "
        };

        int[] posiciones = new int[NUM_BUSES];
        Random random = new Random();

        //preguntar los nombres de los 3 conductores
        System.out.println("Comienza la carrera de buses 2025!!\nDime el nombre del primer conductor");
        String cond1 = sc.nextLine();
        System.out.println("Dime el nombre del segundo conductor");
        String cond2 = sc.nextLine();
        System.out.println("Dime el nombre del tercer conductor");
        String cond3 = sc.nextLine();
        
        String[] conductores = {cond1, cond2, cond3};
        
        while (true) {
            //limpiar consola
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("------------------------------------------------------------------------");

            //mostrar los buses en la pista
            for (int i = 0; i < NUM_BUSES; i++) {
                //sacar el id del bus 
                System.out.println(" ".repeat(posiciones[i]) + "Bus " + (i + 1) + " - " + conductores[i]);
                for (String linea : buses) {
                    // imprimir el bus con el id
                    System.out.println(" ".repeat(posiciones[i]) + linea);
                }
                 
                System.out.println(); //el espacio entre buses
            }

            //comprobar si algún bus ha llegado 
            for (int i = 0; i < NUM_BUSES; i++) {
                if (posiciones[i] >= LONGITUD_PISTA) {
                    System.out.println("El Bus " + (i + 1) + " ha ganado la carrera!!!!");
                    System.out.println("Winner isssssss " + conductores[i]);
                    return; 
                }
            }

            //mover buses
            for (int i = 0; i < NUM_BUSES; i++) {
                posiciones[i] += random.nextInt(3); // 0, 1 o 2 
                posiciones[i] = Math.min(posiciones[i], LONGITUD_PISTA);
            }

            Thread.sleep(300); //PAUSA para simular el movimiento serrano q serian 300 ms
        }
	}

}
