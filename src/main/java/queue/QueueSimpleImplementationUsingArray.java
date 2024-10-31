package queue;

public class QueueSimpleImplementationUsingArray {

    private int front, rear, maxSize;
    private int[] queueArray;

    // Constructor to initialize the queue
    public QueueSimpleImplementationUsingArray(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
    }

    // Method to add an element to the queue (enqueue)
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
        } else {
            rear = (rear + 1) % maxSize; // Move rear in a circular fashion
            queueArray[rear] = value;
            System.out.println(value + " enqueued to queue.");
        }
    }

    // Method to remove an element from the queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } else {
            int value = queueArray[front];
            front = (front + 1) % maxSize; // Move front in a circular fashion
            return value;
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (rear + 1) % maxSize == front && queueArray[front] == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return (rear + 1) % maxSize == front && queueArray[front] != 0;
    }

    // Method to display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i != rear; i = (i + 1) % maxSize) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.print(queueArray[rear] + "\n");
        }
    }

    public static void main(String[] args) {
        QueueSimpleImplementationUsingArray queue = new QueueSimpleImplementationUsingArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        System.out.println("Dequeued element: " + queue.dequeue());
        queue.display();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        System.out.println("Dequeued element: " + queue.dequeue());
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.enqueue(40);
//        queue.enqueue(50);
//        queue.dequeue();
//        queue.enqueue(60);
//        queue.dequeue();
//        queue.enqueue(70);
    }
}
