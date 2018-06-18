/*
 * 	Trabajo Practico Obligatorio
 * 
 * 	Integrantes:
 * 					Martin Buzzetti
 * 					PAblo Forcadell
 * 					Gonzalo Rivero
 *  
 * 
 */
import java.util.Scanner;

public class programaPrincipal {
	private static Scanner input;

	public static void main(String[] args) throws Exception {
		
		input = new Scanner(System.in);
	    System.out.println("Ingrese la ubicacion de su archivo TXT: ");
	    String archivoTXT = input.nextLine();
	    
	    //Obtengo la posicion actual
	    input = new Scanner(System.in);
	    
	    System.out.println(" ");
	    
	    System.out.println("Ingrese la posicion X de origen: ");
	    String origenX = input.nextLine();
	    int origenEnX = Integer.parseInt(origenX);
	    
	    System.out.println(" ");
	    
	    input = new Scanner(System.in);
	    System.out.println("Ingrese la posicion Y de origen: ");
	    String origenY = input.nextLine();
	    int origenEnY = Integer.parseInt(origenY);
	    
	     
	    posicion posActual = new posicion();
	    posActual.setCoordenadas(origenEnX,origenEnY);
	    
	    System.out.println(" ");
	    
	  //Obtengo la posicion destino
	    
	    System.out.println("Ingrese la posicion X de Destino: ");
	    String destinoX = input.nextLine();
	    int destinoEnX = Integer.parseInt(destinoX);
	    
	    System.out.println(" ");
	    
	    input = new Scanner(System.in);
	    System.out.println("Ingrese la posicion Y de Destino: ");
	    String destinoY = input.nextLine();
	    int destinoEnY = Integer.parseInt(destinoY);
	    
	    posicion posFinal = new posicion();
	    posFinal.setCoordenadas(destinoEnX,destinoEnY);
	    input.close();
	    
	    System.out.println(" ");
	    
	    laberinto laberintoBack = new laberinto(archivoTXT);
	    laberintoBack.getMejorLaberinto(posActual, posFinal);
	   
	    laberintoBack.mostrarLaberinto();
	}
}
