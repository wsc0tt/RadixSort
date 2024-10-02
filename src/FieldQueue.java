/**
 * @author William Scott
 * FieldQueue class implements a queue of Fields using LinkedList class
 */

public class FieldQueue {
    LinkedList list = new LinkedList();

    public void enqueue (Field item) {
        list.addTail(item);
    }

    public Field dequeue() {
        return list.removeHead();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }

}
