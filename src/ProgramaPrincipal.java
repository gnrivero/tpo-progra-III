/*
 * 	Trabajo Practico Obligatorio
 * 
 * 	Integrantes:
 * 					Martin Buzzetti
 * 					Pablo Forcadell
 * 					Gonzalo Rivero
 *  
 * 
 */
import java.io.File;
import java.util.Scanner;

public class ProgramaPrincipal {
	
	private static Scanner input;

	public static void main(String[] args) throws Exception {
		
		input = new Scanner(System.in);

		//Obtengo el archivo a procesar
		
		String rutaArchivoTXT = null;
		File archivo = null;
		
		boolean txtFileExists = false;
		while (!txtFileExists){
			System.out.println("Ingrese la ubicacion de su archivo TXT: ");
		    
			
			rutaArchivoTXT = input.nextLine();
		    
		    archivo = new File(rutaArchivoTXT);
		    
		    if (!archivo.exists() || !archivo.isFile()) {
		    	System.out.println("El archivo indicado no existe o no tiene un formato valido, por favor intente nuevamente");
		    } else {
		    	txtFileExists = true;
		    }
		}
		
		Laberinto laberintoBack = new Laberinto(rutaArchivoTXT);
			    
	    //Obtengo la posicion actual
		
	    int origenEnX = obtenerPosicionValida(input, laberintoBack.getNumFilas(), " X de origen");	    	    	    
	    int origenEnY = obtenerPosicionValida(input, laberintoBack.getNumColumnas(), " Y de origen");
	    
	    Posicion posActual = new Posicion();
	    posActual.setCoordenadas(origenEnX, origenEnY);
	    
	    //Obtengo la posicion destino
		
	    int destinoEnX = obtenerPosicionValida(input, laberintoBack.getNumFilas(), " X de destino");
	    int destinoEnY = obtenerPosicionValida(input, laberintoBack.getNumColumnas(), " Y de destino");
	    
	    Posicion posFinal = new Posicion();
	    posFinal.setCoordenadas(destinoEnX, destinoEnY);
	    
	    input.close();
	    
	    laberintoBack.getMejorLaberinto(posActual, posFinal);
	   
	    laberintoBack.mostrarLaberinto();
	    
	    System.exit(0);
	}
	
	private static int obtenerPosicionValida(Scanner input, int limiteMatriz, String coordenada){
		String strPosicion = null;
		int posicion = 0;
		
		boolean posicionValida = false;
	    while (!posicionValida){
	    	System.out.println("Ingrese la posicion " + coordenada + ": ");
	    	strPosicion = input.nextLine();
	    	posicion = Integer.parseInt(strPosicion);
	    	
	    	if (posicion < 0 || posicion >= limiteMatriz){
	    		System.out.println("Posicion " + coordenada + " no valida");
		    }else{
		    	posicionValida = true;
		    }
	    }
	    
	    return posicion;
	}
	
}
