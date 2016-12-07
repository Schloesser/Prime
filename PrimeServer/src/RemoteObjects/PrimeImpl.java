package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import Prime.PrimeObject;

import Prime.PrimeNumber;

public class PrimeImpl extends UnicastRemoteObject implements Prime
{

	private PrimeNumber prime;


	/**
	 * 
	 */
	private static final long serialVersionUID = -658020054368051290L;
	public PrimeImpl() throws RemoteException
	{
		super();
		prime = new PrimeNumber();
	}



	@Override
	public List<Integer> getPrimeInt(int max) throws RemoteException {

		return prime.getPrimeInterger(max);
	}
	
	@Override
	public String getPrimeString(int max) throws RemoteException {

		return prime.getPrimeString(max);
	}

	@Override
	public List<PrimeObject> getPrimeObjects(int max) throws RemoteException {

		return prime.getPrimeObjects(max);
	}



}
