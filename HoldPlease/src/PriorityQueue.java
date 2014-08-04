import java.util.Iterator;

public class PriorityQueue<T> implements Queue<T> {

	PriorityItem firstItem;

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		T result = null;
		if (firstItem != null) {
			result = (T) firstItem.value;
			if (firstItem.getNextItem() != null) {
				firstItem = firstItem.getNextItem();
			}
		}
		return result;
	}

	@Override
	public boolean offer(T t) {
		boolean result = false;

		if (firstItem == null) {
			firstItem = new PriorityItem(t);
			result = true;
		} else {
			boolean searching = true;
			PriorityItem currentItem = firstItem;
			PriorityItem NewItem = new PriorityItem(t);
			if(NewItem.priority > firstItem.priority){
				NewItem.setNextItem(firstItem);
				firstItem = NewItem;
				result = true;
			} else {
				while (searching) {
					if (currentItem.getNextItem() == null) {
						currentItem.setNextItem(NewItem);
						searching = false;
					} else if(NewItem.priority > currentItem.getNextItem().priority){
						NewItem.setNextItem(currentItem.getNextItem());
						currentItem.setNextItem(NewItem);
					}
					currentItem = currentItem.getNextItem();
				}
				result = true;
			}
		}
		return result;
	}

	@Override
	public T peek() {
		T result = null;
		if(firstItem != null){
			result = (T) firstItem.value;
		}
		return result;
	}

}
