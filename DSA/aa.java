public class aa{
    public class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int idx = -1;
    
    public Node insert(int nodes[]){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node nn = new Node(nodes[idx]);
        nn.left = insert(nodes);
        nn.right = insert(nodes);
        return nn;

    }


    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        aa d = new aa();
        Node root = d.insert(nodes);
    }

}