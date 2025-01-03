public class Question18 {
    class Node{
        String value;
        Node next;
        Node(String value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    public void append(String value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void findN_Participant(int N){
        Node temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        if(N > length){
            System.out.println("There are not enough participants");
            return;
        }
        else{
            temp = head;
            for(int i = 1; i < N;i++){
                temp = temp.next;
            }
            System.out.println("The Nth participant is " + temp.value);
            
        }
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }
    public static void main(String args[]){
        Question18 q = new Question18();
        q.append("Adhyayan");
        q.append("Aditya");
        q.append("Likhit");
        q.append("Ahuja");
        q.append("Anishka");
        q.append("Aabha");
        q.append("Vaishnavi");
        q.print();
        System.out.println();
        q.findN_Participant(3);
    }
}
