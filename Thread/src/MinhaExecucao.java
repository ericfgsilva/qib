
public class MinhaExecucao implements Runnable {
	private String nome;

	public MinhaExecucao(String nome){
		this.nome = nome;
	}


	public void run(){
		long random = 0;
		for(int i = 0; i < 50; i++){
			random =(long) (Math.random() * 100);
			System.out.println("Numero gerado por " 
					+ this.nome + " " + random);
		}
	}

	public static void main(String[] args){
		Thread thread = new Thread(new MeuThread(("thread1"))) ;
		Thread thread2 = new Thread(new MeuThread(("thread2"))) ;
		Thread thread3 = new Thread(new MeuThread(("thread3"))) ;

		thread.start();	
		thread2.start();	
		thread3.start();
	}
}
