package queue;

import stack.Pilha;
import stack.StackOverflowException;
import stack.StackUnderflowException;

public class InverteFila {
	
	public static void inverteFila(Fila fila) throws StackOverflowException, QueueUnderflowException, QueueOverflowException, StackUnderflowException {
		Pilha pilha = new Pilha(fila.capacity());
		
		while (!fila.isEmpty())
			pilha.push(fila.dequeue());
		
		while (!pilha.isEmpty())
			fila.enqueue(pilha.pop());
	}
	
	public static void main(String[] args) throws QueueOverflowException, StackOverflowException, QueueUnderflowException, StackUnderflowException {
		Fila f = new Fila(4);
		f.enqueue(1);
		f.enqueue(2);
		f.enqueue(4);
		
		inverteFila(f);
		
		System.out.println(f.toString());
	}
}
