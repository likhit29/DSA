import java.util.ArrayList;

public class testt {

    static class Heap {
        ArrayList<Integer> ar = new ArrayList<>();

        public boolean isEmpty() {
            return ar.size() == 0;
        }

        /*
         * 1. add at last
         * 2. fix heap by comparing last node(child) with its parent -> x-1/2
         */
        public void add(int data) {
            ar.add(data);
            int ch = ar.size() - 1;
            int par = (ch - 1) / 2;
            while (ar.get(ch) < ar.get(par)) {
                int temp = ar.get(par);
                ar.set(par, ar.get(ch));
                ar.set(ch, temp);

                ch = par;
                par = (ch - 1) / 2;
            }
        }

        public int peek() {
            if (isEmpty()) {
                return Integer.MIN_VALUE; 
            }
            return ar.get(0);
        }

        /*
         * deleting in min heap means deleting minimum element (which is root)
         * 1. swap 1st(root) and last node
         * 2. remove last node(last index)
         * 3. heapify O(logn)
         * root = i
         * left = 2i + 1
         * right = 2i + 2
         * min = (i, 2i + 1, 2i + 2)
         */

        private void heapify(int i) {
            int minidx = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < ar.size() && ar.get(minidx) > ar.get(left)) {
                minidx = left;
            }
            if (right < ar.size() && ar.get(minidx) > ar.get(right)) {
                minidx = right;
            }
            if (minidx != i) {
                int temp = ar.get(i);
                ar.set(i, ar.get(minidx));
                ar.set(minidx, temp);

                heapify(minidx);
            }

        }

        public int remove() {
            if (isEmpty()) {
                return Integer.MIN_VALUE; 
            }
            int data = ar.get(0);

            int temp = ar.get(0);
            ar.set(0, ar.get(ar.size() - 1));
            ar.set(ar.size() - 1, temp);

            ar.remove(ar.size() - 1);

            heapify(0);
            return data;
        }
    }

    public static void main(String[] args) {
        Heap h1 = new Heap();
        h1.add(3);
        h1.add(4);
        h1.add(0);
        h1.add(5);

        while (!h1.isEmpty()) {
            System.out.println(h1.peek());
            h1.remove();
        }
    }

    


}
