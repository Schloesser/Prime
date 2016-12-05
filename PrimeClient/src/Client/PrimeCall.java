package Client;

import java.io.IOException;
import java.rmi.NotBoundException;

public interface PrimeCall {
	String getPrime(int max) throws NotBoundException, IOException;
}
