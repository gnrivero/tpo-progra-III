
public class Backtracking {
	
	
	
	public void laberinto(Tablero[][] tablero,int fila,int columna, Posicion posActual, Posicion posFinal, int valorActual, Tablero[][] mejorTablero, int mejorValor ) {
		
		if (esFin(posActual,posFinal)){
			
			if (valorActual > mejorValor) {
				mejorValor = valorActual;
				mejorTablero = tablero;
			}	
		
		} 
		else {
			
			Posicion nuevaPosicion = posActual;
				
			
			int posX,posY;
			
			//x + 1
			nuevaPosicion.setX(posActual.x);
			nuevaPosicion.setY(posActual.y);
			
			posX = nuevaPosicion.getX();
			posY = nuevaPosicion.getY();
			
			if (verificarLimites(nuevaPosicion, fila, columna))
				if (tablero[posX][posY].getVisitado()==false && tablero[posX][posY].getTipo()=="A") {
					valorActual = valorActual + tablero[posX][posY].getValor();
					tablero[posX][posY].setVisitado(true);
					laberinto(tablero,fila,columna,nuevaPosicion,posFinal,valorActual,mejorTablero,mejorValor);
					tablero[posX][posY].setVisitado(false);
					valorActual = valorActual - tablero[posX][posY].getValor();
				}
			
			
			//x - 1
			nuevaPosicion.setX(posActual.x - 1);
			nuevaPosicion.setY(posActual.y);
			
			posX = nuevaPosicion.x;
			posY = nuevaPosicion.y;
			
			if (verificarLimites(nuevaPosicion, fila, columna)) 
				if (tablero[posX][posY].getVisitado()==false && tablero[posX][posY].getTipo()=="A") {
					valorActual = valorActual + tablero[posX][posY].getValor();
					tablero[posX][posY].setVisitado(true);
					laberinto(tablero,fila,columna,nuevaPosicion,posFinal,valorActual,mejorTablero,mejorValor);
					tablero[posX][posY].setVisitado(false);
					valorActual = valorActual - tablero[posX][posY].getValor();
				}
			
			//y + 1
		
			nuevaPosicion.setX(posActual.x);
			nuevaPosicion.setY(posActual.y + 1);
			
			posX = nuevaPosicion.x;
			posY = nuevaPosicion.y;
			
			if (verificarLimites(nuevaPosicion, fila, columna)) 
				if (tablero[posX][posY].getVisitado()==false && tablero[posX][posY].getTipo()=="A") {
					valorActual = valorActual + tablero[posX][posY].getValor();
					tablero[posX][posY].setVisitado(true);
					laberinto(tablero,fila,columna,nuevaPosicion,posFinal,valorActual,mejorTablero,mejorValor);
					tablero[posX][posY].setVisitado(false);
					valorActual = valorActual - tablero[posX][posY].getValor();
				}
			
			//y - 1
			
			nuevaPosicion.setX(posActual.x);
			nuevaPosicion.setY(posActual.y - 1);
			
			posX = nuevaPosicion.x;
			posY = nuevaPosicion.y;
			
			if (verificarLimites(nuevaPosicion, fila, columna))
				if (tablero[posX][posY].getVisitado()==false && tablero[posX][posY].getTipo()=="A") {
					valorActual = valorActual + tablero[posX][posY].getValor();
					tablero[posX][posY].setVisitado(true);
					laberinto(tablero,fila,columna,nuevaPosicion,posFinal,valorActual,mejorTablero,mejorValor);
					tablero[posX][posY].setVisitado(false);
					valorActual = valorActual - tablero[posX][posY].getValor();
				}
		}
	
	}
	
	public boolean verificarLimites(Posicion nuevaPosicion, int fila, int columna) {
		return true;
	}
	
	public boolean esFin(Posicion posActual, Posicion posFinal) {
		return true;
	}
	

	
}