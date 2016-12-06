package RemoteObjects;
import Prime.PrimeObject;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * This remote Object provides the methods which can be used by the clients. It is very important
 * that this class exists on each client. Be sure it is EXACTLY the same and
 especially the package name has to be the same too. Except comments.
 */
public interface Prime extends Remote
{
	public List<Integer> getPrimeInt(int max) throws RemoteException;
	public String getPrimeString(int max) throws RemoteException;
	public List<PrimeObject> getPrimeObjects(int max) throws RemoteException;

}
