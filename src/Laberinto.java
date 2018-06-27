import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Laberinto {
	
	private Tablero tableroLaberinto;
	private Tablero mejorTableroLaberinto;
	private int numFilas;
	private int numColumnas;
	
	public int getNumFilas() {
		return numFilas;
	}
	
	public void setNumFilas(int numFilas) {
		this.numFilas = numFilas;
	}
	
	public int getNumColumnas() {
		return numColumnas;
	}
	
	public void setNumColumnas(int numColumnas) {
		this.numColumnas = numColumnas;
	}

	public Laberinto(String archivoTXT) {
		String str = convertirArchivoAString(archivoTXT);

		// Obtengo la cantidad de filas del laberinto
		String procesar = str.substring(0, str.indexOf(','));
		numFilas = Integer.parseInt(procesar);
		str = str.substring(procesar.length() + 1);

		// Obtengo la cantidad de columnas del laberinto y elimino los datos que acabo
		// de usar del string
		procesar = str.substring(0, str.indexOf('-'));
		numColumnas = Integer.parseInt(procesar);
		str = str.substring(procesar.length() + 2);
		
		tableroLaberinto = new Tablero(numFilas, numColumnas);
		mejorTableroLaberinto = new Tablero(numFilas, numColumnas);

		// Reemplazo los parentesis por comas
		str = str.replaceAll("\\(", "");
		str = str.replaceAll("\\)", ",");

		// pregunto si numFilas corresponde con el archivo
		if (archivoTxtOk(archivoTXT)) {
			// Cargo sus datos por fila y por columna. Al terminar de cargar una fila,
			// elimino el espacio.
			for (int i = 0; i < numFilas; i++) {
				for (int j = 0; j < numColumnas; j++) {
					// Obtengo la letra que correspondiente a la posicion
					procesar = str.substring(0, str.indexOf(','));
					char nuevoEstado = (char) procesar.charAt(0);
					str = str.substring(procesar.length() + 1);

					// Obtengo el peso que correspondiente a la posicion
					procesar = str.substring(0, str.indexOf(','));
					int nuevoPeso;
					
					if (procesar.equals("X")) {
						nuevoPeso = 0;
					} else {
						nuevoPeso = (int) Integer.parseInt(procesar);
					}
					
					str = str.substring(procesar.length() + 1);

					this.tableroLaberinto.setPosicion(i, j, nuevoEstado, nuevoPeso, false);
				}
			}
		}
	}		

	// Retorna TRUE cuando en el archivo hay tantas filas y columnas como coordenadas
	private boolean archivoTxtOk(String archivoTXT) {
		int counter = 0;
		String str = convertirArchivoAString(archivoTXT);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				counter++;
			}
		}
		if (counter == (this.numFilas * this.numColumnas)) {
			return true;
		} else {
			return false;
		}
	}

	// Convierte el contenido del archivoTXT a String
	private static String convertirArchivoAString(String archivoTXT) {
		String str = "";
		try {
			str = new String(Files.readAllBytes(Paths.get(archivoTXT)));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return str;
	}

	// Imprime por pantalla V cuando la celda del laberinto fue visitada y F cuando no
	public void mostrarLaberinto() {
		
		System.out.println("  ");
		System.out.println("Matriz mejor Solucion: ");
		System.out.println("  ");
		
		try {
			for (int i = 0; i < mejorTableroLaberinto.fila ; i++) {
				for (int j = 0; j < mejorTableroLaberinto.columna; j++) {
					
					
									
					if (mejorTableroLaberinto.getPosicion(i, j).getVisitado()) {
						System.out.print("V");
					} else {
						System.out.print("F");
					}
					if (j < numColumnas - 1) {
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
			
			System.out.println("");
			System.out.println("Mejor Valor: " + mejorTableroLaberinto.getValor());
			
		} catch (Exception e) {
			System.out.println("Segun las posiciones ingresadas, no se pudo encontrar un camino entre los pares.");
			System.out.println("");
			System.out.println("Mejor Valor: " + mejorTableroLaberinto.getValor());
			
		} 
	}

	// Devuelve el recorrido de menor peso que existe entre la posicion origen y la
	// destino
	public Tablero getMejorLaberinto(Posicion posActual, Posicion posFinal) {
		int valorPrimerCasillero = tableroLaberinto.tablerito[posActual.getCoordenadaX()][posActual.getCoordenadaY()].getPeso();
		tableroLaberinto.setValor(valorPrimerCasillero);
		resolverLaberinto(this.tableroLaberinto, posActual, posFinal, this.mejorTableroLaberinto);
		return mejorTableroLaberinto;
	}

	private void resolverLaberinto(Tablero tableroLaberinto, Posicion posActual, Posicion posFinal, Tablero mejorTableroLaberinto) { 
		
		tableroLaberinto.tablerito[posActual.getCoordenadaX()][posActual.getCoordenadaY()].setVisitado(true);
		
		if (tableroLaberinto.esFin(posActual, posFinal)) {
			int mejorValor = mejorTableroLaberinto.getValor();
			int valorActual = tableroLaberinto.getValor();
			System.out.println("IF");
			System.out.println("mejor valor "+mejorValor);
			System.out.println("valorActual "+valorActual);
			if (valorActual > mejorValor) {
				mejorTableroLaberinto.setValor(valorActual);
				
				mejorTableroLaberinto.reemplazarTablero(tableroLaberinto);
			}
			
		} else {

			// X + 1
			Posicion nuevaPosicion = new Posicion();
			nuevaPosicion.setCoordenadas(posActual.getCoordenadaX() + 1, posActual.getCoordenadaY());
			
			if (tableroLaberinto.verificarLimites(nuevaPosicion)) {				
				nuevaPosicion = tableroLaberinto.getPosicion(posActual.getCoordenadaX() + 1, posActual.getCoordenadaY());						
				int posX = nuevaPosicion.getCoordenadaX();
				int posY = nuevaPosicion.getCoordenadaY();
				if ((!nuevaPosicion.getVisitado()) && (nuevaPosicion.getEstado() == 'A')) {
					int valorActual = tableroLaberinto.getValor() + nuevaPosicion.getPeso();
					tableroLaberinto.setValor(valorActual);
					tableroLaberinto.getPosicion(posX,posY).setVisitado(true);
					resolverLaberinto(tableroLaberinto, nuevaPosicion, posFinal, mejorTableroLaberinto);
					tableroLaberinto.getPosicion(posX,posY).setVisitado(false);
					valorActual = tableroLaberinto.getValor() - nuevaPosicion.getPeso();
					tableroLaberinto.setValor(valorActual);
				}
			}

			// X - 1
			nuevaPosicion = new Posicion();
			nuevaPosicion.setCoordenadas(posActual.getCoordenadaX() - 1, posActual.getCoordenadaY());

			if (tableroLaberinto.verificarLimites(nuevaPosicion)) {
				nuevaPosicion =  tableroLaberinto.getPosicion(posActual.getCoordenadaX() - 1, posActual.getCoordenadaY());
				int posX = nuevaPosicion.getCoordenadaX();
				int posY = nuevaPosicion.getCoordenadaY();
				if ((!nuevaPosicion.getVisitado()) && (nuevaPosicion.getEstado() == 'A')) {
					int valorActual = tableroLaberinto.getValor() + nuevaPosicion.getPeso();
					tableroLaberinto.setValor(valorActual);
					tableroLaberinto.getPosicion(posX,posY).setVisitado(true);
					resolverLaberinto(tableroLaberinto, nuevaPosicion, posFinal, mejorTableroLaberinto);
					tableroLaberinto.getPosicion(posX,posY).setVisitado(false);
					valorActual = tableroLaberinto.getValor() - nuevaPosicion.getPeso();
					tableroLaberinto.setValor(valorActual);
				}
			}

			// Y + 1
			nuevaPosicion = new Posicion();
			nuevaPosicion.setCoordenadas(posActual.getCoordenadaX(), posActual.getCoordenadaY() + 1);

			if (tableroLaberinto.verificarLimites(nuevaPosicion)) {
				nuevaPosicion =  tableroLaberinto.getPosicion(posActual.getCoordenadaX(),posActual.getCoordenadaY() + 1);
				int posX = nuevaPosicion.getCoordenadaX();
				int posY = nuevaPosicion.getCoordenadaY();
				if ((!nuevaPosicion.getVisitado()) && (nuevaPosicion.getEstado() == 'A')) {
					int valorActual = tableroLaberinto.getValor() + nuevaPosicion.getPeso();
					tableroLaberinto.setValor(valorActual);
					tableroLaberinto.getPosicion(posX,posY).setVisitado(true);
					resolverLaberinto(tableroLaberinto, nuevaPosicion, posFinal, mejorTableroLaberinto);
					tableroLaberinto.getPosicion(posX,posY).setVisitado(false);
					valorActual = tableroLaberinto.getValor() - nuevaPosicion.getPeso();
					tableroLaberinto.setValor(valorActual);
				}
			}

			// Y - 1
			nuevaPosicion = new Posicion();
			nuevaPosicion.setCoordenadas(posActual.getCoordenadaX(), posActual.getCoordenadaY() - 1);

			if (tableroLaberinto.verificarLimites(nuevaPosicion)) {
				nuevaPosicion =  tableroLaberinto.getPosicion(posActual.getCoordenadaX(),posActual.getCoordenadaY() - 1);
				int posX = nuevaPosicion.getCoordenadaX();
				int posY = nuevaPosicion.getCoordenadaY();
				if ((!nuevaPosicion.getVisitado()) && (nuevaPosicion.getEstado() == 'A')) {
					int valorActual = tableroLaberinto.getValor() + nuevaPosicion.getPeso();
					tableroLaberinto.setValor(valorActual);
					tableroLaberinto.getPosicion(posX,posY).setVisitado(true);
					resolverLaberinto(tableroLaberinto, nuevaPosicion, posFinal, mejorTableroLaberinto);
					tableroLaberinto.getPosicion(posX,posY).setVisitado(false);
					valorActual = tableroLaberinto.getValor() - nuevaPosicion.getPeso();
					tableroLaberinto.setValor(valorActual);
				}
			}
		} 
	}
	
}