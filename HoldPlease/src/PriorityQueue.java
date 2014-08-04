import java.util.Iterator;

public class PriorityQueue<T> implements Queue<T> {

	PriorityItem<T> firstItem;
	int length = 0;
	
	public int length(){
		return length;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {
			public PriorityItem<T> currentItem = firstItem;
			public PriorityItem<T> lastItem = null;

			@Override
			public boolean hasNext() {
				return currentItem.getNextItem() != null;
			}

			@Override
			public T next() {
				lastItem = currentItem;
				currentItem = currentItem.getNextItem();
				return currentItem.value;
			}

			@Override
			public void remove() {
				if (lastItem != null) {
					lastItem.setNextItem(currentItem.getNextItem());
				}
			}
		};
		return iterator;
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
		length--;
		return result;
	}

	@Override
	public boolean offer(T t) {
		boolean result = false;

		if (firstItem == null) {
			firstItem = new PriorityItem(t);
			length++;
			result = true;
		} else {
			boolean searching = true;
			PriorityItem currentItem = firstItem;
			PriorityItem NewItem = new PriorityItem(t);
			if(NewItem.priority > firstItem.priority){
				NewItem.setNextItem(firstItem);
				firstItem = NewItem;
				length++;
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
				length++;
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
