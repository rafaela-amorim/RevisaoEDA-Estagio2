package linked_list;

public class RecursiveSingleLinkedList<T> implements LinkedList<T> {
	
	protected T data;
	protected RecursiveSingleLinkedList<T> next;
	
	// Construtores
	
	public RecursiveSingleLinkedList() {}
	
	public RecursiveSingleLinkedList(T data, RecursiveSingleLinkedList<T> next) {
		this.data = data;
		this.next = next;
	}
	
	// Métodos
	
	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				data = element;
				next = new RecursiveSingleLinkedList<>();
			} else 
				next.insert(element);
		}
		
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null) {
			if (data.equals(element)) {
				data = next.getData();
				next = next.getNext();
			} else
				next.remove(element);
		}
	}

	@Override
	public T search(T element) {
		T answer = null;
		
		if (element != null && !isEmpty()) {
			if (data.equals(element))
				answer = data;
			else
				answer = next.search(element);
		}
		
		return answer;
	}

	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		int tamanho = 0;
		
		if (!isEmpty())
			tamanho = 1 + next.size();
		
		return tamanho;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		buildArray(array, 0, this);
		return array;
	}
	
	private void buildArray(T[] array, int index, RecursiveSingleLinkedList<T> node) {
		if (!node.isEmpty()) {
			array[index] = node.getData();
			buildArray(array, ++index, node.getNext());
		}
	}
	
	public int indexOf(T element) {
		int index = 0;
		
		RecursiveSingleLinkedList<T> aux = this;
		
		while (!aux.isEmpty() && !aux.getData().equals(element)) {
			aux = aux.getNext();
			index++;
		}
		
		if (aux.isEmpty())	index = -1;
			
		return index;
	}
	
	public void inverte() {
		if (!isEmpty() && !next.isEmpty()) {
			RecursiveSingleLinkedList<T> nodeI = this;
			RecursiveSingleLinkedList<T> nodeJ = next;
			RecursiveSingleLinkedList<T> parada = this;
			T aux;
			
			while (!parada.isEmpty())
				parada = parada.getNext();
			
			while (next != parada) {
				nodeI = this;
				nodeJ = next;
				aux = nodeI.getData();
				
				while (nodeJ.getNext() != parada) {
					nodeI.setData(nodeJ.getData());
					nodeJ.setData(aux);
					
					nodeI = nodeI.getNext();
					nodeJ = nodeJ.getNext();
				}
				
				nodeI.setData(nodeJ.getData());
				nodeJ.setData(aux);
				parada = nodeJ;
			}
			
		}
	}	
	
	// Getters e Setters
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public RecursiveSingleLinkedList<T> getNext() {
		return next;
	}
	
	public void setNext(RecursiveSingleLinkedList<T> next) {
		this.next = next;
	}

}
