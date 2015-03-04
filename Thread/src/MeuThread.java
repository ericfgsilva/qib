
public class MeuThread extends Thread{
	private String nome;

	public MeuThread(String nome){
		this.nome = nome;
	}


	public void run(){
		double random = 0;
		for(int i = 0; i < 50; i++){
			random = Math.random() * 100;
			System.out.println("Numero gerado por " 
					+ this.nome + " " + random);
		}
	}
	
	public static void main(String[] args){
		MeuThread thread = new MeuThread("thread1");
		MeuThread thread2 = new MeuThread("thread2");
		MeuThread thread3 = new MeuThread("thread3");
		
		thread.start();	
		thread2.start();	
		thread3.start();
	}
}