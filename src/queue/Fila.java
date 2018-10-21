package queue;

import java.util.Arrays;

public class Fila<T> implements Queue<T> {
	
	T[] fila;
	int countElements;
	
	@SuppressWarnings("unchecked")
	public Fila(int tamanho) {
		fila = (T[]) new Object[tamanho];
		countElements = 0;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();
		
		if (element != null) 
			fila[countElements++] = element;
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		
		T removed = fila[0];
		shiftLeft();
		
		countElements--;
		return removed;
	}
	
	public void shiftLeft() {
		for (int i = 1; i < countElements; i++) 
			fila[i - 1] = fila[i];
		
		fila[countElements] = null;	
	}
	
	@Override
	public T head() {
		return fila[0];
	}
	
	@Override
	public boolean isEmpty() {
		return countElements == 0;
	}

	@Override
	public boolean isFull() {
		return countElements == fila.length;
	}
	
	@Override
	public int capacity() {
		return fila.length;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(fila);
	}

}
