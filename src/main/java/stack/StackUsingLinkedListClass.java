package stack;

public class StackUsingLinkedListClass<T> {

    Node top = null;

    class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
            next = null;
        }
    }

    public void push(T data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop(){
        if(top == null){
            System.out.println("Stack is empty!");
        }
        T popped = top.data ;
        top = top.next;
        return popped;
    }

    public T peek(){
        return top.data;    
    }

    public void show(){
    }
}
