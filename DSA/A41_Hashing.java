//Hashing - Hash map, Linked Hashmap, Treemap
/*
1.  Hashmap - are unordered maps
    Implemenation - Linked list
    HashMap<K, V> hm = new HashMap<>();

2.  LinkedHashMap - keys are arranged in insertion ordered
    Implemenation - Doubly Linked list
    LinkedHashMap<K, V> hm = new LinkedHashMap<>();

3.  Tree Map - keys are in sorted order
    Implemenation - Red Black tress -> BST -> self balacing trees
    put, get, remove are O(logn)
    TreeMap<K, V> hm = new TreeMap<>();
*/


/*
CLOSE HASING -  Linear, Quadratic...... probling
OPEN HASING  -   seprate chaining - linkeD list 
 */



/*  Hashmap 

    Best case - O(1)
    Average case - O(lambda)
    Worst case - O(n)

    hm.put(key,value)          - O(1)
    hm.get(key)                - O(1)
    hm.containsKey(key)        - O(1)   
    hm.remove(key)             - O(1)
    hm.size()
    hm.isEmpty()
    hm.clear()

    hm.entryset()

    Set<String> keys = hm.keySet();
    System.out.println(keys);

    Iteration
    foreach
    for(String k : keys){

    }

 */

 import java.util.ArrayList;
 import java.util.LinkedList;
 
 public class A41_Hashing {
         static class HashMap<K,V>{
             private class Node{
 
                 K key;
                 V value;
 
                 public Node(K key, V value){
                     this.key = key;
                     this.value = value;
                 }
             }
             private int n; //n -> nodes 
             private int N;
             //array of type linked list 
             private LinkedList<Node> buckets[]; //N = buckets.length   
             
             @SuppressWarnings("unchecked")
 
             public HashMap(){
                 this.N = 4;
                 this.buckets = new LinkedList[4];
                 for(int i = 0; i<4; i++){
                     this.buckets[i] = new LinkedList<>();
                 }
             }
             
             //bi = bucket index
             //di = data index(linked list index)
 
             private int hashFunction(K key){
                 int hc = key.hashCode();
                 return Math.abs(hc) % N;
             }
 
             private int SearchInLL(K key, int bi){
                 LinkedList<Node> ll = buckets[bi];
                 int di = 0;
                 for(int i = 0; i<ll.size(); i++){
                     Node node = ll.get(i);
                     if(node.key == key){
                         return di;
                     }
                     di++;
                 }
                 return -1;
             }
 
             @SuppressWarnings("unchecked")
             private void rehash(){
                 LinkedList<Node> oldBuck[] = buckets;
                 buckets = new LinkedList[N*2];
                 N = 2*N;
                 for(int i = 0; i<buckets.length; i++){
                     buckets[i] = new LinkedList<>();
                 }
 
                 //to add node from old bucket in new bucket
                 for(int i = 0; i<oldBuck.length; i++){
                     LinkedList<Node> ll = oldBuck[i];
                     for(int j=0; j<ll.size();j++){
                         Node node = ll.remove();
                         put(node.key, node.value);
                     }
                 }
             }
 
             public void put(K key, V value){                //O(lambda) -> O(1)    
                 int bi = hashFunction(key);  // 0 to 3
                 int di = SearchInLL(key, bi);   // valid or -1
 
                 if(di != -1){
                     Node node = buckets[bi].get(di);
                     node.value = value;
                 }
                 else{
                     buckets[bi].add(new Node(key, value));
                     n++;
                 }
                 double lambda = (double)n/N;
                 if (lambda > 2.0) {
                     rehash();
                 }
             }
 
             public boolean containsKey(K key){              //O(lambda) -> O(1)     
                 int bi = hashFunction(key);  // 0 to 3
                 int di = SearchInLL(key, bi);   // valid or -1
 
                 if(di != -1){
                     return true;
                 }
                 else{
                     return false;
                 }
             }
 
             public V get(K key){                //O(1)
                 int bi = hashFunction(key);  // 0 to 3
                 int di = SearchInLL(key, bi);   // valid or -1
 
                 if(di != -1){
                     Node node = buckets[bi].get(di);
                     return node.value;
                 }
                 else{
                     return null;
                 }  
             }
 
             public V remove(K key){                 //O(1)
                 int bi = hashFunction(key);  // 0 to 3
                 int di = SearchInLL(key, bi);   // valid or -1
 
                 if(di != -1){
                     Node node = buckets[bi].remove(di);
                     n--;
                     return node.value;
                 }
                 else{
                     return null;
                 }  
             }
 
             public ArrayList<K> keySet(){
                 ArrayList<K> keys = new ArrayList<>();
 
                 for(int i = 0 ; i<buckets.length; i++){
                     LinkedList<Node> ll = buckets[i];
                     for(Node node : ll){
                         keys.add(node.key);
                     }
                 }
                 return keys;
             }
 
             public boolean isEmpty(){
                 return n==0;
             }
 
 
         }
 
         public static void main(String[] args) {
             HashMap<String, Integer> hm = new HashMap<>();
             hm.put("India", 100);
             hm.put("China", 20);
             hm.put("d", 45);
            
             ArrayList<String> keys = hm.keySet();
             for(String key : keys){
                 System.out.println(key);
             }
 
             //System.out.println(hm.get("India"));
             //System.out.println(hm.remove("India"));
             //System.out.println(hm.get("India"));
 
         }
 
 
 }
 