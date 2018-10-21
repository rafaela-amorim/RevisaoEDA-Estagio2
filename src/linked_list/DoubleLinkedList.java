package linked_list;

public interface DoubleLinkedList<T> extends LinkedList<T> {
	
	public void insertFirst(T element);
	public void removeFirst();
	public void removeLast();
	
}
