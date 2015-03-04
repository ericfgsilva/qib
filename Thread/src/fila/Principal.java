package fila;

public class Principal {

	public static void main(String[] args) {

		Fila fila = new Fila();
		Produtor produtor = new Produtor(fila);
		Consumidor consumidor = new Consumidor(fila);
		produtor.start();
		Thread t = new Thread(consumidor);
		t.start();
	}
}