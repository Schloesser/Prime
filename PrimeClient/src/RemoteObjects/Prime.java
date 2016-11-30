package RemoteObjects;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Prime extends Remote
{
	public List<Integer> getPrimeInt(int max) throws RemoteException;
	public String getPrimeString(int max) throws RemoteException;

}
