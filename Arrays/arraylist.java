package Arrays;
import java.util.*;

public class arraylist {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1 , list.get(3));
        list.set(idx2, temp);
    }

    //Container with most water 
    public static int mostWater(ArrayList<Integer> heigth) {
        int maxWater  = 0;
        int si = -1 , ei = -1;

        //bruteforce
        for (int i = 0 ; i < heigth.size() ; i++) {
            for(int j = i+1 ; j < heigth.size(); j++) {
                int h = 0; 
                if(heigth.get(i) < heigth.get(j)) {
                    h = heigth.get(i);
                } else {
                    h = heigth.get(j);
                }
                int w = j - i;
                int water = w * h ;
                if(water > maxWater) {
                    maxWater = water;
                    si = i ; ei = j;
                }
            }
        }
        System.out.println("Container of idx " + si + " and " + ei);
        return maxWater;
    }

    //2 pointer aproach for most water store 
    public static int maxWater(ArrayList<Integer> height) {
        int maxWater = 0 ; 
        int left = 0 , right = height.size() -1 ; 
        while (left < right) {
            int h = height.get(left) < height.get(right) ? height.get(left) : height.get(right);
            int w = right - left ; 
            int currWater = w * h ;
            maxWater = currWater > maxWater ? currWater : maxWater ;

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }   
        }
        return maxWater;
    }

    public static boolean PairSum(ArrayList<Integer> list, int target) {
        int left = 0 , right = list.size() -1 ;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                System.out.println(list.get(left) + " " + list.get(right) + " = " + target);
                return true;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    public static boolean pairSum(ArrayList<Integer> list , int tgt) {
        int rp = -1 ;
        for(int i = 0 ; i < list.size()-1 ; i++) {
            if(!(list.get(i) < list.get(i+1))) {
                rp = i;
                break;
            }
        }

        int lp  = rp +1; 

        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum  == tgt) {
                System.out.println(list.get(lp) + " " +  list.get(rp) + " = " + tgt);
                return true;
            }

            if (sum > tgt) {
                rp = (list.size() + rp -1 ) % list.size();
            } else {
                lp = (lp + 1 ) % list.size();
            }
        }

        return false;

    }

    public static void main(String[] args) {
    // //Container with most water 
    // ArrayList<Integer> heigth = new ArrayList<>();
    // heigth.add(1);
    // heigth.add(8);
    // heigth.add(6);
    // heigth.add(2);
    // heigth.add(5);
    // heigth.add(4);
    // heigth.add(8);
    // heigth.add(3);
    // heigth.add(7);
    // System.out.println(maxWater(heigth));


    // //PairSum 1 
    // int target  = 5;
    // ArrayList<Integer> list = new ArrayList<>();
    // list.add(1);
    // list.add(2);
    // list.add(3);
    // list.add(4);
    // list.add(5);
    // list.add(6);
    // PairSum(list,target);

    //pair sum 2 (rotated shorted array) (use of modular, in advance data structure , must read about it)
    ArrayList<Integer> list = new ArrayList<>();
    list.add(11);
    list.add(15);
    list.add(6);
    list.add(8);
    list.add(9);
    list.add(10);
    int tgt = 15; 

    System.out.println(pairSum(list, tgt));

    }
}