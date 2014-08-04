import java.util.Iterator;

public class LinkedList<T> implements Queue<T> {

	LinkedItem firstItem;

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {
			LinkedItem<T> currentItem;
			LinkedItem<T> lastItem;

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
		return result;
	}

	@Override
	public boolean offer(T t) {
		boolean result = false;

		if (firstItem == null) {
			firstItem = new LinkedItem(t);
			result = true;
		} else {
			boolean searching = true;
			LinkedItem currentItem = firstItem;
			LinkedItem lastItem = null;
			while (searching) {
				if (currentItem.getNextItem() == null) {
					lastItem = currentItem;
					searching = false;
				}
				currentItem = currentItem.getNextItem();
			}
			lastItem.setNextItem(new LinkedItem(t));
			result = true;
		}
		return result;
	}

	@Override
	public T peek() {
		T result = null;
		if (firstItem != null) {
			result = (T) firstItem.value;
		}
		return result;
	}
}