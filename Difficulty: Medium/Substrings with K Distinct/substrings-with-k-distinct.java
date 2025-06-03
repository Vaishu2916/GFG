// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {
        // your code here
        return atMostK(s, k) - atMostK(s, k - 1);
    }
    int atMostK(String s, int k) {
        int count = 0, left = 0;
        int[] freq = new int[26];
        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right) - 'a']++ == 0) k--;
            while (k < 0) if (--freq[s.charAt(left++) - 'a'] == 0) k++;
            count += right - left + 1;
        }
        return count;
    }
}