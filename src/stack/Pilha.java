package stack;

import java.util.Arrays;

public class Pilha<T> implements Stack<T> {
	
	T[] pilha;
	int top;
	
	@SuppressWarnings("unchecked")
	public Pilha(int tamanho) {
		pilha = (T[]) new Object[tamanho];
		top = -1;
	}
	
	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();
		
		if (element != null)
			pilha[++top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		
		T removed = pilha[top];
		pilha[top--] = null;
		
		return removed;
	}

	@Override
	public T top() {
		return pilha[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == pilha.length - 1;
	}

	@Override
	public int capacity() {
		return pilha.length;
	}

	@Override
	public int size() {
		return top + 1;
	}
	 
	@Override
	public String toString() {
		return Arrays.toString(pilha);
	}
}
