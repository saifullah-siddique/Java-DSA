package Arrays;
import java.util.*;

public class ArraysP2 {

    public static void kadansAlgorithm (int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            currentSum += arr[i];
            if (currentSum < 0 ) {
                currentSum = 0; 
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("Max SubArray Sum : " + maxSum);
    }

    public static int auxiliaryArray(int height[]) {
        if (height.length <3) {
            return 0;
        }

        //Calculate Left Max Boundary - array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1 ; i <height.length ; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //Calculate Right Max Boundary - array
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = height.length-2 ; i >=0 ; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        for (int i = 0 ; i < height.length ; i++) {
            //minmum bound from or right;
            int minMaxValue = Math.min(leftMax[i], rightMax[i]);
            //trapped water calculate
            trappedWater += (minMaxValue - height[i]) ; 
        }

        //returned Total Traped Water
        return trappedWater; 
    }

    public static int buyAndsellStocks (int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0 ; i < prices.length ; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = maxProfit < profit ? profit : maxProfit ;
            } else {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
        
    }
    

    public static boolean repeat(int nums[]) {
        for (int i = 0 ; i <nums.length ; i++) {
            int count = 0 ; 
            for (int j = i ; j < nums.length ; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
                if (count>=2) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int target(int nums[], int target ) {
        int left = 0 ; 
        int right = nums.length-1; 

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target ) return mid ; 

            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid +1; 
                } else {
                    right = mid -1;
                }
            }
        }

        return -1;
    }

    public static int maxProfit(int prices[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0 ; i < prices.length ; i++) {
            if(buyprice < prices[i]) {
                int profit = prices[i] - buyprice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyprice = prices[i];
            }
        }
        return maxProfit;
    }

    public static int trapedWater(int height[]) {
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1 ; i < height.length ; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        //right side
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2 ; i >= 0 ; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int totalTrapedWater = 0 ;
        for (int i = 0 ; i < height.length ; i++) {
            int minMaxValue = Math.min(leftMax[i], rightMax[i]);
            totalTrapedWater += (minMaxValue - height[i]);
        }

        return totalTrapedWater;

    }

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        //Q2//
        /*
        There is an integer array nums sorted in ascending order (with distinct values).
        Prior to being passed to your function, 
        nums is possibly rotated at an unknown pivot  index k (1  <=  k  <  nums.length)  such  that  the  
        resulting  array  is [nums[k], nums[k+1],...,nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).   
        For   example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
        Given the array nums after the possible rotation and an integer target, 
        return the index of target if it is in nums, or -1   if it is not in nums.
        You must write an algorithm with O(log n) runtime complexity.
         */
        // int nums[] = {4,5,6,7,0,1,2}; //target = 0; //op ; 4
        // System.out.println("Element is at Index :" +target(nums, 0));



        //Q3//
        /*
        You  are  given  an  array prices where prices[i] is  the  price  of  a  given
        stock  on  the ith day. Return the maximum profit you can achieve from this 
        transaction. If you cannot achieve any profit, return 0.
        */
        // int prices[] = {7,1,5,3,6,4};
        // System.out.println("Total Profit  = " + maxProfit(prices));




        //Q4//
        /*
        Given n non-negative integers representing an elevation map where the width of 
        each bar is 1, compute how much water it can trap after raining.
        */
        // int height[] = {4, 2, 0, 3, 2, 5};
        // System.out.println("Total Traped Water : " + trapedWater(height));

        
        sc.close();
    }
}
