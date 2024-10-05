package linkedList;

public class SinglyLinkedListUsingClass {

    private Node head;

    SinglyLinkedListUsingClass(){
        this.head = null;
    }

    class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
            next = null;
        }

    }

    public void insertAtBegining(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        Node temp = head;
        do{
            temp = temp.next;
        }
        while(temp.next != null);
        temp.next = newNode;

    }

    public void insertAtPos(int pos, int data){
        if(pos == 0){
            insertAtBegining(data);
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
    }

    public void deleteAtBegining(){
        if(head.next == null){
            System.out.println("Nothing to delete");
            return;
        }
        head = head.next;

    }

    public void deleteAtPos(int pos){
        if(pos == 0){
            deleteAtBegining();
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

    }

    public void deleteAtEnding(){
        Node temp = head;
        do{
            temp = temp.next;
        }while(temp.next.next != null);
        temp.next = null;
    }


    public void show(){

        if(head.next == null){
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
