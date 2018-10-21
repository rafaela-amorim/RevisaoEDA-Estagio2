package linked_list;

public class RecursiveDoubleLinkedList<T> extends RecursiveSingleLinkedList<T> implements DoubleLinkedList<T> {
	
	protected RecursiveDoubleLinkedList<T> previous;
	
	public RecursiveDoubleLinkedList() {}
	
	public RecursiveDoubleLinkedList(T data, 
									 RecursiveDoubleLinkedList<T> next, 
									 RecursiveDoubleLinkedList<T> previous) {
		super(data, next);
		this.previous = previous;
	}
	
	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) 
				insert(element);
			else {
				RecursiveDoubleLinkedList<T> novo = new RecursiveDoubleLinkedList<>();
				
				((RecursiveDoubleLinkedList<T>) next).setPrevious(novo);
				novo.setNext(next);
				
				this.setNext(novo);
				novo.setPrevious(this);
				
				novo.setData(data);
				this.setData(element);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			this.data = next.getData();
			this.next = next.getNext();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void removeLast() {
		if (isEmpty()) {
			if (!getPrevious().isEmpty()) {
				RecursiveDoubleLinkedList<T> aux = getPrevious();
				(aux.getPrevious()).setNext(aux.getNext());
				((RecursiveDoubleLinkedList<T>) aux.getNext()).setPrevious(aux.getPrevious());
			}
		} else
			((DoubleLinkedList<T>) next).removeLast();
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				data = element;
				next = new RecursiveDoubleLinkedList<>();
				((RecursiveDoubleLinkedList<T>) next).setPrevious(this);
				
				if (getPrevious() == null) {
					setPrevious(new RecursiveDoubleLinkedList<>());
					getPrevious().setNext(this);
				}
				
			} else
				next.insert(element);
			
		}
	}
	
	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			if (data.equals(element)) {
				data = next.getData();
				next = next.getNext();
				((RecursiveDoubleLinkedList<T>) next).setPrevious(this);		// next = next.getNext()
			} else 
				next.remove(element);
		}
	}
	
	public void inverte() {
		RecursiveDoubleLinkedList<T> first = this;
		RecursiveDoubleLinkedList<T> last = this;
		T aux;
		
		if (!isEmpty() && !next.isEmpty()) {
			while (!last.isEmpty())
				last = (RecursiveDoubleLinkedList<T>) last.getNext();
			last = last.getPrevious();	// pq parou no NIL
			
			
			while (first != last && first.getNext() != last) {
				aux = first.getData();
				first.setData(last.getData());
				last.setData(aux);
				
				first = (RecursiveDoubleLinkedList<T>) first.getNext();
				last = last.getPrevious();
			}
			
			if (this.size() % 2 == 0) {		// ficaram 2 elementos nao trocados no meio
				aux = first.getData();
				first.setData(last.getData());
				last.setData(aux);
			}
		}
			
	}
	
	public void setPrevious(RecursiveDoubleLinkedList<T> previous) {
		this.previous = previous;
	}
	
	public RecursiveDoubleLinkedList<T> getPrevious() {
		return previous;
	}

}
