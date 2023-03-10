package assignment2;

public class MyStack<E> {

    private MyDoublyLinkedList<E> stack;

    public MyStack() {
        this.stack = new MyDoublyLinkedList();
    }

    public boolean push(E element){
        if (stack.addLast(element)) {
            return true;
        }
        return false;
    }

    public E pop() {
        return stack.removeLast();
    }

    public E peek() {
        return stack.peekFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clear() {
        stack.clear();
    }

    public int getSize() {
        return stack.size;
    }
}