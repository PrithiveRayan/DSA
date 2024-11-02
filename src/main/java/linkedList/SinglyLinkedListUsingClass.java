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

    // Doesn't modify the existing list
    public SinglyLinkedListUsingClass oddEvenList1(){
        SinglyLinkedListUsingClass<Integer> oddEvenList = new SinglyLinkedListUsingClass<>();
        SinglyLinkedListUsingClass<Integer> oddList = new SinglyLinkedListUsingClass<>();
        SinglyLinkedListUsingClass<Integer> evenList = new SinglyLinkedListUsingClass<>();

        Node odd = head;
        Node even = head.next;
        Node current = head;
        int count = 0;
        while(current != null){
            if((count+1)%2 != 0){
                oddList.insertAtHead((Integer) odd.data);
                if(odd.next != null){
                    odd = odd.next.next;
                }
                current = current.next;
                count++;
            }
            else {
                evenList.insertAtHead((Integer) even.data);
                if(even.next != null){
                    even = even.next.next;
                }
                current = current.next;
                count++;
            }
        }
        while(evenList.head != null){
            oddEvenList.insertAtHead(evenList.head.data);
            evenList.head = evenList.head.next;
        }
        while(oddList.head != null){
            oddEvenList.insertAtHead(oddList.head.data);
            oddList.head = oddList.head.next;
        }
        return oddEvenList;
    }

    //Modifies the existing list
    public SinglyLinkedListUsingClass<T> oddEvenList() {
        if (head == null || head.next == null) {
            return this;
        }
        SinglyLinkedListUsingClass<T> oddEvenList = new SinglyLinkedListUsingClass<>();
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        oddEvenList.head = head;
        return oddEvenList;
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

    public void show(SinglyLinkedListUsingClass list){
        if(list.head == null){
            System.out.println("List is empty!");
            return;
        }
        Node temp = list.head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
