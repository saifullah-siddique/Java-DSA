// import java.util.*;

public class shorting {

    public static void printArr(int arr[]){
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }


    // public static void bubbleShort(int arr[]) {
    //     int count = 0;
    //     for(int i = 0 ; i < arr.length-1 ; i++) {
    //         for (int j = 0 ; j < arr.length-1-i ; j++) {
    //             if (arr[j] > arr[j+1]) {
    //                 int temp = arr[j];
    //                 arr[j] = arr[j+1];
    //                 arr[j+1] = temp;
    //                 count++;
    //             }

    //         }
    //     }

    //     System.out.println(count);

    // }

    // public static void selectionShort(int arr[]) {
    //     for(int i = 0 ; i < arr.length-1 ; i++) {
    //         int minPos = i;
    //         for (int j = i+1 ; j < arr.length ; j++) {
    //             if (arr[minPos] < arr[j]){
    //                 minPos = j;
    //             } 

    //         }
    //         int temp = arr[minPos];
    //         arr[minPos] = arr[i];
    //         arr[i] = temp;
    //     }
    // }

    public static void insertionShort(int arr[]) {
        for (int i = 1 ; i < arr.length ; i++) {
            int current = arr[i];
            int prev = i-1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = current;
        }
    }

    // public static void countSort(int arr[]) {
    //     int range = Integer.MIN_VALUE;
    //     for(int i = 0 ; i <arr.length ; i++) {
    //         range = Math.max(range, arr[i]);
    //     }

    //     int countArray[] = new int[range+1];

    //     for(int i = 0 ; i < arr.length ; i++) {
    //         countArray[arr[i]]++;
    //     }

    //     int j = 0;
    //     for(int i = 0 ; i <countArray.length ; i++) {
    //         while(countArray[i] > 0) {
    //             arr[j] = i;
    //             j++;
    //             countArray[i]--;
    //         }
    //     }
    // }


    //Bubble Sort
    public static void bubbleSort(int arr[]) {
        int swap = 0;
        for(int i = 1 ; i < arr.length ; i++) {
            for(int j = 0 ; j < arr.length-i ; j++) {
                if(arr[j] < arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap++;
                }
            }
        }
        System.out.println("Total Swap Count : " + swap);
    }

    //Selection Sort
    public static void selectionSort(int arr[]) {
        int swap = 0;
        for(int i = 0  ; i < arr.length-1 ; i++) {
            int minPos = i ;
            for(int j = i+1 ; j < arr.length ; j++) {
                if(arr[minPos] < arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
            swap++;
        }

        System.out.println("Total Swap Count : " + swap);
    }

    //insertion Sort
    public static void insertionSort(int arr[]) {
        for(int i = 1 ; i < arr.length ; i++) {
            int current = arr[i];
            int prev = i-1;
            while (prev >= 0 && arr[prev] < current) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = current;
        }
    }

    //counting Sort
    public static void countingSort(int arr[]) {
        int range = Integer.MIN_VALUE;
        for (int i = 0  ; i < arr.length ; i++) {
            range = Math.max(range, arr[i]);
        }
        int count[] = new int[range+1];

        for(int i = 0 ; i <arr.length ; i++) {
            count[arr[i]]++;
        }

        int j = 0;
        for(int i = count.length-1 ; i >=0 ; i--) {
            while (count[i] > 0) {
                arr[j] = i;
                count[i]--;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        //bubble short
        // Integer arr[] = {5,1,4,1,3,2};
        // insertionShort(bubble);
        // Arrays.sort(arr,Collections.reverseOrder());

        // int countshorting[] = {5,1,4,1,3,2};
        // countSort(countshorting);
        // printArr(countshorting);


        // /*-------------------Practice Set-------------- */
        // int prac[] = {3,6,2,1,8,7,4,5,3,1};
        // // bubbleSort(prac);
        // insertionShort(prac);
        // printArr(prac);
       

    }


}
