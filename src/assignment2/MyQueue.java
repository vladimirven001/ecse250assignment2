package assignment2;

import java.util.NoSuchElementException;
import java.util.Queue;

public class MyQueue<E> {
    private MyDoublyLinkedList<E> queue;

    public MyQueue() {
        queue = new MyDoublyLinkedList();
    }

    public boolean enqueue(E element) {
        return(queue.addLast(element));
    }

    public E dequeue() {
        return(queue.removeFirst());
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
    }

    public boolean equals(Object o) {
        if (o instanceof MyQueue && (this.queue).equals(((MyQueue) o).queue)) {
            return true;
        }
        return false;
    }

}