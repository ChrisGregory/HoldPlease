/**
 * Represents a user of the provided service.  e.g. a customer at the bank, a patient at the hospital, a shopper at the grocery store
 * 
 * @author jcummings
 *
 */
public class Client {
	/**
	 * An identifier unique to each Client
	 */
	private String id;
	
	/**
	 * how long in minutes this client's service request will take to fulfill
	 */
	private int expectedServiceTime;
	
	public Client(int expectedServiceTime) {
		this.id = java.util.UUID.randomUUID().toString();
		this.expectedServiceTime = expectedServiceTime;
	}
	
	/**
	 * Returns the amount of service time remaining.
	 * 
	 * @return
	 */
	public int getExpectedServiceTime() {
		return expectedServiceTime;
	}
	
	/**
	 * Serve the customer for one minute.  Returns the amount of service time remaining.
	 * 
	 * @return
	 */
	public int servedMinute() {
		expectedServiceTime--;
		return expectedServiceTime;
	}
	
	public boolean equals(Object obj) {
		if ( obj instanceof Client ) {
			return ((Client)obj).id.equals(id);
		}
		return false;
	}
}
