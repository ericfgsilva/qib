package fila;

import java.util.LinkedList;

public class Fila {
	private LinkedList lista = new LinkedList();

	public synchronized void adicionar(Object item){
		try{
			//while (!lista.isEmpty()){
			while(lista.size() >= 10){
				System.out.println("Esperando esvaziar lista");
				wait();
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

		lista.addLast(item);
		System.out.println("Produzir !!");
		notifyAll();
	}

	public synchronized Object obter(){
		Object retorno = null;
		try{
			while(lista.isEmpty()){
				System.out.println("Esperando adicionar Elemento !!");
				wait(); // Esperar por um elemento
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}	

		System.out.println("Removidor");
		retorno = lista.removeFirst();
		notifyAll();
		return retorno;
	}
}