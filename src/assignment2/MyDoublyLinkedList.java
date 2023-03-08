package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> { 

	private DNode head;
	private DNode tail;
	
	
	/*
	 * ADD YOUR CODE HERE
	 */

	public boolean add(E element) {
		DNode added = new DNode();
		if (this.tail != null) {
			added.element = element;
			added.next = null;
			added.prev = this.tail;
			this.tail.next = added;
			this.tail = added;
		}
		else {
			added.element = element;
			this.head = added;
			this.tail = this.head;
		}
		return true;
	}

	public E remove() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The linked list is empty.");
		}
		else {
			E element = this.tail.element;
			(this.tail.prev).next = null;
			this.tail = this.tail.prev;
			return element;
		}
	}

	public boolean addFirst() {

	}

	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
	}
	
	public Iterator<E> iterator() {
		return new DLLIterator();
	}
	
	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
