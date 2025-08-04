import java.io.File;
import java.util.Scanner;

class Queue{
    int A[];
    int front;
    int rear;
    int size;
    Queue(int size){
        A = new int[size];
        this.size = size;
        front = rear = -1;
    }
    public boolean isFull(){
        return rear == size - 1;
    }
    public boolean isEmpty(){
        return front == -1;
    }
    public void enqueue(int value){
        if(isEmpty()){
            front = 0;
        }
        if(!isFull()){
            A[++rear] = value;
        }
    }
    public int deQueue(){
        if(!isEmpty()){
            int temp = A[front];
            if(front == rear){
                front = rear = -1;
            }
            else{
                front++;
            }
            
            return temp;
        }
        return 0;
    }
    public int peek(){
        return A[front];
    }

}
class Stack{
    int A[];
    int top;
    int size;
    Stack(int size){
        A = new int[size];
        this.size = size;
        top = -1;
    }
    public boolean isFull(){
        return top == size - 1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int value){
        if(!isFull()){
            A[++top] = value;
        
        }
    }
        
    public int pop(){
        if(!isEmpty()){
            int temp = A[top];
            top--;
            return temp;
        }
        return 0;
    }
    public int peek(){
        return A[top];
    }
}
class Graph{
    int vertices;
    int A[][];
    Graph(String filename) throws Exception{
        Scanner sc = new Scanner(new File(filename));
        vertices = sc.nextInt();
        A = new int[vertices][vertices];
        for(int i = 0; i < vertices;i++){
            for(int j = 0; j < vertices;j++){
                A[i][j] = sc.nextInt();
            }
        }
        sc.close();

    }
    public void BFS(int start){
        Queue q = new Queue(vertices);
        boolean visited[] = new boolean[vertices];
        q.enqueue(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int temp = q.deQueue();
            System.out.print(temp + " ");
            for(int i = 0; i < vertices;i++){
                if(A[temp][i] != 0 && !visited[i]){
                    q.enqueue(i);
                    visited[i] = true;

                }
            }
        }   
    }
    public void DFS(int start){
        Stack s = new Stack(vertices);
        boolean visited[] = new boolean[vertices];
        s.push(start);
        visited[start] = true;
        while(!s.isEmpty()){
            int temp = s.peek();
            System.out.print(temp + " ");
            boolean found = false;                      //
            for(int i = 0; i < vertices;i++){
                if(A[i][temp] != 0 && !visited[i]){
                    s.push(i);
                    visited[i] = true;
                    found = true;                       //
                    break;                          //
                }
            }
            if(!found){
                s.pop();
            }
        }
    }
}
public class BFSDFSTraversal {
    public static void main(String[] args) throws Exception {
        Graph g = new Graph("m1.txt");
        g.BFS(0);
        System.out.println();
        // g.DFS(0);
    }

}
