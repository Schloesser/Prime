package PrimeServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RemoteObjects.PrimeImpl;

public class PrimeServer {

	/**
	 * The primeserver provides a Remote Object to the registry which can be found by the name "Prime"
	 * @param argv
	 */
	public static void main(String[] argv) {
		try {

			LocateRegistry.createRegistry(Registry.REGISTRY_PORT); 
																	
			Registry registry = LocateRegistry.getRegistry();

			PrimeImpl server = new PrimeImpl();

			registry.rebind("Prime", server);

			System.out.println("[System] Chat Remote Object is ready:");

		} catch (Exception e) {
			System.out.println("[System] Server failed: " + e);
		}
	}
}
