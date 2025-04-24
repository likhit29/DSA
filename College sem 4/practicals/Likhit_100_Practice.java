//Write a function to return balance factor of a node.
public static int getBalance(Node root) {
    if (root == null)
        return 0;
    return height(root.left) - height(root.right);
}

// Write non-recursive code to return height of a BST
public class height {
    public static int height(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            height++;
        }

        return height;
    }




// Write a function to implement Dijkstra's algorithms for all vertices as source
public static void dijkstra(ArrayList<Edge> graph[], int src){
    int dist[] = new int[graph.length];    
    for(int i = 0; i<graph.length; i++){
        if(i != src){
            dist[i] = Integer.MAX_VALUE;      
        }
    }    
    dist[src] = 0;
    boolean vis[] = new boolean[graph.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(src, 0));
    //loop
    while(!pq.isEmpty()){
        Pair curr = pq.remove();
        if(!vis[curr.n]){
            vis[curr.n] = true;
            //neighbours
            for(int i = 0; i<graph[curr.n].size() ; i++){
                Edge e = graph[curr.n].get(i);
                int u = e.src; 
                int v = e.dest;
                int wt = e.wt;

                if (dist[u]+wt < dist[v]) {           
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
    }
// Write Zig-Zig rotation for a Splay tree
private Node rightRotate(Node x) {
    Node y = x.left;
    x.left = y.right;
    y.right = x;
    return y;
}

private Node leftRotate(Node x) {
    Node y = x.right;
    x.right = y.left;
    y.left = x;
    return y;
}

private Node splay(Node root, int key) {
    if (root == null || root.key == key) {
        return root;
    }

    if (key < root.key) {
        if (root.left == null) {
            return root;
        }

        if (key < root.left.key) {
            root.left.left = splay(root.left.left, key);
            root = rightRotate(root);
        }

        else if (key > root.left.key) {
            root.left.right = splay(root.left.right, key);
            if (root.left.right != null) {
                root.left = leftRotate(root.left);
            }
        }

        if (root.left == null) {
            return root;

        } else {
            return rightRotate(root);
        }
    } else {
        if (root.right == null) {
            return root;
        }

        if (key < root.right.key) {
            root.right.left = splay(root.right.left, key);
            if (root.right.left != null) {
                root.right = rightRotate(root.right);
            }
        }

        else if (key > root.right.key) {
            root.right.right = splay(root.right.right, key);
            root = leftRotate(root);
        }

        if (root.right == null) {
            return root;
        
        } else {
            return leftRotate(root);
        }
    }
}