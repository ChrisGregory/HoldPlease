/**
 * A client that can be ranked by attrition time
 * 
 * @author jcummings
 *
 */
public class PriorityClient extends Client implements Comparable<PriorityClient> {
	/**
	 * how long in minutes this client can wait
	 */
	private int expectedAttritionTime;

	
	public PriorityClient(int expectedServiceTime, int expectedAttritionTime) {
		super(expectedServiceTime);
		this.expectedAttritionTime = expectedAttritionTime;
	}
	
	/**
	 * Returns the amount of time that this client can continue to wait
	 * @return
	 */
	public int getExpectedAttritionTime() {
		return expectedAttritionTime;
	}

	/**
	 * Wait in line for one minute.  Returns the amount of time this client can continue to wait
	 * @return
	 */
	public int waitMinute() {
		expectedAttritionTime--;
		return expectedAttritionTime;
	}

	@Override
	public int compareTo(PriorityClient arg0) {
		return new Integer(expectedAttritionTime).compareTo(arg0.expectedAttritionTime);
	}
}
