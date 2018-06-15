import java.util.Scanner;

public class programaPrincipal {
	private static Scanner input;

	public static void main(String[] args) throws Exception {
		/*
		input = new Scanner(System.in);
	    System.out.println("Ingrese la ubicacion de su archivo TXT: ");
	    String archivoTXT = input.nextLine();
	    
	    //Obtengo la posicion actual
	    input = new Scanner(System.in);
	    System.out.println("Ingrese la posicion de origen con el formato (Fila,Columna): ");
	    String origen = input.nextLine();
	    origen.substring(1);
	    String procesar = origen.substring(0, origen.indexOf(','));
	    int x = Integer.parseInt(procesar);
	    origen.substring(procesar.length()+1);
	    procesar = origen.substring(0, origen.indexOf(')'));
	    int y = Integer.parseInt(procesar);
	    
	    posicion posActual = new posicion();
	    posActual.setCoordenadas(x,y);
	    
	  //Obtengo la posicion destino
	    input = new Scanner(System.in);
	    System.out.println("Ingrese la posicion de origen con el formato (Fila,Columna): ");
	    String destino = input.nextLine();
	    destino.substring(1);
	    procesar = destino.substring(0, destino.indexOf(','));
	    x = Integer.parseInt(procesar);
	    destino.substring(procesar.length()+1);
	    procesar = destino.substring(0, destino.indexOf(')'));
	    y = Integer.parseInt(procesar);
	    
	    posicion posFinal = new posicion();
	    posFinal.setCoordenadas(x,y);
	    input.close();
	    
	    //Por ejemplo C:\\temp\\test.txt
	    laberinto laberintoDijkstra = new laberinto(archivoTXT);
	    laberintoDijkstra.getMejorLaberinto(posActual, posFinal);
	    */
		posicion posActual = new posicion();
	    posActual.setCoordenadas(1,1);
	    
	    posicion posFinal = new posicion();
	    posFinal.setCoordenadas(3,3);
	    
	    laberinto laberintoDijkstra = new laberinto("C:\\temp\\test.txt");
	    laberintoDijkstra.getMejorLaberinto(posActual, posFinal);
	    laberintoDijkstra.mostrarLaberinto();
	}
}
