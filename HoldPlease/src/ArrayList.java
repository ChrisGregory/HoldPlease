import java.lang.reflect.Array;
import java.util.Iterator;


public class ArrayList<T> implements List<T> {
	
	T[] array;
	int index = 0;
	Class<T> type;

	@SuppressWarnings("unchecked")
	public ArrayList(Class<T> type, int capacity){
		this.type = type;
		array = (T[])Array.newInstance(type,capacity);
	}

	@Override
	public boolean add(T t) {
		boolean result = false;
		if(array.length <= index)
		{
			T[] newArray = (T[])Array.newInstance(type, array.length * 2);
			for(int i = 0; i < array.length; i++){
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[index] = t;
		index++;
		result = true;
		return result;
	}

	@Override
	public T get(int index) {
		return array[index];
	}

	@Override
	public boolean remove(T t) {
		boolean result = false;
		boolean removed = false;
		int removedindex = -1;
		//Find Value
		for(int i = 0; i < array.length && !removed; i++)
		{
			//Remove the Value.
			if(array[i].equals(t)){
				array[i] = null;
				removed = true;
				result = true;
				removedindex = i;
				T[] newArray = (T[])Array.newInstance(type, array.length);
				//Rebuild Array
				for(int j = 0; j < array.length; i++){
					if(j < removedindex){
						newArray[i] = array[i];	
					}else if(j > removedindex){
						newArray[i-1] = array[i];		
					}
				}
				array = newArray;
			}			
		}
		//Shrink Array if neccesary
		if(array.length >= 2 * index)
		{
			T[] newArray = (T[])Array.newInstance(type, array.length / 2);
			for(int i = 0; i < newArray.length; i++){
				newArray[i] = array[i];
			}
			array = newArray;
		}
		result = true;
		return result;
	}

	@Override
	public int size() {
		return index + 1;
	}

	@Override
	public Iterator<T> iterator() {
		// Does not need to be fully implemented for this lab.
		return null;
	}

}
