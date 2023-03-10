package assignment2;

import java.util.NoSuchElementException;

public class MyQueue<E> {
    private MyDoublyLinkedList<E> queue;

    public MyQueue() {
        queue = new MyDoublyLinkedList();
    }

    public boolean enqueue(E element) {
        return(queue.addLast(element));
    }

    public E dequeue() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("The queue is empty.");
        }
        else {
            return(queue.removeFirst());
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
    }

    public boolean equals(Object o) {
        if (o instanceof MyQueue && ) {
            return true;
        }
        return false
    }

}