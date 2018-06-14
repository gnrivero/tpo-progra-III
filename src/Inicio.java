/* 
 * 
 * TPO Laberinto
 * 
 * Integrantes: Pablo Forcadell
 *              Martin Buzzetti
 *              Gonzalo Rivero
 *              
 */

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombreArchivo = "tablero.txt";
		String linea = " ";
		LeerTxt txt = new LeerTxt();
		
		txt.leerArchivo(nombreArchivo,linea);
		
	}

}
