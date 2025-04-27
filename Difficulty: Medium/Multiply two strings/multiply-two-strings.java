//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // code here.
        int sign = (s1.charAt(0) == '-' ? -1 : 1) * (s2.charAt(0) == '-' ? -1 : 1);
        s1 = s1.replaceAll("^-?0*", ""); s2 = s2.replaceAll("^-?0*", "");
        if (s1.isEmpty() || s2.isEmpty()) return "0";
        int[] res = new int[s1.length() + s2.length()];
        for (int i = s1.length()-1; i >= 0; i--)
            for (int j = s2.length()-1; j >= 0; j--)
                res[i+j+1] += (s1.charAt(i)-'0')*(s2.charAt(j)-'0');
        for (int i = res.length-1; i > 0; i--) { res[i-1] += res[i]/10; res[i] %= 10; }
        StringBuilder sb = new StringBuilder(); for (int num : res) if (!(sb.length()==0 && num==0)) sb.append(num);
        return (sign == -1 ? "-" : "") + (sb.length() == 0 ? "0" : sb.toString());
    }
}