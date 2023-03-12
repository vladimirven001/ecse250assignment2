package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> { 

	private DNode head;
	private DNode tail;
	
	
	/*
	 My Code
	 */

	public boolean add(E element) {
		DNode added = new DNode();
		if (this.tail != null) {
			added.element = element;
			added.prev = this.tail;
			this.tail.next = added;
			this.tail = added;
		}
		else {
			added.element = element;
			this.head = added;
			this.tail = this.head;
		}
		this.size++;
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
			this.size--;
			return element;
		}
	}

	public boolean addFirst(E element) {
		DNode added = new DNode();
		if (this.tail != null) {
			added.element = element;
			added.next = this.head;
			this.head = added;
		}
		else {
			added.element = element;
			this.head = added;
			this.tail = this.head;
		}
		this.size++;
		return true;
	}

	public boolean addLast(E element) {
		return this.add(element);
	}

	public E removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The linked list is empty.");
		}
		else {
			E element = this.head.element;
			(this.head.next).prev = null;
			this.head= this.head.next;
			this.size--;
			return element;
		}
	}

	public E removeLast() {
		return this.remove();
	}

	public E peekFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The linked list is empty.");
		}
		else {
			return this.head.element;
		}
	}

	public E peekLast() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The linked list is empty.");
		}
		else {
			return this.tail.element;
		}
	}

	public void clear() {
		while (!this.isEmpty()) {
			this.remove();
		}
	}

	public boolean equals(Object o) {
		if (!(o instanceof MyDoublyLinkedList) || ((MyDoublyLinkedList)o).size != this.size) {
			return false;
		}
		DNode current1 = this.head;
		DNode current2 = ((MyDoublyLinkedList)o).head;
		while (current1.next != null) {
			if (!(current1.element.equals(current2.element))) {
				return false;
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		return true;
	}
	/*
	End of my Code
	 */

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
