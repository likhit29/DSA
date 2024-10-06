/*Strings - in java immutable

String str1 = "abcd"
String str2 = new String("sgs");
str1.equals(str2)               -            //used for string declared using new keyword to check equal condition
String str3 = str1 + "few" + str2;          //concatenate two strings
str1.length();                              //parenthis()
str1.charAt(0);                             //charAt(index) returns character at that index

str1.comapareTo(str2)       //here it comapre string in albhabetical order, upper-lower case, 'A' != 'a', find largest string
value of it if - 
                        -ve if str1 is smaller than str2
                        0 if str1 is equal to str2
                        +ve if str1 is greater than str2

str1.comapareToIgnoreCase(Str2)           // 'A' != 'a'

StringBuilder sb = new StringBuilder("Abc")                       //it has lesser time complexity than string
sb.toString()
sb.append(a);

*/

public class A20_String{

    public static boolean isPalindrome(String str) {
        int n = str.length();  // Get the length of the string
        for (int i = 0; i < n / 2; i++) {  // Iterate from start to middle
            if (str.charAt(i) != str.charAt(n - 1 - i)) {  // Compare characters
                // If characters at corresponding positions are not equal, it's not a palindrome
                return false;
            }
        }
        // If all corresponding characters are equal, it's a palindrome
        return true;
    }


    public static void largestString() {
        String fruits[] = {"apple", "mango", "banana"};
        String largest = fruits[0];  // Assume the first fruit is the largest
    
        for (int i = 1; i < fruits.length; i++) {
            // Compare the current largest with the next fruit in the array
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];  // Update largest if the current fruit is lexicographically larger
            }
        }
    
        System.out.println("The lexicographically largest fruit is: " + largest);
    }


    public static void StringBuilder(){
        StringBuilder sb = new StringBuilder(""); // Initialize an empty StringBuilder
        for (char ch = 'a'; ch <= 'z'; ch++) {    // Loop through characters from 'a' to 'z'
            sb.append(ch);                      // Append each character to the StringBuilder
            // O(n) = O(26)              //In this time complexity would be O(n*26)  =  O(n * n)
        }
        System.out.println(sb);          // Print the length of the StringBuilder
    }


    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder();
        
        // Convert the first character to uppercase
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        
        // Iterate through the rest of the string
        for (int i = 1; i < str.length(); i++) {
            // Check if the current character is a space and ensure it's not the last character
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(' '); // Add the space
                i++;  // Move to the next character (first character of the next word)
                sb.append(Character.toUpperCase(str.charAt(i)));  // Convert to uppercase and append
            } else {
                sb.append(str.charAt(i));  // Append the character as is
            }
        }
        
        return sb.toString();
    }
    
    //aaabbbccdd  -   a3b3c2d2
    public static String compression(String str) {
        String newStr = "";
        // aaabc
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if (count > 1) {
                newStr += count.toString();
            }
        }

        return newStr;
    }

    public static void main(String[] args) {
        //String str = "racecar likhit";
        //System.out.println(isPalindrome(str));
        //largestString();
        //StringBuilder();
        //System.out.println(toUpperCase(str));
        String str1 = "abcccdd";
        System.out.println(compression(str1));

    }
  
}
