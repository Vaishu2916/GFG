//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String countAndSay(int n) {
        // code here
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < res.length(); ) {
                char ch = res.charAt(j);
                int count = 0;
                while (j < res.length() && res.charAt(j) == ch) {
                    count++;
                    j++;
                }
                temp.append(count).append(ch);
            }
            res = temp.toString();
        }
        return res;
    }
}
