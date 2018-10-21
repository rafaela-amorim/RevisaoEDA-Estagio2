package linkedLists;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import linked_list.DoubleLinkedListImpl;
import linked_list.DoubleLinkedListNode;

public class DoubleLinkedListImplTest extends SingleLinkedListImplTest {
	
	DoubleLinkedListImpl<Integer> l1;
	DoubleLinkedListImpl<Integer> l2;
	
	@Before
	public void setUp() {
		l1 = new DoubleLinkedListImpl<>();
		l2 = new DoubleLinkedListImpl<>();
		
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
	}

	@Test
	public void testInsertFirst() {
		l2.insertFirst(1);
		assertEquals(1, (int) l2.search(1));
		Assert.assertArrayEquals(new Integer[] {1,2,3,4}, l1.toArray());
		l1.insertFirst(6);
		Assert.assertArrayEquals(new Integer[] {6,1,2,3,4}, l1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		l2.removeFirst();
		l2.insert(1);
		Assert.assertArrayEquals(new Integer[] {1}, l2.toArray());
		l2.removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, l2.toArray());
		l1.removeFirst();
		Assert.assertArrayEquals(new Integer[] {2,3,4}, l1.toArray());
	}

	@Test
	public void testRemoveLast() {
		l2.removeLast();
		l2.insert(5);
		Assert.assertArrayEquals(new Integer[] {5}, l2.toArray());
		l2.removeLast();
		Assert.assertArrayEquals(new Integer[] {}, l2.toArray());
		l1.removeLast();
		Assert.assertArrayEquals(new Integer[] {1,2,3}, l1.toArray());
	}
	
	@Test
	public void testPercorrePrevious() {
		l1.insert(5);
		l1.insert(6);
		l1.insert(7);
		l1.insert(8);
		int i = 8;
		
		DoubleLinkedListNode<Integer> ultimo = l1.getTail();
		
		while (!ultimo.isNIL()) {
			assertEquals(i--, (int) ultimo.getData());
			ultimo = ultimo.getPrevious();
		}
	}
	
	
	@Test
	public void testPercorreNext() {
		l1.insert(5);
		l1.insert(6);
		l1.insert(7);
		l1.insert(8);
		int i = 1;
		
		DoubleLinkedListNode<Integer> ponteiro = (DoubleLinkedListNode<Integer>) l1.getHead();
		
		while (!ponteiro.isNIL()) {
			assertEquals(i++, (int) ponteiro.getData());
			ponteiro = (DoubleLinkedListNode<Integer>) ponteiro.getNext();
		}
	}
}
