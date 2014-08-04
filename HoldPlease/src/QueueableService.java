/**
 * A service that can have multiple clients waiting in a pool.
 * 
 * @author jcummings
 *
 */
public interface QueueableService {
	/**
	 * Returns the average wait time for the current set of clients
	 * @return
	 */
	public double getAverageClientWaitTime();
	
	/**
	 * Returns the wait time for the following client
	 * 
	 * @param client
	 * @return
	 */
	public double getClientWaitTime(Client client);
	
	/**
	 * Adds a client to the service waiting pool
	 * 
	 * @param client
	 */
	public boolean addClient(Client client);
	
	/**
	 * Perform service for one minute:  If any server is empty, a client is moved from the waiting pool.
	 * Afterwards, all servers serve for one minute.
	 */
	public void advanceMinute();
}
