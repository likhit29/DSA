public class Likhit_100_10 {
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    
    public Likhit_100_10(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public void enqueue(int data) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
            queue[rear] = data;
        } else {
            rear = (rear + 1) % maxSize;
            if (rear == front) {
                System.out.println("Queue is full. Cannot enqueue.");
                rear = (rear - 1 + maxSize) % maxSize;
            } else {
                queue[rear] = data;
            }
        }
    }

    public int dequeue() {
        int data = -1;
        if (!isEmpty()) {
            data = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % maxSize;
            }
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
        }

        return data;
    }

    public int peek() {
        if (!isEmpty()) {
            return queue[front];
        } else {
            System.out.println("Queue is empty. No peek value.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public static void main(String[] args) {
        Likhit_100_10 circularQueue = new Likhit_100_10(5);

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        System.out.println("Peek: " + circularQueue.peek());
        System.out.println("Dequeue: " + circularQueue.dequeue());
        System.out.println("Peek after dequeue: " + circularQueue.peek());
    }
}
