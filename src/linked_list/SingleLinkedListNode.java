package linked_list;

public class SingleLinkedListNode<T> {
	
	protected T data;
	protected SingleLinkedListNode<T> next;
	
	public SingleLinkedListNode(T data, SingleLinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public SingleLinkedListNode() {}
	
	public boolean isNIL() {
		return data == null;
	}
	
	public T getData() {
		return data;
	}
	
	public SingleLinkedListNode<T> getNext() {
		return next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(SingleLinkedListNode<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		String resp = null;
		if (!isNIL()) {
			resp = this.data.toString();
		} else {
			resp = "NIL";
		}
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if (obj instanceof SingleLinkedListNode) {
			if (!this.isNIL()) {
				resp = this.data.equals(((SingleLinkedListNode<T>) obj).data);
			} else {
				resp = ((SingleLinkedListNode<T>) obj).isNIL();
			}

		}
		return resp;
	}
}
