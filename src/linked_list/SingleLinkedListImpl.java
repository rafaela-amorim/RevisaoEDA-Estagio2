package linked_list;

public class SingleLinkedListImpl<T> implements LinkedList<T> {
	
	SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<>();
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> novo = new SingleLinkedListNode<>();
			novo.setData(element);
			
			if (isEmpty()) {
				head = novo;
				head.setNext(new SingleLinkedListNode<>());
			} else {
				SingleLinkedListNode<T> aux = head;
				while (!aux.getNext().isNIL())
					aux = aux.getNext();
				
				novo.setNext(aux.getNext());
				aux.setNext(novo);
			}
			
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null) {
			if (head.getData().equals(element)) 
				head = head.getNext();
			else {
				SingleLinkedListNode<T> previous = head;
				SingleLinkedListNode<T> aux = head.getNext();
				
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					previous = aux;
					aux = aux.getNext();
				}
				
				if (!aux.isNIL())
					previous.setNext(aux.getNext());
			}
		}
	}

	@Override
	public T search(T element) {
		T answer = null;
		
		if (element != null && !isEmpty()) {
			SingleLinkedListNode<T> aux = head;
			
			while (!aux.isNIL() && !aux.getData().equals(element))
				aux = aux.getNext();
			
			if (!aux.isNIL())
				answer = aux.getData();
				
		}
		
		return answer;
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		
		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = head;
			
			while (!aux.isNIL()) {
				size++;
				aux = aux.getNext();
			}
		}
		
		return size;
	}

	@Override
	public T[] toArray() {
		return buildArray();
	}
	
	@SuppressWarnings("unchecked")
	private T[] buildArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = head;
		int index = 0;
		
		while (!aux.isNIL()) {
			array[index++] = aux.getData();
			aux = aux.getNext();
		}
		
		return array;
	}
	
	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	@Override
	public int indexOf(T element) {
		return 0;
	}

}











