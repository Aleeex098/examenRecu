package base;

import java.util.Scanner;
import java.util.logging.Logger;

public class ControlCompuertas {
	private static final Logger LOGGER = Logger.getLogger(ControlCompuertas.class.getName());

	private static Scanner teclado = new Scanner(System.in);
	
	private static boolean permiso = false;
	
	private static boolean compuertasVerificadas = false;

	public static void main(String[] args) {

		System.out.println(
				"Este programa lee el nivel de agua de una presa y permite abrir compuertas si tenemos permiso (el nivel es superior a 50) y las compuertas est�n verificadas.");

		int nivel = leerNivelAgua();

		mostrarMenu(nivel);

	}

	/**
	 * muestra un men� interactivo relacionado con el control del nivel de agua en un sistema.
	 * permite al usuario realizar acciones como leer el nivel de agua, abrir compuertas,
	 * solicitar permiso, verificar el estado de las compuertas o salir del men�.
	 *
	 * @param nivel Nivel actual del agua.
	 * @author David Serrano
	 */
	public static void mostrarMenu(int nivel) {
	    int opcion = 0;
	    do {
	        System.out.println();
	        System.out.println("Nivel del agua: " + nivel);
	        System.out.println();
	        System.out.println("ACCIONES: ");
	        System.out.println();
	        System.out.println("1. Nueva lectura del nivel de agua.");
	        System.out.println("2. Abrir compuertas. Requiere:");
	        System.out.println("    3. Solicitar permiso, estado: " + (permiso ? "CONCEDIDO" : "NO CONCEDIDO"));
	        System.out.println("    4. Verificar compuertas, estado: " + (compuertasVerificadas ? "VERIFICADAS" : "NO VERIFICADAS"));
	        System.out.println("5. Salir");
	        System.out.println();
	        System.out.print("Introduce opci�n: ");
	        opcion = teclado.nextInt();
	        switch (opcion) {
	            case 1:
	                nivel = leerNivelAgua();
	                permiso = false;
	                compuertasVerificadas = false;
	                break;
	            case 2:
	                if(abrirCompuertas()) {
	                    System.out.println();
	                    System.out.print("�Compuertas abiertas!");
	                } else {
	                    System.out.println();
	                    System.out.print("No se cumplen las condiciones para abrir compuertas.");
	                }
	                break;
	            case 3:
	                permiso = solicitarPermiso(nivel);
	                if(!permiso) {
	                    System.out.println();
	                    System.out.print("El permiso solamente se concede si el nivel del agua es superior a 60.");
	                }
	                break;
	            case 4:
	                compuertasVerificadas = verificarCompuertas();
	                if(compuertasVerificadas) {
	                    System.out.println();
	                    System.out.print("�Compuertas verificadas!");
	                }
	                break;
	            default:
	                break;
	        }
	    } while (opcion != 5);
	}

	/**
	 * Genera y devuelve un nivel de agua aleatorio
	 *
	 * @return Nivel de agua generado
	 */
	static int leerNivelAgua() {
	    permiso = false;
	    int nivel = (int) Math.round(Math.random() * 100);
	    return nivel;
	}

	/**
	 * Verifica si se cumplen las condiciones para abrir las compuertas
	 *
	 * @return Verdadero si se pueden abrir las compuertas, falso en caso contrario
	 */
	static boolean abrirCompuertas() {
	    if (permiso && compuertasVerificadas) {
	        return true;
	    } else {
	        return false;
	    }
	}

	/**
	 * Verifica si el nivel de agua es superior a 60 para conceder permiso
	 *
	 * @param nivel Nivel de agua actual.
	 * @return Verdadero si se concede el permiso, falso en caso contrario
	 */
	static boolean solicitarPermiso(int nivel) {
	    if (nivel > 60) {
	        return true;
	    } else {
	        return false;
	    }
	}

	/**
	 * Simula la verificaci�n de las compuertas.
	 *
	 * @return Siempre devuelve verdadero.
	 */
	static boolean verificarCompuertas() {
	    return true;
	}
}
