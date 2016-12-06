package Client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.List;

public class PrimeCallInteger implements PrimeCall {

	/**
	 *  The data come from the server, so a NotBoundException will be thrown
	 *  if the server can't handle the request.
	 */
	@Override
	public String getPrime(int max) throws NotBoundException, IOException {
		List<Integer> primes = PrimeClient.getPrimeInteger(max);
		String out = "";
		for (Integer prime : primes) {
			out = out + String.valueOf(prime) + "\n";
		}
		return out;
	}

}
