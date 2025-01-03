public class Question27 {
    class Node{
        int value;
        Node next;
        Node pre;
        Node(int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    Question27(){
        head = null;
        tail = null;
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
    }
    public void isPalindrome(){
        Node temp = head;
        Node temp2 = tail;
        while(temp != null && temp2 != null){
            if(temp.value != temp2.value){
                System.out.println("Not a palindrome");
                return;
            }
            else{
                temp = temp.next;
                temp2 = temp2.pre;
            }
        }
        System.out.print("List is Palindrome");
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }
    public static void main(String args[]){
        Question27 q = new Question27();
        q.append(1);
        q.append(2);
        q.append(2);
        q.append(2);
        q.append(1);
        q.print();
        System.out.println();
        q.isPalindrome();


    }
}
