package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Prime.PrimeNumber;

/**
 * 	This class implements the remote object.
 */
public class PrimeImpl extends UnicastRemoteObject implements Prime
{

	private static final long serialVersionUID = -658020054368051290L;
	public PrimeImpl() throws RemoteException
	{
		super();
	}


	/**
	 *
	 * This method will be called by the clients even they don't implement it by their own.
	 * @param max
	 * @return A list of integeger which contains primes by a given limit
	 * @throws RemoteException
	 */
	@Override
	public List<Integer> getPrimeInt(int max) throws RemoteException{
		PrimeNumber prime = new PrimeNumber();
		return prime.getPrimeInterger(max);
		
	}

	/**
	 *
	 * This method will be called by the clients even they don't implement it by their own.
	 * @param max
	 * @return A String which contains primes by a given limit
	 * @throws RemoteException
	 */
	@Override
	public String getPrimeString(int max) throws RemoteException{
		PrimeNumber prime = new PrimeNumber();
		return prime.getPrimeString(max);

	}



}
