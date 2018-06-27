public class Posicion {
	
	private int posX;
	private int posY;
	private char estado;
	private int peso;
	private boolean visitado;
	
	public Posicion() {
		this.estado='N';
		this.visitado=false;
	}
	
	/* Inicio de los Getters */	
	public int getCoordenadaX() {
		return this.posX;
	}
	
	public int getCoordenadaY() {
		return this.posY;
	}
	
	public char getEstado() {
		return estado;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public boolean getVisitado() {
		return visitado;
	}
	
	/* Inicio de los Setters */
	public void setCoordenadas(int x, int y) {
		this.posX=x;
		this.posY=y;
	}
	
	public void setEstado(char estadoNuevo) {
		this.estado=estadoNuevo;
	}
	
	public void setPeso(int pesoNuevo) {
		this.peso = pesoNuevo;
	}
	
	public void setVisitado(boolean nuevoVisitado) {
		this.visitado = nuevoVisitado;
	}		
}