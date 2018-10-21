package stack;

import queue.Fila;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

public class InvertePilhaComFila {
	
	public static void inverte(Stack pilha) throws QueueOverflowException, StackUnderflowException, StackOverflowException, QueueUnderflowException {
		Fila fila = new Fila(pilha.capacity());
		
		while (!pilha.isEmpty())
			fila.enqueue(pilha.pop());
		
		while (!fila.isEmpty())
			pilha.push(fila.dequeue());
	}
	
	public static void main(String[] args) throws QueueOverflowException, StackUnderflowException, StackOverflowException, QueueUnderflowException {
		Pilha p = new Pilha(4);
		p.push(1);
		p.push(2);
		p.push(4);

		inverte(p);
		System.out.println(p.toString());
		
	}
}
