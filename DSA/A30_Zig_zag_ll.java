public class A30_Zig_zag_ll extends A29_Linked_list {

    public void zig() {

        // find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // alternate merge - zigzag merge
        Node LH = head;
        Node RH = prev;
        Node Ltemp, Rtemp;
        while (LH != null && RH != null) {
            Ltemp = LH.next;
            LH.next = RH;
            Rtemp = RH.next;
            RH.next = Ltemp;

            LH = Ltemp;
            RH = Rtemp;

        }

    }

    public static void main(String[] args) {
        A30_Zig_zag_ll o1 = new A30_Zig_zag_ll();
        o1.addFirst(1);
        o1.addLast(2);
        o1.addLast(3);
        o1.addLast(4);
        o1.addLast(5);
        o1.addLast(6);
        o1.print();
        o1.zig();
        o1.print();

    }

}
