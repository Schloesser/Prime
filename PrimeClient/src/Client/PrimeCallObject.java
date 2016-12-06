package Client;

import Prime.PrimeObject;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.List;


public class PrimeCallObject implements PrimeCall{

    /**
     *  The data come from the server, so a NotBoundException will be thrown
     *  if the server can't handle the request.
     */
    @Override
    public String getPrime(int max) throws NotBoundException, IOException {
        List<PrimeObject> primes = PrimeClient.getPrimeObjects(max);
        String out = "";
        for (PrimeObject prime : primes)
        {
            out = out + prime.toString() + '\n';
        }
       return out;
    }
}
