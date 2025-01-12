public class bst {

    static class node{
        String word, meaning;
        node left;
        node right;
        node(String word, String meaning){
            this.word = word;
            this.meaning = meaning;
            this.left = null;
            this.right = null;   
        }
    }
    public node root;
    bst(){
        root = null;
    }
    public void insert(String w, String m) {
        root = insertRec(root, w, m);
    }

    private node insertRec(node root, String w, String m) {
        if (root == null) {
            root = new node(w, m);
            return root;
        }

        if (w.compareTo(root.word) < 0) {
            root.left = insertRec(root.left, w, m);
        } else if (w.compareTo(root.word) > 0) {
            root.right = insertRec(root.right, w, m);
        } else {
            System.out.println("Duplicate word " + w);
        }

        return root;
    }
    public void inorder(node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.word + " " + root.meaning);
        inorder(root.right);
        return;
    }

    public void search(node root, String w) {
        if (root == null) {
            System.out.println("Word not found: " + w);
            return;
        }
        if (w.equals(root.word)) {
            System.out.println("Meaning: " + root.meaning);
            return;  
        }
        if (w.compareTo(root.word) < 0) {
            search(root.left, w); 
        } else {
            search(root.right, w); 
        }
    }
    

    public static void main(String[] args){
        bst t = new bst();
        t.insert("fea", "fe");
        t.insert("qq", "q3e");
        //t.inorder(t.root);
        t.search(t.root, "fna");
        
    }

}