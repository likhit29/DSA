public class A17_Max_subarray_sum {


/////total no of pairs = n(n-1)/2
public static void printPairs(int numbers[]){
    int ts = 0;
    for (int i = 0; i < numbers.length; i++) {
        int curr = numbers[i]; // Current element       
        // Iterate over all elements after the current element
        for (int j = i + 1; j < numbers.length; j++) {
            // Print the pair
            System.out.print("(" + curr + ", " + numbers[j] + ") ");
            ts++;
        }       
        System.out.println(); // Newline after printing all pairs for a given element
    }  
    System.out.println("total pair = " + ts);
}


//total subarrays = n(n+1)/2
//Print Subarrays
public static void printSubarrays(int numbers[]) {
        int ts = 0;
        for (int i = 0; i < numbers.length; i++) {                      //start lelement    
            int start = i;
            for (int j = i; j < numbers.length; j++) {                  //end loop
                int end = j;
                for (int k = start; k <= end; k++) {                    // print
                    System.out.print(numbers[k] + " ");                 // subarray 
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total subarrays = " + ts);
    }

    // Time Complexity = O(n³)
    // Brute Force
        public static void maxSubarraysSum1(int numbers[]) {
            int currSum = 0;
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                int start = i;
                for (int j = i; j < numbers.length; j++) {
                    int end = j;
                    currSum = 0;
                    for (int k = start; k <= end; k++) { // print
                        currSum += numbers[k];
                    }
                    System.out.println(currSum);
                    if (maxSum < currSum) {
                        maxSum = currSum;
                    }
    
                }
    
            }
            System.out.print("max sum = " + maxSum);
        }
    
    // Time Complexity = O(n²)
    // Prefix Sum
    // 1. Create a new array
    // 2. 
        public static void maxSubarraysSum2(int numbers[]) {
            int currSum = 0;
            int maxSum = Integer.MIN_VALUE;
    
            int prefix[] = new int[numbers.length];
            prefix[0] = numbers[0];
    
            // calculate prefix array
    
            for (int i = 1; i < prefix.length; i++) {
    
                prefix[i] = prefix[i - 1] + numbers[i];
            }
    
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i; j < numbers.length; j++) {
                    currSum = 0;   
                    currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                    /*
                    if (i == 0) {
                        currSum = prefix[j];
                    } else {
                        currSum = prefix[j] - prefix[i - 1];
                    }
                     */
                    if (maxSum < currSum) {
                        maxSum = currSum;
                    }   
                }   
            }
            System.out.print("max sum = " + maxSum);
        }
    
    // Time Complexity = O(n)
    // Kadanes
        public static void maxSubarraysSum3(int numbers[]) {
    
            int ms = Integer.MIN_VALUE;
            int cs = 0;
            for (int i = 0; i < numbers.length; i++) {
                cs = cs + numbers[i];
                ms = Math.max(cs, ms);
                if (cs < 0) {
                    cs = 0;
                }
            }
            System.out.println("max subarray sum is : " + ms);
    
        }
    
    
        public static void main(String args[]) {
            int numbers[] = { 1, -2, 8, -1, 3 };
            //maxSubarraysSum1(numbers);
            //maxSubarraysSum2(numbers);
            maxSubarraysSum3(numbers);
            //printSubarrays(numbers);
            //printPairs(numbers);
    
        }
    
    }