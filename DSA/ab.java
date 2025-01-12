//Binary Search Tree - Inorder traversal of BST gives a sorted sequence

public class ab{
    public class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    node root;
    ab(){
        this.root = null;
    }

    public void insert(int data){
        root = insertrec(root, data);
    }

    public node insertrec(node root, int data){
        if(root == null){
            root = new node(data);
            return root;
        }
        if(root.data>data){
            root.left = insertrec(root.left, data);
        }
        else if (root.data<data){
            root.right = insertrec(root.right, data);
        }
        return root;
    }

    public void inorder(node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public void search(node root, int data){
        if(root == null){
            System.out.println("not found");
            return;
        }
        if(root.data == data){
            System.out.println("found");
            return;
        }
        if(root.data>data){
            search(root.left, data);
        }
        else if (root.data<data){
            search(root.right, data);
        } 
    }

    public void delete(){
        
    }

    public static void main(String[] args) {
        ab t = new ab();
        t.insert(5);
        t.insert(1);
        t.insert(3);
        t.insert(4);
        t.insert(2);
        t.insert(7);
        
        
        //t.inorder(t.root);
        
        t.search(t.root, 7);

    }
}