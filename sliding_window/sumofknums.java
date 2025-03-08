package sliding_window;

import java.util.*;

public class sumofknums{
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 4};  
        int target = 10;


        System.out.println(MinLenSum(arr, target));
    }

    public static int MinLenSum(int[] a,int target){
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;

        while(right<a.length){
            
            sum += a[right];
            int len = right - left + 1;

            if(sum == target){
                res = Math.min(len,res);
                // System.out.println("Result for len "+ len + " :  "+ res);    
            }
            
            while(sum>=target){
                res = Math.min(res,(right - left + 1));
                sum -= a[left];
                left++;
                System.out.println("Result at right "+ right + " left " + left+ " is :  " + res);
            }

            right++;
        }

        return res==Integer.MAX_VALUE ? -1 : res;
    }
}