package RemoteObjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Prime.PrimeNumber;

public class PrimeImpl extends UnicastRemoteObject implements Prime
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -658020054368051290L;
	public PrimeImpl() throws RemoteException
	{
		super();
	}



	@Override
	public List<Integer> getPrimeInt(int max) throws RemoteException {
		PrimeNumber prime = new PrimeNumber();
		return prime.getPrimeInterger(max);
	}
	
	@Override
	public String getPrimeString(int max) throws RemoteException {
		PrimeNumber prime = new PrimeNumber();
		return prime.getPrimeString(max);
	}



}
