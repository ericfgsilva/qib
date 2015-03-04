import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class SubirServidor {

	public static void main(String[] args) {
		
		CalculadoraServidor servidor;
		try {
			servidor = new CalculadoraServidor();
			
			LocateRegistry.createRegistry(1099);
			
			Naming.rebind("//localhost/calc", servidor);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Calculadora registrada no RMI");		

	}

}
