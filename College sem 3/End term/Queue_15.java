import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Queue_15 {
    public int countStudentsUnableToEat(int[] students, int[] sandwiches) {
        Stack<Integer> sandwichStack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.add(student);
        }

        int attempts = 0; // Tracks how many consecutive attempts fail to take the sandwich

        while (!studentQueue.isEmpty() && attempts < studentQueue.size()) {
            if (studentQueue.peek() == sandwichStack.peek()) {
                studentQueue.remove();
                sandwichStack.pop();
                attempts = 0; // Reset attempts
            } else {
                studentQueue.add(studentQueue.remove());
                attempts++;
            }
        }

        return studentQueue.size();
    }

    public static void main(String[] args) {
        Queue_15 sq = new Queue_15();
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        System.out.println(sq.countStudentsUnableToEat(students, sandwiches)); 
    }
}
