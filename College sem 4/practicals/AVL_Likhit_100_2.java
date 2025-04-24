//AVL

public class AVL_Likhit_100_2 {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 0;
        }
    }

    public static Node root;

    public static int height(Node r) {
        if (r == null)
            return -1;

        else {
            int lheight = height(r.left);
            int rheight = height(r.right);
            return Math.max(lheight, rheight) + 1;
        }
    }

    //LL Rotation
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = height(y);
        x.height = height(x);

        return x;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = height(x);
        y.height = height(y);

        return y;
    }

    public static int getBalance(Node root) {
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);
    }

    public static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        else
            return root;

        root.height = height(root);

        int bf = getBalance(root);

        if (bf > 1 && key < root.left.data)
            return rightRotate(root);
        if (bf < -1 && key > root.right.data)
            return leftRotate(root);
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        System.out.println(getBalance(root));
        inorder(root.right);
    }

    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 100);
            root = insert(root, a);
        }
        inorder(root);

        System.out.println("\n"+ root.height);
    }
}
