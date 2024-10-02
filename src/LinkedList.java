/**
 * @author William Scott
 *  CSC 130 - Project 1 --updated for Project 2
 *  Proper Linked List Class
 *  Built to include a head and tail, with each node doubly linked
 */

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public String about(){  // my statement
        return "This Linked List is brought to you by William Scott-\n" +
                "This is my linked list. There are many linked lists like it, but this one is mine!";
    }

    public void addHead(Field data) {
        Node newNode = new Node(data);
        if (head == null) { // if there is no head, make new node the head and tail
            head = newNode;
            tail = newNode;
        }
        else {  // if a head exists, add node in front of head then make node the new head
            newNode.next = head;
            head = newNode;
        }
    }

    public void addTail(Field data) {
        Node newNode = new Node(data);
        if (head == null){  //if there is no head, make node head
            head = newNode;
        }
        else {   // if head exists, add node after tail
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode; // set tail to be the new node
    }

    public Field removeHead() {
        Node temp;
        if (head == null){  // if head does not exist, return null
            return null;
        }
        else if (head == tail) {    // if there is only one node, remove the node and set fields to null
            temp = head;
            head = null;
            tail = null;
        }
        else {  // save reference for head, remove the link, set head to the next node in the list
            temp = head;
            head = head.next;
            temp.next = null;
        }
        return temp.field;
    }

    public Field removeTail() {
        Node temp;
        if (head == null) { // if the head does not exist, there is no list, throw exception
            return null;
        }
        else if (head == tail) {    // only one node, remove node
            temp = head;
            head = null;
            tail = null;
        }
        else {  // save reference to tail, set tail to the previous node, remove the links
            temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;

        }
        return temp.field;
    }

    public Boolean isEmpty() {  // is the list empty?
        if (head == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        String list;
        if (head == null) {     // if the list is empty return special message
            return "The List is Empty";
        } else {
            Node current = head.next;
            list = "(" + head.field.key + ")" + " " + head.field.value + "\n";
            while (current != null) {
                list += "(" + current.field.key + ") " + current.field.value + "\n";
                current = current.next;
            }
        }
        return list;
    }

    public String toStringReverse() {
        String reverse;
        if (head == null) { // if there is no head return special message for special people
            return "Empty, the Linked List is";
        } else {  // if there is a head, read the list backwards and add to string
            Node current = tail.prev; // set current node to second to last position
            reverse =  "(" + tail.field.key + ")" + " " + tail.field.value;  // start string with tail node
            while (current != null) {
                reverse += ", (" + current.field.key + ")" + current.field.value;
                current = current.prev;  // repeat until head node
            }
        }
        return reverse;
    }

    // Nested Node Class
    private class Node {
        public Field field;
        public Node prev;
        public Node next;

        // Node Constructors
        public Node(){
            this(null, null, null);
        }

        public Node (Field field) {
            this(field, null, null);
        }

        public Node (Field field, Node prev, Node next){
            this.field = field;
            this.prev = prev;
            this.next = next;
        }
    }
}