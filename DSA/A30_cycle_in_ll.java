public class A30_cycle_in_ll extends A29_Linked_list{

    //Detecting loop/cycle in a ll - If we implement fast-slow approach -> when in ll the fast and slow meet at any particular node, it means there is loop in a ll
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;       //+1
            fast = fast.next.next;       //+2
            if(slow == fast){
                return true;        //cycle exists
            }
        }
        return false;               //cycle does not exist
    }




    //Remove a loop in a ll
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;       //+1
            fast = fast.next.next;       //+2
            if(slow == fast){
                cycle = true;        //cycle exists
                break;
            }
        }
        if(cycle == false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;       //last node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle -> lastnode.next = null
        prev.next = null;
    }

    public static void main(String[] args) {
        
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1 -> 2 -> 3 -> 2 
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());

    }
}










