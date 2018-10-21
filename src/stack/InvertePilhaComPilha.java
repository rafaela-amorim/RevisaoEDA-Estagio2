package stack;

public class InvertePilhaComPilha {
	
	public static Pilha inverte(Pilha pilha) throws StackOverflowException, StackUnderflowException {
		Pilha aux = new Pilha(pilha.capacity());
		
		while (!pilha.isEmpty())
			aux.push(pilha.pop());
		
		return aux;
	}
	
	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		Pilha p = new Pilha(4);
		p.push(1);
		p.push(2);
		p.push(4);
		
		System.out.println(p.toString());
		Pilha saida = inverte(p);
		System.out.println(saida.toString());
	}
}
