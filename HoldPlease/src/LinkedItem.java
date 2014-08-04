
public class LinkedItem<T> {
	public T value;
	private LinkedItem nextItem;
	
	public LinkedItem(T value, LinkedItem nextItem){
		this.value = value;
		this.nextItem = nextItem;
	}
	
	public LinkedItem(T value){
		this.value = value;
		this.nextItem = null;
	}
	
	public void setNextItem(LinkedItem nextItem){
		this.nextItem = nextItem;
	}
	public LinkedItem<T> getNextItem(){
		return nextItem;
	}
}
