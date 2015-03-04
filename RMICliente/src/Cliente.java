import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Cliente {
	public static void main(String[] args) {
		Calculadora calculadora;
		try {
			calculadora = (Calculadora) Naming.lookup("//127.0.0.1/calc");
			System.out.println("Somando 2 + 2 " + calculadora.soma(2,2));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
