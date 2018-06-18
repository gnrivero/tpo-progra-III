public class tablero {
	public posicion[][] tablerito;
	public int fila,columna;

	public tablero(int fila, int columna) {
		this.tablerito = new posicion[fila][columna];
		this.fila = fila;
		this.columna = columna;
	}
	
	public void reemplazarTablero(tablero tableroNuevo) {
		for(int i=0; i<fila; i++) {
			for(int j=0; j<columna; j++) {
				posicion nuevaPosicion = tableroNuevo.getPosicion(i, j);
				
				setPosicion(i, j, nuevaPosicion.getEstado(), nuevaPosicion.getPeso(), nuevaPosicion.getVisitado());
			}
		}
	}
	
	public boolean esFin(posicion posActual, posicion posFinal) {
		return ((posActual.getCoordenadaX() == posFinal.getCoordenadaX()) && (posActual.getCoordenadaY() == posFinal.getCoordenadaY()));
	}
	
	public boolean verificarLimites(posicion nuevaPosicion) {
		boolean limiteMax = (nuevaPosicion.getCoordenadaX() < this.fila) && (nuevaPosicion.getCoordenadaY() < this.columna);
		boolean limiteMin = (nuevaPosicion.getCoordenadaX() > -1) && (nuevaPosicion.getCoordenadaY() > -1);
		return (limiteMax && limiteMin);
	}
	
	/* Inicio de los Getters */
	public posicion getPosicion(int x, int y) {
		return this.tablerito[x][y];
	}
	
	public posicion[][] getTablero() {
		return this.tablerito;
	}
	
	/* Inicio de los Setters */
	public void setPosicion(int x, int y, char nuevoEstado, int nuevoPeso, boolean nuevoVisitado) {
		tablerito[x][y]=new posicion();
		tablerito[x][y].setCoordenadas(x, y);
		tablerito[x][y].setEstado(nuevoEstado);
		tablerito[x][y].setPeso(nuevoPeso);
		tablerito[x][y].setVisitado(nuevoVisitado);
	}
}