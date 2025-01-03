//Stack using queue

import java.util.*;

public class Stack_using_queue {
   
    Queue<Integer> s1 = new LinkedList<>();
    Queue<Integer> s2 = new LinkedList<>();

    public void push(int data){
        s1.add(data);
    }
    public int pop() {
        if (s1.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1; 
        }
        
        while (s1.size() > 1) {
            s2.add(s1.remove());
        }
        int top = s1.remove();
        
        Queue<Integer> temp = s1;
        s1 = s2;
        s2 = temp;
        
        return top;
    }
   

    public static void main(String[] args) {

    }
}