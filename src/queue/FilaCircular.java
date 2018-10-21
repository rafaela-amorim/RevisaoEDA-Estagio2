package queue;

public class FilaCircular<T> implements Queue<T> {

	T[] fila;
	int head;
	int tail;
	int elements;
	
	@SuppressWarnings("unchecked")
	public FilaCircular(int tamanho) {
		fila = (T[]) new Object[tamanho];
		head = 0;
		tail = -1;
		elements = 0;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();
		
		if (element != null) {
			tail = (tail + 1) % capacity();
			fila[tail] = element;
			elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		
		T removed = fila[head];
		head = (head + 1) % capacity(); 				// vai pro prox elemento
		elements--;
		
		return removed;
	}

	@Override
	public T head() {
		T answer = null;
		if (!isEmpty())
			answer = fila[head];

		return answer;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return ((tail + 1) % fila.length) == head;
	}

	@Override
	public int capacity() {
		return fila.length;
	}

}
