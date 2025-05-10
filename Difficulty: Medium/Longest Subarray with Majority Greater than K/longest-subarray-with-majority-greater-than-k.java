//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Code Here
         Map<Integer, Integer> map = new HashMap<>();
    int sum = 0, maxLen = 0;
    map.put(0, -1);
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i] > k ? 1 : -1;
        if (sum > 0) maxLen = i + 1;
        else map.putIfAbsent(sum, i);
        if (map.containsKey(sum - 1))
            maxLen = Math.max(maxLen, i - map.get(sum - 1));
    }
    return maxLen;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends