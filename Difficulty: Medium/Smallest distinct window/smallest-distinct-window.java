//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
         int n = str.length(), total = (int) str.chars().distinct().count();
        int[] freq = new int[256];
        int start = 0, count = 0, minLen = n + 1;
        for (int end = 0; end < n; end++) {
            if (++freq[str.charAt(end)] == 1) count++;
            while (count == total) {
                minLen = Math.min(minLen, end - start + 1);
                if (--freq[str.charAt(start++)] == 0) count--;
            }
        }
        return minLen;
    }
}