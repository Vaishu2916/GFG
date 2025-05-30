//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends
class Solution {
    static int inversionCount(int arr[]){
        int[] temp = new int[arr.length];
        return mergeSort(arr,temp,0,arr.length - 1);
    }
    static int mergeSort(int[]arr, int[]temp, int left, int right){
        int invCount = 0;
        if(left<right){
            int mid = (left + right)/2;
        
            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr,temp, mid+1, right);
            invCount += merge(arr,temp, left, mid, right);
        }
        return invCount;
    }
    static int merge(int[] arr, int[]temp,int left, int mid, int right){
        int i = left;
        int j = mid +1;
        int k = left;
        int invCount =0;
        
        while(i<= mid && j <= right){
            if(arr[i]<= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                invCount += (mid -i+1);
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<= right){
            temp[k++] = arr[j++];
        }
        for(int x = left; x<= right;x++){
            arr[x] = temp[x];
        }
        return invCount;
    }
}