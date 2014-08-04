/**
 * A contract for data structures that are implemented as lists.
 * 
 * @author jcummings
 *
 * @param <T>
 */
public interface List<T> extends Iterable<T> {
	/**
	 * Add an item to the list
	 * 
	 * Returns true if the list changed as a result of this call
	 * 
	 * @param t
	 * @return
	 */
	boolean add(T t);
	
	/**
	 * Get an item from the list by its index
	 * 
	 * @param index
	 * @return
	 */
	T get(int index);
	
	/**
	 * Remove an item from the list
	 * 
	 * Returns true if the list changed as a result of this call
	 * 
	 * @param t
	 * @return
	 */
	boolean remove(T t);
	
	/**
	 * Returns the size of the list
	 */
	int size();
}
