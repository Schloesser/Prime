package Client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.List;

public class PrimeCallInteger implements PrimeCall {

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
