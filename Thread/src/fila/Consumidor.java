package fila;

public class Consumidor implements Runnable{

	private Fila fila;

	public Consumidor(Fila fila){
		this.fila = fila;
	}

	@Override
	public void run() {
		while(true){
			fila.obter();
		}
	}
}
