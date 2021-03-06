package PrimeServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RemoteObjects.*;

public class PrimeServer {

	/**
	 * The primeserver provides a Remote Object to the registry which can be found by the name "Prime"
	 * @param argv
	 */
	public static void main(String[] argv) {
		try {

			LocateRegistry.createRegistry(Registry.REGISTRY_PORT); 
																	
			Registry registry = LocateRegistry.getRegistry();

			Prime serverRMO = new PrimeImpl();

			registry.rebind("Prime", serverRMO);

			System.out.println("[System] Remote Object is ready:");

		} catch (Exception e) {
			System.out.println("[System] Server failed: " + e);
		}
	}
}
