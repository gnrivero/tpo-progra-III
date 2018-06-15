import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class laberinto {
	private tablero tableroLaberinto;
	private tablero mejorTableroLaberinto;
	private int numFilas;
	private int numColumnas;
	
	public laberinto(String archivoTXT) {
		String str=convertirArchivoAString(archivoTXT);
		
		//Obtengo la cantidad de filas del laberinto
		String procesar = str.substring(0, str.indexOf(','));
		numFilas = Integer.parseInt(procesar);
		str=str.substring(procesar.length()+1);
		
		//Obtengo la cantidad de columnas del laberinto y elimino los datos que acabo de usar del string
		procesar = str.substring(0, str.indexOf('-'));
		numColumnas = Integer.parseInt(procesar);
		str=str.substring(procesar.length()+2);
		
		tableroLaberinto = new tablero(numFilas, numColumnas);
		mejorTableroLaberinto = new tablero(numFilas, numColumnas);
		
		//Reemplazo los parentesis por comas
		str=str.replaceAll("\\(", "");
		str=str.replaceAll("\\)", ",");
		
		//pregunto si numFilas corresponde con el archivo
		if(archivoTxtOk(archivoTXT)) {
			//Cargo sus datos por fila y por columna. Al terminar de cargar una fila, elimino el espacio.
			for(int i=0; i<numFilas; i++) {
				for(int j=0; j<numColumnas; j++) {
					//Obtengo la letra que correspondiente a la posicion
					procesar = str.substring(0, str.indexOf(','));
					char nuevoEstado = (char) procesar.charAt(0);
					str=str.substring(procesar.length()+1);
					
					//Obtengo el peso que correspondiente a la posicion
					procesar = str.substring(0, str.indexOf(','));
					int nuevoPeso = (int) Integer.parseInt(procesar);
					str=str.substring(procesar.length()+1);
					
					tableroLaberinto.setPosicion(i, j, nuevoEstado, nuevoPeso, false);
				}
			}
		}
	}
	
	//Retorna TRUE cuando en el archivo hay tantas filas y columnas como coordenadas
	private boolean archivoTxtOk(String archivoTXT) {
		int counter = 0;
		String str=convertirArchivoAString(archivoTXT);
		for(int i=0; i<str.length(); i++) {
		    if( str.charAt(i) == '(' ) {
		        counter++;
		    } 
		}
		if(counter==(this.numFilas*this.numColumnas)) {
			return true;
		}else {
			return false;
		}
	}

	//Convierte el contenido del archivoTXT a String
	private static String convertirArchivoAString(String archivoTXT) {
		String str = "";
		try {
			str = new String(Files.readAllBytes(Paths.get(archivoTXT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	//Imprime por pantalla V cuando la celda del laberinto fue visitada y F cuando no. 
	public void mostrarLaberinto() {
		for(int i=0; i<numFilas; i++) {
			for(int j=0; j<numColumnas; j++) {
				if(tableroLaberinto.getPosicion(i, j).getVisitado()) {
					System.out.print("V");
				}else {
					System.out.print("F");	
				}
				if(j<numColumnas-1) {
					System.out.print("-");
				}
			}
			System.out.println("");
		}
	}
	
	//Devuelve el recorrido de menor peso que existe entre la posicion origen y la destino
	public tablero getMejorLaberinto(posicion posActual, posicion posFinal) {
		int valorActual = 0;
	    int mejorValor = 99999999;
		resolverLaberinto(this.tableroLaberinto, posActual, posFinal, valorActual, this.mejorTableroLaberinto, mejorValor);
		return mejorTableroLaberinto;
	}
	
	private void resolverLaberinto(tablero tableroLaberinto, posicion posActual, posicion posFinal, int valorActual, tablero mejorTableroLaberinto, int mejorValor) {
		if(tableroLaberinto.esFin(posActual, posFinal)) {
			if(valorActual < mejorValor) {
				mejorValor = valorActual;
				mejorTableroLaberinto.reemplazarTablero(tableroLaberinto);
			}
		}else {
			posActual.setCoordenadas(posActual.getCoordenadaX() + 1, posActual.getCoordenadaY());
			if(tableroLaberinto.verificarLimites(posActual)) {
				posicion posActualEnTablero=tableroLaberinto.getPosicion(posActual.getCoordenadaX(), posActual.getCoordenadaY());
				if((!posActualEnTablero.getVisitado()) && (posActualEnTablero.noHayPared()==true)) {
					valorActual = valorActual + posActualEnTablero.getPeso();
					posActualEnTablero.setVisitado(true);
					resolverLaberinto(tableroLaberinto, posActual, posFinal, valorActual, mejorTableroLaberinto, mejorValor);
					posActualEnTablero.setVisitado(false);
					valorActual = valorActual - posActualEnTablero.getPeso();
				}
			}
			
			
			posActual.setCoordenadas(posActual.getCoordenadaX() - 1, posActual.getCoordenadaY() + 1);
			if(tableroLaberinto.verificarLimites(posActual)) {
				posicion posActualEnTablero=tableroLaberinto.getPosicion(posActual.getCoordenadaX(), posActual.getCoordenadaY());
				if((!posActualEnTablero.getVisitado()) && (posActualEnTablero.noHayPared()==true)) {
					valorActual = valorActual + posActualEnTablero.getPeso();
					posActualEnTablero.setVisitado(true);
					resolverLaberinto(tableroLaberinto, posActual, posFinal, valorActual, mejorTableroLaberinto, mejorValor);
					posActualEnTablero.setVisitado(false);
					valorActual = valorActual - posActualEnTablero.getPeso();
				}
			}
			
			posActual.setCoordenadas(posActual.getCoordenadaX() - 1, posActual.getCoordenadaY() - 1);
			if(tableroLaberinto.verificarLimites(posActual)) {
				posicion posActualEnTablero=tableroLaberinto.getPosicion(posActual.getCoordenadaX(), posActual.getCoordenadaY());
				if((!posActualEnTablero.getVisitado()) && (posActualEnTablero.noHayPared()==true)) {
					valorActual = valorActual + posActualEnTablero.getPeso();
					posActualEnTablero.setVisitado(true);
					resolverLaberinto(tableroLaberinto, posActual, posFinal, valorActual, mejorTableroLaberinto, mejorValor);
					posActualEnTablero.setVisitado(false);
					valorActual = valorActual - posActualEnTablero.getPeso();
				}
			}
		}
	}
}