
//Binary Search Tree - Inorder traversal of BST gives a sorted sequence
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A38_BST {
    public class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    node root;

    A38_BST() {
        this.root = null;
    }

    public boolean isTreeEmpty() {
        return root == null;
    }

    public void insert(int data) {
        root = insertrec(root, data);
    }

    // Everytime when adding new element we will compare it with main root node
    public node insertrec(node root, int data) {
        if (root == null) {
            root = new node(data);
            return root;
        }
        if (root.data > data) {
            root.left = insertrec(root.left, data);
        } else if (root.data < data) {
            root.right = insertrec(root.right, data);
        }
        return root;
    }

    public void insertIterative(int val) {
        node n = new node(val);
        if (isTreeEmpty()) {
            root = n;
        } else {
            node temp = root;
            while (temp != null) {
                if (val == temp.data) {
                    return;
                } else if (val < temp.data && temp.left == null) {
                    temp.left = n;
                    break;
                } else if (val < temp.data) {
                    temp = temp.left;
                } else if (val > temp.data && temp.right == null) {
                    temp.right = n;
                    break;
                } else {
                    temp = temp.right;
                }

            }
        }
    }

    public void printLevelOrderQueue(node r) {
		node temp = null;
		Queue<node> queue = new LinkedList<node>();
		queue.add(r);

		while (queue.size() > 0) {
			temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.add(temp.left); 
			}
			if (temp.right != null) {
				queue.add(temp.right); 
			}
		}
	}

    public void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public void search(node root, int data) {
        if (root == null) {
            System.out.println("not found");
            return;

        }
        if (root.data == data) {
            System.out.println("found");
            return;
        }
        if (root.data > data) {
            search(root.left, data);
        } else if (root.data < data) {
            search(root.right, data);
        }
    }
    public boolean iterativeSearch(int val) {
		boolean flag = false;
		if (root == null) {
			System.out.println("Binary Search Tree is Empty");
		}
		else {
			node temp = root;
			while (temp != null) {
				if (val == temp.data) { 
					flag = true;
					break;
				}
				else if (val < temp.data) 
					temp = temp.left;

				else if (val > temp.data)
					temp = temp.right;
			}
		}
		return flag;
	}

    public node delete(node root, int val) {
        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            node IS = findInorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public node findInorderSuccesor(node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void printInRange(node root, int l1, int l2) {
        if (root == null) {
            return;
        }
        if (root.data > l1) {
            printInRange(root.left, l1, l2);
        }
        if (root.data >= l1 && root.data <= l2) {
            System.out.println(root.data);
        }
        if (root.data < l2) {
            printInRange(root.right, l1, l2);
        }
    }

    Stack<Integer> s = new Stack<>();

    public void RoadToLeafPaths(node root) {
        if (root == null) {
            return;
        }
        s.push(root.data);
        RoadToLeafPaths(root.left);
        if (root.left == null && root.right == null) {
            System.out.println(s);
        }

        RoadToLeafPaths(root.right);
        s.pop();

    }

    /*
     * Validate BST -
     * Approach 1
     * Approach 2 - max value in left subtree < node < min value in right subtree
     * Left subtree - min = min of prev
     * max = root/parent
     * Right subtree - min = root/parent
     * max = max of prev
     * 
     */

    public boolean isValidBST(node root, node min, node max) {
        if (root == null) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        A38_BST t = new A38_BST();
        t.insert(8);
        t.insert(5);
        t.insert(3);
        t.insert(1);
        t.insert(4);
        t.insert(6);
        t.insert(10);
        t.insert(11);
        t.insert(14);

        // t.inorder(t.root);
        // t.printInRange(t.root, 5, 8);

        // t.search(t.root, 7);
        // t.delete(t.root, 4);
        // t.inorder(t.root);
        t.RoadToLeafPaths(t.root);

    }
}