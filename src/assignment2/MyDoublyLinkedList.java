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
		DNode current = this.head;
		while (current.next != null) {
			if (current.element != o) {
				return false;
			}
			current.prev = current;
			current = current.next;
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
