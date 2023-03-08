package assignment2;

public abstract class MyLinkedList<E> implements MyList<E> {
    protected int size;

    public MyLinkedList() {
        size = 0;
    }
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public int getSize() {
        return this.size;
    }
}