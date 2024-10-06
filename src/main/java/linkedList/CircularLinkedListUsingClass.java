package linkedList;

import java.util.Iterator;

public class CircularLinkedListUsingClass<T> implements Iterable<T>{

    private Node last;
    CircularLinkedListUsingClass(){
        last = null;
    }

    class Node{
        T data;
        Node next;

        Node(T data){
            this.data = data;
            next = null;
        }
    }

    public void insertFirst(T data, Node newNode){
        last = newNode;
        newNode.next = last;
    }

    public void insertAtBegining(T data){
        Node newNode = new Node(data);
        if(last == null){
            insertFirst(data, newNode);
        }
        else{
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    public void insertAtEnd(T data){
        Node newNode = new Node(data);
        if(last == null){
            insertFirst(data, newNode);
        }
        else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    public void insertAtPos(int pos, T data){

        if(pos == 0){
            insertAtBegining(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = last;
        for(int i = 0; i<pos+1; i++){
            if(temp == null){
                System.out.println("Invalid position.");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeAtTail(){
        Node temp = last.next;
        while(temp.next != last){
            temp = temp.next;

        }
        temp.next = last.next;
        temp = last;
    }

    public void removeAtHead(){

        if(last == null){
            System.out.println("Nothing to delete");
            return;
        }
        last.next = last.next.next;
    }

    public void removeAtPos(int pos){
        if(pos == 0){
            removeAtTail();
            return;
        }
        Node temp = last;
        for(int i = 1; i<pos; i++){
            if(temp == null){
                System.out.println("Invalid position.");
                return;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;

    }

    public void reverseTheList(){
        Node prev = null;
        Node current = last;
        Node next = last.next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        last = prev;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = last;
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
        if(last == null){
            System.out.println("List is empty!");
            return;
        }
        Node temp = last.next;
        do{
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        while(temp != last.next);
        System.out.println("CircularList");
    }
}
