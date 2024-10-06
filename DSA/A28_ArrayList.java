/* 
28 - Array List

import java.util.ArrayList;

Integer.MIN_VALUE = -∞

-> Array - fixed Size, primitive(int,char,float) data types can be stored
-> ArrayList - dynamic size, primitive data types cannot be stores -  Integer, String, Boolean
-> If we created array an arraylist of 10 size and it is over so it increases it automatically
-> Java collection framework

Syntax - ArrayList<Integer> list1 = new ArrayList<>();
Syntax - ArrayList<String> list2 = new ArrayList<>();

Operations - 
1. list.add(1) - add element to the end of the list                 - O(1)
2. list.get(2) - get element at the specified index                 - O(1)
3. list.remove(1) - remove element at the specified index           - O(n)
4. list.set(1,2) - replace element at the specified index           - O(n)
5. list.contains(15) - (true/false) check the element in the list   - O(n)
6. list.add(1,2) - add element at the specified index               - O(n)

7. list.size() - size of ArrayList



// Que 1 - Swapping of two numbers
    int temp = list.get(idx1); 
    list.set(idx1, list.get(idx2)); 
    list.set(idx2, temp); 

 
import java.utiil.Collections;
-> Collections.sort(list_name)                                    -  sort in ascending order
-> Collections.sort(list_name, Collections.reverseOrder());       -  we have used Comparators here for reverse order


-> Multi Dimensional Arraylists - ArrayList<ArrayList<Integer>> main_list = new ArrayList<>();

*/

import java.util.*;
class A28_ArrayList {

    // Que 2 - Print 3D Arraylist -> list1 - 1,2,3,4,5 ; list2 - 2,4,6,8,10 ; list3-
    // 3,6,9,12,15
    public static void multi_dimesional() {
        ArrayList<ArrayList<Integer>> main_list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            list1.add(i);
            list2.add(i * 2);
            list3.add(i * 3);
        }
        main_list.add(list1);
        main_list.add(list2);
        main_list.add(list3);

        // System.out.print(main_list);

        for (int i = 0; i < main_list.size(); i++) {
            ArrayList<Integer> curr_list = new ArrayList<>();
            curr_list = main_list.get(i);

            for (int j = 0; j < curr_list.size(); j++) {
                System.out.print(curr_list.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        multi_dimesional();
    }
}
