package LeetCode;

public class MergeSortedArray {

    public static  void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m+n];
        int i = 0; 
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2 [j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] =  nums2[j];
                j++;
            }
            k++;
        }

        while (i < m && k < temp.length) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n && k < temp.length) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        for(i = 0 ; i < temp.length ; i++){
            nums1[i] = temp[i];
        }
        
    }

    public static void main(String[] args) {
        int nums1[] = new int[1];
        nums1[0] = 1;
        // nums1[1] = 2;
        // nums1[2] = 3;
        int arr2 [] = {};
        merge(nums1, 0, arr2, 0);
        for (int num : nums1) {
            System.out.print(num + " ");
        }

    }
}
