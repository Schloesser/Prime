package Client;

import java.io.IOException;
import java.rmi.NotBoundException;

public class PrimeCallString implements PrimeCall {

	@Override
	public String getPrime(int max) throws NotBoundException, IOException {
		return PrimeClient.getPrimeString(max);
	}

}
