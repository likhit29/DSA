//count no of nodes (R & NR)
//height (R & NR)
//inorder,preorder and postorder (R & NR using stack)
//insertion and deletion    
/* 
Operation | Average Time Complexity | Worst Time Complexity
Insert    | O(log n)                | O(n)
Search    | O(log n)                | O(n)
Delete    | O(log n)                | O(n)
Traversal | O(n)                    | O(n)


•	The minimum height of a binary tree = ⌈log₂(n + 1)⌉ - 1 
5. Number of leaf nodes – (n+1)/2
: Number of leaf nodes = Number of nodes with two children + 1
the maximum number of nodes = 2^l level
•	A binary tree of height h can have at most 2^(h+1) - 1 nodes.
*/


/*
chapter 2 

HEAP
Insertion	                        O(log n)
Delete Min / Max (root deletion)	O(log n)
Get Min / Max (root access) peek	O(1)
Search 	                            O(n)
Heapify a single node	            O(log n)
Build Heap from array (n elements)	O(n)

•	Parent index: (i - 1) / 2 (using integer division)
•	Left child index: 2 * i + 1
•	Right child index: 2 * i + 2

Avl - h≈1.44log2(n+2)−0.328

 */

 /*
  BFS , DFS - O(V + E)

  Adjacency Matrix  
  •	Edge lookup: O(1)
  •	Space: O(V²)



Adjacency List
•	Edge lookup: O(k) (k = neighbors of vertex)
•	Space: O(V + E)


Prim’s Algorithm
•  O(V^2) with an adjacency matrix (for dense graphs).
• O(E+logV) with a Fibonacci heap and adjacency list 


Kruskal’s Algorithm
O(ElogE) (sorting all edges).


  */





public class chapter1 {
    
}
