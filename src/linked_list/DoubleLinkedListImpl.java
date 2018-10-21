package linked_list;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	DoubleLinkedListNode<T> tail;
	
	public DoubleLinkedListImpl() {
		head = new DoubleLinkedListNode<>();
		tail = new DoubleLinkedListNode<>();
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty())
				insert(element);
			else {
				DoubleLinkedListNode<T> novo = new DoubleLinkedListNode<>();
				novo.setData(element);
				
				DoubleLinkedListNode<T> aux = ((DoubleLinkedListNode<T>) head).getPrevious();
				novo.setPrevious(aux);
				aux.setNext(novo);
				novo.setNext(head);
				((DoubleLinkedListNode<T>) head).setPrevious(novo);
				head = novo;
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			if (!head.getNext().isNIL()) {
				excludeNode((DoubleLinkedListNode<T>) head);
				head = head.getNext();
			} else {
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<>();
				head = nil;
				tail = nil;
			}
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (!tail.getPrevious().isNIL()) {
				excludeNode(tail);
				tail = tail.getPrevious();
			} else {
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<>();
				head = nil;
				tail = nil;
			}
		}
	}
	
	@Override
	public T search(T element) {
		T answer = null;
		
		if (!isEmpty()) {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
			DoubleLinkedListNode<T> auxTail = tail;
			
			while (auxHead != auxTail && auxHead.getNext() != auxTail && !auxHead.getData().equals(element) && !auxTail.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxTail = auxTail.getPrevious();
			}
			
			if (auxHead.getData().equals(element))		answer = auxHead.getData();
			if (auxTail.getData().equals(element))		answer = auxTail.getData();
		}
		
		return answer;
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> novo = new DoubleLinkedListNode<>();
			novo.setData(element);
			
			if (isEmpty()) {
				novo.setPrevious(new DoubleLinkedListNode<>());
				novo.setNext(new DoubleLinkedListNode<>());
				head = novo;
				tail = novo;
			} else {
				novo.setNext(tail.getNext());
				((DoubleLinkedListNode<T>) tail.getNext()).setPrevious(novo);
				novo.setPrevious(tail);
				tail.setNext(novo);
				tail = novo;
			}
		}
	}
	
	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null) {
			if (head.getData().equals(element)) {
				excludeNode((DoubleLinkedListNode<T>) head);
				head = head.getNext();
				
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) head.getNext();
				
				while (!aux.isNIL() && !aux.getData().equals(element)) 
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				
				excludeNode(aux);	// já verifica se aux isNIL é verdadeiro ou não
			}
		}
	}
	
	private void excludeNode(DoubleLinkedListNode<T> node) {
		if (!node.isNIL()) {
			DoubleLinkedListNode<T> anterior =  node.getPrevious();
			DoubleLinkedListNode<T> posterior = (DoubleLinkedListNode<T>) node.getNext();
			
			anterior.setNext(posterior);
			posterior.setPrevious(anterior);
		}
	}
	
	public DoubleLinkedListNode<T> getTail() {
		return tail;
	}
	
}
