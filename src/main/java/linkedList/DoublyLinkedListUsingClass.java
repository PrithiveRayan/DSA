package linkedList;

public class DoublyLinkedListUsingClass<T> {

    private Node head;
    private int size;

    DoublyLinkedListUsingClass(){
        head = null;
    }

    class Node{
        private T data;
        private Node next;
        private Node prev;

        Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public int getSize() {
        return size;
    }

//    5 -> 10 -> 15

    public void insertAtHead(T data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(T data){
        if(head == null){
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        newNode.prev = temp;
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
        for(int i=0; i<pos; i++){
            if(temp == null || temp.next == null){
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp;
        newNode.prev = temp.prev;
        temp.prev.next = newNode;
        size++;

    }

    public void removeAtHead(){
        if(head == null){
            System.out.println("Nothing to remove!");
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removetAtPos(int pos){
        if(pos == 0){
            removeAtHead();
            return;
        }

        Node temp = head;
        for(int i=0; i<pos; i++){
            if(temp == null || temp.next == null){
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }
        if(temp.next == null){
            temp.prev.next = null;

        }else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        size--;

    }

    public void removeAtTail(){
        if(head == null){
            System.out.println("Nothing to remove!");
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        size--;

    }

    public void show(){
        if(head == null) {
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

    public void showReverse(){
        if (head == null){
            System.out.println("List is empty!");
            return;
        }
    }

}
