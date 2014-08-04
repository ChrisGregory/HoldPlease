import java.util.Iterator;

/** 
 * An interface for data structures that are implemented as queues
 * 
 * @author jcummings
 *
 * @param <T>
 */
public interface Queue<T> extends Iterable<T> {
	/**
	 * Returns an iterator to walk through the data structure element-by-element.
	 * @return
	 */
	Iterator<T> iterator();
	
	/**
	 * Removes and returns the head of the queue.  Returns null if the queue is empty.
	 * 
	 * @return
	 */
	T poll();
	
	/**
	 * Adds to the tail of the queue.  Returns true if the data structure was changed as a result of this call.
	 * 
	 * @param t
	 * @return
	 */
	boolean offer(T t);
	
	/**
	 * Look at the head of the queue without removing it.  Returns null if the queue is empty.
	 * 
	 * @return
	 */
	T peek();
}
