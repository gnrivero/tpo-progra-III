
import java.io.FileReader;
import java.io.BufferedReader;

public class LeerTxt{
	
	public void leerArchivo(String nombreArchivo, String linea) {
	
	try {
		
		FileReader archivo = new FileReader(nombreArchivo);
		BufferedReader buffer = new BufferedReader(archivo);
		
		linea = buffer.readLine();
		System.out.println(linea);	
		
	}catch (Exception ex) {
		System.out.println("Error en la lectura del Archivo");
	}
	
	}
		
	public void dividirLinea(String linea,String [] datos ) {
		
		
		
	}
		
}
