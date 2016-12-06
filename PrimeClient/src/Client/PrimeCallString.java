package Client;

import java.io.IOException;
import java.rmi.NotBoundException;

public class PrimeCallString implements PrimeCall {

	/**
	 *  The data come from the server, so a NotBoundException will be thrown
	 *  if the server can't handle the request.
	 */
	@Override
	public String getPrime(int max) throws NotBoundException, IOException {
		return PrimeClient.getPrimeString(max);
	}

}
