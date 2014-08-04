/**
 * Represents an entity capable of rendering a service, e.g. a teller at a bank, a clerk at a grocery store, a doctor at a hospital
 * 
 * @author jcummings
 *
 */
public class Server {
	/**
	 * The customer that this server is currently serving.
	 */
	private Client currentlyServing;
	
	/**
	 * Returns whether or not this server is currently serving a client
	 * @return
	 */
	public boolean hasCustomer() {
		return currentlyServing != null;
	}
	
	/**
	 * Returns the client that the server is currently serving
	 * @return
	 */
	public Client getCurrentlyServing() {
		return currentlyServing;
	}
	
	
	/**
	 * Gives the server a client
	 * 
	 * @param currentlyServing
	 */
	public void setCurrentlyServing(Client currentlyServing) {
		this.currentlyServing = currentlyServing;
	}
	
	/**
	 * Serve client for one minute
	 */
	public void serveMinute() {
		if ( currentlyServing != null && currentlyServing.servedMinute() <= 0 ) {
			currentlyServing = null;
		}
	}
}
