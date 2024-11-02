package linkedList;

import java.util.Iterator;

public class SinglyLinkedListUsingClass<T> implements Iterable<T>{

    private Node head;
    private int size;

    SinglyLinkedListUsingClass(){
        this.head = null;
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

    public void insertAtHead(T data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(T data){
        Node newNode = new Node(data);
        Node temp = head;
        do{
            temp = temp.next;
        }
        while(temp.next != null);
        temp.next = newNode;
        size++;

    }

    public void insertAtPos(int pos, T data){
        if(pos == 0){
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for(int i = 1; i<pos; i++){
            if(temp == null){
                System.out.println("Invalid position.");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtHead(){
        if(head.next == null){
            System.out.println("Nothing to delete");
            return;
        }
        head = head.next;
        size--;

    }

    public void deleteAtPos(int pos){
        if(pos == 0){
            deleteAtHead();
            return;
        }
        Node temp = head;
        for(int i = 1; i<pos; i++){
            if(temp == null){
                System.out.println("Invalid position.");
                return;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;

    }

    public void deleteAtMiddle(){
        if(size == 0){
            System.out.println("No value to delete.");
            return;
        }
        int toDelete = size/2;
        Node temp = head;
        for(int i = 1; i<toDelete; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void deleteAtTail(){
        Node temp = head;
        do{
            temp = temp.next;
        }while(temp.next.next != null);
        temp.next = null;
        size--;
    }

    public void reverseTheList(){
        Node prev = null;
        Node current = head;
        Node next = head.next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        head = prev;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = head;
            @Override
            public boolean hasNext() {
                return  temp != null;
            }

            @Override
            public T next() {
                T val = temp.data;
                temp = temp.next;
                return val;
            }
        };
    }

    public void show(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
