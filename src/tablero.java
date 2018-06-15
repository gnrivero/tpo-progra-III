public class tablero {
	private posicion[][] tablerito;

	public tablero(int fila, int columna) {
		this.tablerito = new posicion[fila][columna];
	}
	
	public void reemplazarTablero(tablero tableroNuevo) {
		char nuevoEstado='N';
		int nuevoPeso=0;
		boolean nuevoVisitado=false;
		for(int i=0; i<tablerito.length; i++) {
			for(int j=0; j<tablerito[i].length; j++) {
				nuevoEstado=tableroNuevo.getPosicion(i,j).getEstado();
				nuevoPeso=tableroNuevo.getPosicion(i,j).getPeso();
				nuevoVisitado=tableroNuevo.getPosicion(i,j).getVisitado();
				setPosicion(i, j, nuevoEstado, nuevoPeso, nuevoVisitado);
			}
		}
	}
	
	public boolean esFin(posicion posActual, posicion posFin) {
		return ((posActual.getCoordenadaX() == posFin.getCoordenadaX()) && (posActual.getCoordenadaY() == posFin.getCoordenadaY()));
	}
	
	public boolean verificarLimites(posicion nuevaPosicion) {
		return ((nuevaPosicion.getCoordenadaX() < tablerito.length) && (nuevaPosicion.getCoordenadaY() < tablerito[0].length));
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
		tablerito[x][y].setEstado(nuevoEstado);
		tablerito[x][y].setPeso(nuevoPeso);
		tablerito[x][y].setVisitado(nuevoVisitado);
	}
}