//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int M = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.closestNumber(N, M));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int closestNumber(int n, int m) {
        // code here
        int closest = 0;
        int minDifference = Integer.MAX_VALUE;

        // Check numbers around n
        for (int i = n - Math.abs(m); i <= n + Math.abs(m); ++i) {
            if (i % m == 0) {
                int difference = Math.abs(n - i);

                if (difference < minDifference || 
                   (difference == minDifference && Math.abs(i) > Math.abs(closest))) {
                    closest = i;
                    minDifference = difference;
                }
            }
        }
        return closest;
    }
}