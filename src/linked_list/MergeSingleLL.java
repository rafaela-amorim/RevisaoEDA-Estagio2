package linked_list;

public class MergeSingleLL {
	
	public static void merge(SingleLinkedListImpl<Integer> lista1, SingleLinkedListImpl<Integer> lista2) {
		
		SingleLinkedListImpl<Integer> aux = lista1;
		
		while (!aux.isEmpty() && !lista2.isEmpty()) {
			if (aux.getHead().getData() <= lista2.getHead().getData()) {
				if (aux != lista1)
					lista1.head = lista1.getHead().next;
			}
		}
		
	}
	
}
