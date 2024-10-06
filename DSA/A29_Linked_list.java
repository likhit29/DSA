
/*
// LinkedList operations - add, remove, print, search

// To Add Node at First 
    1.Create a newNode
    2.newNode.next = head
    3.head = newNode

// To Add Node at Last
    1.Create a newNode
    2.tail.next = newNode 
    3.tail = newNode

// To print a Linkedlist we have to create a temp variable


*/


public class A29_Linked_list {

    public static class Node {

        int data;
        Node next;

        public Node(int data) { // constructor
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;        // Declaring variable -  static it means head will be common for all objects
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head; // link to node which already head is pointing
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // i = idx - 1 temp->prev
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev : i = size - 2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public void iterative_search(int key) {

        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (key == temp.data) {
                System.out.println("Key found at index - " + i);
                return;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Key not found");
    }



    // Recursive search
    public int helper(Node head, int key) {

        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recursive_search(int key) {
        return helper(head, key);
    }





    // Reverse a linked list - sequence prev -> curr -> next
    // 3 variable, 4 steps
    // left to right
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }




    // Find and remove nth node from end
    // nth from end -> from start it will be (size-n+1)
    // how to calculate size (sz) in different manner
    public void deleteNthfromEnd(int n) {
        // caculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) {
            head = head.next; // removing first element
            return;
        }

        // sz-n
        int i = 1;
        int iToFind = sz - n;
        Node prev = head; // prev is node just before node to be deleted
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }




    // To find mid node by slow-fast approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow is my middle
    }

    // Check ll is palindrome or not
    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // 1.Find midNode
        Node miNode = findMid(head);

        // 2.Reverse 2nd half
        Node prev = null;
        Node curr = miNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head (last element of input ll)
        Node left = head;
        // 3.Check if 1st half(left) = 2nd half(right)
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }





    public static void main(String[] args) {
        A29_Linked_list ll = new A29_Linked_list();

        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addMiddle(2, 9);
        // ll.print();
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // ll.iterative_search(10);
        // System.out.println(ll.recursive_search(3));
        // System.out.println("Size of ll - " + ll.size);
        // ll.reverse();
        // ll.print();
        // ll.deleteNthfromEnd(3);
        // ll.print();

        ll.addFirst(2);
        ll.addLast(5);
        ll.addLast(8);
        ll.addLast(2);
        ll.print();
        System.out.println(ll.checkPalindrome());

    }
}