import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class CalculadoraServidor extends UnicastRemoteObject implements Calculadora{
	
	protected CalculadoraServidor() throws RemoteException{
		super();
	}
	
	@Override
	public int soma(int x, int y) throws RemoteException {
		return x + y;
	}

	@Override
	public int subtrair(int x, int y) throws RemoteException {
		return x - y;
	}

	@Override
	public int multiplicar(int x, int y) throws RemoteException {
		return x * y;
	}

	@Override
	public int dividir(int x, int y) throws RemoteException {
		return x / y;
	}
}
