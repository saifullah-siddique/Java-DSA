public class SegmentTrees {

    public static void printST(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int tree[];

    public static void inti(int n) {
        tree = new int[n*4];
    }
    public static int  buildST(int arr[],int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start]; 
            return arr[start];
        }

        int mid = (start + end) /2;

        int l = buildST(arr, 2*i+1, start, mid);
        int r = buildST(arr, 2*i+2, mid+1, end);

        return tree[i] = l+r;

    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if (qj <= si || qi >= sj) {
            return 0;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);

            return left + right;
        }
    }

    public static int getSum(int arr[] ,int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }
    
    public static void updateUtil(int i, int si, int sj, int diff, int idx) {
        if (idx > sj || idx < si ) {
            return;
        }

        tree[i] += diff;
        if (si != sj) {
            int mid = (si + sj) /2;
            updateUtil(2*i+1, si, mid, diff, idx);
            updateUtil(2*i+2, mid+1, sj, diff, idx);
        } 
        
    }

    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal; //O(1)
        updateUtil(0, 0, n-1, diff, idx); //O(log n)
    }

    public static void main(String[] args) {
        // int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        // int n = arr.length;
        // inti(n);
        // buildST(arr, 0, 0, n-1);

        // printST(tree);

        // System.out.println(getSum(arr, 2, 5));
        // update(arr, 2, 4);
        // System.out.println(arr[2]);
        // System.out.println(getSum(arr, 2, 5));

        MinMax.main(args);

    }
}

class MinMax {

    static int treeMax[];

    public static void init(int n) {
        treeMax = new int[n*4];
    }

    public static int buildMaxST(int arr[], int i, int si, int sj) {
        if (si == sj) {
            treeMax[i] = arr[si];
            return arr[si];
        }

        int mid = (si + sj)/2;
        buildMaxST(arr, 2*i+1, si, mid);
        buildMaxST(arr, 2*i+2, mid+1, sj);
        
        return treeMax[i] = Math.max(treeMax[2*i+1], treeMax[2*i+2]);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj <qi) {
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) {
            return treeMax[i];
        } else {
            int mid = (si + sj)/2;
            int left = getMaxUtil(2*i+1, si, mid, qi, qj);
            int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);

            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj){
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }


    public static void updateMaxUtill(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) {
            return;
        }

        treeMax[i] = Math.max(treeMax[i] , newVal);
        if (si != sj) {
            int mid = (si +sj) / 2;
            updateMaxUtill(2*i+1, si, mid, idx, newVal);
            updateMaxUtill(2*i+2, mid+1, sj, idx, newVal);
        }
    }

    public static void updateMax(int arr[], int idx, int newVal) {
        int n = arr.length;
        arr[idx] = newVal;
        updateMaxUtill(0, 0, n-1, idx, newVal);
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;
        init(n);
        buildMaxST(arr, 0, 0, n-1);

        SegmentTrees.printST(treeMax);
        System.out.println(getMax(arr, 2, 5));
        updateMax(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));
        SegmentTrees.printST(treeMax);



    }
}

