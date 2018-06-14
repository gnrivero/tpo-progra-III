
public class Tablero {
	
	public Tablero(int x, int y){
		this.x = x;
		this.y = y;
		this.visitado=false;
		this.setTipo("A");
		this.valor=0;
	}
	
	private int x;
    private int y;
    private int valor;
    private Tablero[][] tablero;
	private boolean visitado;
    private String tipo;
	
	public void inicializarTablero(int x,int y) {
		for(int i=0 ; i<y ; i++){
            for(int j=0 ; j<x ; j++){
                    this.tablero[i][j].visitado = false;
                    this.tablero[i][j].valor = 0;
            }
            
    }
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setValor(int valorNuevo) {
		this.valor = valorNuevo;
	}
	
	public boolean getVisitado() {
		return this.visitado;
	}
	
	public void setVisitado(boolean bandera) {
		this.visitado = bandera;
	}
	
	// Hay que modificarlo
	public void crearTablero(int x,int y, String[] datos) {
		for(int i=0 ; i<y ; i++){
            for(int j=0 ; j<x ; j++){
                    this.tablero[i][j].visitado = false;
                    this.tablero[i][j].tipo = "A";
                    this.tablero[i][j].valor = 0;
            }
            
    }
	}
	
    public int getX() { 
            return x; 
    } 

    public void setX(int x) { 
            this.x = x; 
    } 

    public Tablero[][] getTablero() { 
            return tablero; 
    } 

    public void setTablero(Tablero[][] tablero) { 
            this.tablero = tablero; 
    } 

    public int getY() { 
            return y; 
    } 

    public void setY(int y) { 
            this.y = y; 
    }
	
    public void mostrarTablero(){
        
        for(int i=0 ; i<y ; i++)
                for(int j=0 ; j<x ; j++)
                        System.out.println(tablero[i][j].visitado+"  ");
   
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
