public class Tablero {
		
	public Posicion[][] tablerito;
	public int fila, columna;
	public int valor;

	public Tablero(int fila, int columna) {
		this.tablerito = new Posicion[fila][columna];
		this.fila = fila;
		this.columna = columna;
		this.valor = 0;
	}
	
	public void reemplazarTablero(Tablero tableroNuevo) {
		for(int i=0; i<fila; i++) {
			for(int j=0; j<columna; j++) {
				Posicion nuevaPosicion = tableroNuevo.getPosicion(i, j);
				
				setPosicion(i, j, nuevaPosicion.getEstado(), nuevaPosicion.getPeso(), nuevaPosicion.getVisitado());
			}
		}
	}
	
	public boolean esFin(Posicion posActual, Posicion posFinal) {
		return ((posActual.getCoordenadaX() == posFinal.getCoordenadaX()) && (posActual.getCoordenadaY() == posFinal.getCoordenadaY()));
	}
	
	public boolean verificarLimites(Posicion nuevaPosicion) {
		boolean limiteMax = (nuevaPosicion.getCoordenadaX() < this.fila) && (nuevaPosicion.getCoordenadaY() < this.columna);
		boolean limiteMin = (nuevaPosicion.getCoordenadaX() > -1) && (nuevaPosicion.getCoordenadaY() > -1);
		return (limiteMax && limiteMin);
	}
	
	/* Inicio de los Getters */
	public Posicion getPosicion(int x, int y) {
		return this.tablerito[x][y];
	}
	
	public Posicion[][] getTablero() {
		return this.tablerito;
	}
	
	/* Inicio de los Setters */
	public void setPosicion(int x, int y, char nuevoEstado, int nuevoPeso, boolean nuevoVisitado) {
		tablerito[x][y]=new Posicion();
		tablerito[x][y].setCoordenadas(x, y);
		tablerito[x][y].setEstado(nuevoEstado);
		tablerito[x][y].setPeso(nuevoPeso);
		tablerito[x][y].setVisitado(nuevoVisitado);
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
}