import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Calculadora extends Remote{
	
	public int soma (int x, int y) throws RemoteException;
	public int subtrair (int x, int y) throws RemoteException;
	public int multiplicar (int x, int y) throws RemoteException;
	public int dividir (int x, int y) throws RemoteException;
}
