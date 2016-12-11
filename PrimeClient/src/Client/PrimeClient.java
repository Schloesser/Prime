package Client;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import Prime.PrimeObject;
import RemoteObjects.Prime;

/**
 * The prime client offers methods which make a request to a server
 */
public class PrimeClient {
    // the stub is nothing but a proxy for the remote object
    private static Prime stub;


    public static List<Integer> getPrimeInteger(int max) throws NotBoundException, IOException {
        if(stub == null) {
            init();
        }
        List<Integer> primes = stub.getPrimeInt(max);
        return primes;
    }

    public static String getPrimeString(int max) throws NotBoundException, IOException {
        if(stub == null) {
            init();
        }
        String primes = stub.getPrimeString(max);
        return primes;
    }

    public static  List<PrimeObject> getPrimeObjects(int max) throws NotBoundException, IOException {
        if(stub == null) {
            init();
        }
        List<PrimeObject> primes = stub.getPrimeObjects(max);
        return primes;
    }

    public static void init() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost");
        stub = (Prime) registry.lookup("Prime");
    }


}
