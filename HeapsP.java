// import java.util.Comparator;
// import java.util.PriorityQueue;

// public class HeapsP {
//     static class Student implements Comparable<Student> {
//         String name;
//         int rank;

//         public Student(String name, int rank) {
//             this.name = name;
//             this.rank = rank;
//         }

//         @Override
//         public int compareTo(Student s2) {
//             return this.rank - s2.rank;
//         }
        
//     }
//     public static void main(String[] args) {
//         PriorityQueue<Student> pq = new PriorityQueue<>();
        
//         pq.add(new Student("saif", 2)); //lOg(logn)
//         pq.add(new Student("zeeshan", 2));
//         pq.add(new Student("kaif", 6));
//         pq.add(new Student("rauf", 3));
//         pq.add(new Student("Sharik", 7));

//         while (!pq.isEmpty()) {
//             System.out.println(pq.peek().name + " Rank " + pq.peek().rank); //O(1)
//             pq.remove(); //lOg(logn)
//         }
//     }
// }

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HeapsP {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            //add at last idx
            arr.add(data);

            int x = arr.size()-1;
            int parent = (x-1)/2; 

            while (arr.get(x) < arr.get(parent)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
                x = parent;
                parent = (x-1) / 2 ;
            }

        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;

            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);
            
            arr.set(0, arr.get(arr.size()-1));

            arr.remove(arr.size()-1);

            heapify(0);
            return data;

        }

        public void print() {
            for(int i = 0 ; i < arr.size() ; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        //heap sort

        public static void heapify(int arr[], int i , int size) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            
            int maxIdx = i;

            if (left < size && arr[left] > arr[maxIdx]) {
                maxIdx = left;
            }

            if (right < size && arr[right] > arr[maxIdx]) {
                maxIdx = right;
            }

            if (maxIdx != i) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;

                heapify(arr, maxIdx, size);
            }
        }

        public static void heapSort(int arr[]) {
            //build max heap
            int n = arr.length;
            for (int i = n/2 ; i >= 0 ; i--) {
                heapify(arr,i,n);
            }

            //step2 - push largest in the last
            for (int i = n-1 ; i >= 0 ; i--) {
                //swap first with last
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, 0, i);
            }
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;

        Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }  
        
    }

    static class Row implements Comparable<Row>{
        int soldier;
        int idx;
        
        Row(int soldier, int idx) {
            this.soldier = soldier;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldier == r2.soldier) {
                return this.idx - r2.idx;
            } 
            return this.soldier - r2.soldier;
        }
    }

    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val , int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
        
    }

    public static void main(String[] args) {
        /*
        Heap h = new Heap();

        h.add(4); //add 
        h.add(4);
        h.add(1);
        h.add(3);
        h.add(2);
        h.add(6);
        h.add(7);

        // System.out.println("Peek Node is : " + h.peek());

        // h.print(); //print all 

        // //remove in heap 
        // while (!h.isEmpty()) {
        //     System.out.println(h.peek());
        //     h.remove();
        // }

        // //heapSort 
        // int arr[] = {1,2,4,5,3};
        // Heap.heapSort(arr);
        // for(int i = 0 ; i < arr.length ; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        */

        //near by cars problem
        /*
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> cars = new PriorityQueue<>();
        for (int i = 0 ; i < pts.length ; i++) {
            int x = pts[i][0] , y = pts[i][1];
            int distSq =  x*x + y*y;
            cars.add(new Point(x,y,distSq,i));
        }

        //nearest k cars 
        for(int i = 0 ; i < k ; i++) {
            System.out.println("C" + cars.remove().idx);
        }
        */

        //connect N ropes
        /*
        int ropes[] = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < ropes.length ; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0 ;
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost +=  min1 + min2;
            pq.add( min1 + min2);
        }
        
        System.out.println("Cost of N ropes = " + cost);
        */
        
        //Weakest Soldier
        /*
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};
        int k = 2; 
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0 ; i < army.length ; i++) {
            int soldiers = 0 ;
            for(int j = 0  ; j < army[i].length ; j++) {
                soldiers += army[i][j];
            }
            pq.add(new Row(soldiers, i));
        }

        for (int i = 0 ; i < k ; i++) {
            System.out.println( "Row" + pq.remove().idx);
        }
        */
        
        
        //Sliding Window Maximum
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int res[] = new int[arr.length-k+1];
          
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //1st Window
        for (int i = 0; i < k ; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for (int i = k ; i < arr.length ; i++ ) {
            while (pq.size() > 0 && pq.peek().idx <= (i-k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        //print result
        for (int i = 0 ; i < res.length ; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
 