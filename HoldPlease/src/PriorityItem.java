
public class PriorityItem<T> {
	public T value;
	private PriorityItem nextItem;
	public int priority;
	
	public PriorityItem(T value, PriorityItem nextItem){
		this.value = value;
		this.nextItem = nextItem;
	}
	
	public PriorityItem(T value){
		this.value = value;
		this.nextItem = null;
	}
	
	public void setNextItem(PriorityItem nextItem){
		this.nextItem = nextItem;
	}
	public PriorityItem<T> getNextItem(){
		return nextItem;
	}
}
