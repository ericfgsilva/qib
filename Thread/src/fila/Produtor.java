package fila;

public class Produtor extends Thread{
	private Fila fila;

	public Produtor (Fila fila){
		this.fila = fila;
	}

	public void run(){
		while(true){
			fila.adicionar("Objeto");
		}
	}
}