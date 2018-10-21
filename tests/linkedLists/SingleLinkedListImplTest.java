package linkedLists;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import linked_list.LinkedList;
import linked_list.SingleLinkedListImpl;

public class SingleLinkedListImplTest {
	
	LinkedList<Integer> l1;
	LinkedList<Integer> l2;
	
	@Before
	public void inicia() {
		l1 = new SingleLinkedListImpl<>();
		l2 = new SingleLinkedListImpl<>();
		
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(l2.isEmpty());
		assertFalse(l1.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, l2.size());
		assertEquals(4, l1.size());
		l2.insert(3);
		assertEquals(1, l2.size());
		l1.remove(2);
		assertEquals(3, l1.size());
	}

	@Test
	public void testSearch() {
		assertEquals(2, (int) l1.search(2));
		assertEquals(4, (int) l1.search(4));
		assertNull(l2.search(1));
		assertEquals(1, (int) l1.search(1));
	}

	@Test
	public void testInsert() {
		l2.insert(5);
		assertEquals(5, (int) l2.search(5));
		l1.insert(2);
		Assert.assertArrayEquals(new Integer[] {1,2,3,4,2}, l1.toArray());
	}

	@Test
	public void testRemove() {
		l2.remove(5421);
		l1.remove(641);
		l1.remove(4);
		l1.toArray();
		Assert.assertArrayEquals(new Integer[] {1,2,3}, l1.toArray());
		l1.insert(4);
		l1.remove(2);
		Assert.assertArrayEquals(new Integer[] {1,3,4}, l1.toArray());
		l1.remove(1);
		Assert.assertArrayEquals(new Integer[] {3,4}, l1.toArray());
		l1.remove(3);
		Assert.assertArrayEquals(new Integer[] {4}, l1.toArray());
		l1.remove(4);
		Assert.assertArrayEquals(new Integer[] {}, l1.toArray());
		l1.remove(0);
	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {1,2,3,4}, l1.toArray());
		Assert.assertArrayEquals(new Integer[] {}, l2.toArray());
		l2.insert(50);
		Assert.assertArrayEquals(new Integer[] {50}, l2.toArray());
	}
}
