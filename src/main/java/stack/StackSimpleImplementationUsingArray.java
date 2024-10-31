package stack;

class StackSimpleImplementationUsingArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize stack
    public StackSimpleImplementationUsingArray(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Method to add an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            stackArray[++top] = value; // Increment top and add the value
            System.out.println(value + " pushed onto stack.");
        }
    }

    // Method to remove an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            return stackArray[top--]; // Return top value and decrement top
        }
    }

    // Method to peek the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No top element.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Optional: Method to display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StackSimpleImplementationUsingArray stack = new StackSimpleImplementationUsingArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Popped element: " + stack.pop());
        stack.display();

        System.out.println("Top element is: " + stack.peek());
        stack.display();
    }
}
