package queue;

public class QueueImplUsingLinkedList<T> {
    private Node head;
    private int size;

    QueueImplUsingLinkedList(){
        head = null;
        size = 0;
    }

    class Node{
        private T data;
        private Node next;

        Node(T data){
            this.data = data;
            next = null;
        }

    }

    public int getSize() {
        return size;
    }

    public void enqueue(T data){

    }

    public T dequeue(){
        Node temp = head;

        return temp.data;
    }
}

