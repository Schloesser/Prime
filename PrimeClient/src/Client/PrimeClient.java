package Client;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;

import RemoteObjects.Prime;


public class PrimeClient {

    private static Prime stub;
    public static List<Integer> getPrimeInteger(int max) throws NotBoundException, IOException {

        // intitalisieren des Remote-Objektes/Stubs mit der Implementation des Servers.
         stub = (Prime) Naming.lookup("Prime");

        List<Integer> primes = stub.getPrimeInt(max);

        return primes;
    }

    public static String getPrimeString(int max) throws NotBoundException, IOException {

        // intitalisieren des Remote-Objektes/Stubs mit der Implementation des Servers.
         stub = (Prime) Naming.lookup("Prime");

        String primes = stub.getPrimeString(max);

        return primes;
    }


}
