//Diameter of a tree que is in A35

public class A36_Subtree_of_another_tree{

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
 
    /*
    same structure and node values

     1. Find subroot in main tree
     2. check indentical
    */

    // Subtree of another tree
    public static boolean isIdentical(Node node, Node subroot){
        if(node == null && subroot == null){
            return true;
        }
        else if(node == null || subroot == null || node.data!=subroot.data){
            return false;
        }

        if(!isIdentical(node.left, subroot.left)){
            return false;
        }
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subroot){
        if (root == null) {
                return false;
        }
        if(root.data == subroot.data){
            if(isIdentical(root, subroot)){
                return true;
            }
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public static void main(String[] args) {
        
    /*
    Binary tree
            1
           / \
          2   3
         / \ / \
        4  5 6  7

    */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    

    /*
        Subtree
             2
            / \
           4   5

    */
    Node subRoot = new Node(2);
    subRoot.left = new Node(4);
    subRoot.right = new Node(5);

    System.out.println(isSubtree(root, subRoot));
    }
}












