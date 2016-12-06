package Client;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;

import RemoteObjects.Prime;

/**
 * The prime client offers methods which make a request to a server
 */
public class PrimeClient {
    // the stub is nothing but a proxy for the remote object
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

    public static  List<PrimeObject> getPrimeObjects(int max) throws NotBoundException, IOException {

        // intitalisieren des Remote-Objektes/Stubs mit der Implementation des Servers.
        stub = (Prime) Naming.lookup("Prime");

        List<PrimeObject> primes = stub.getPrimeObjects(max);

        return primes;
    }


}
