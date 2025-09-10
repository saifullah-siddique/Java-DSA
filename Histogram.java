import java.util.Stack;
     
/*-----SAIFULLAH SIDDIQUI----- */
public class Histogram {

    public static void print(int arr[]) {
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }  
        System.out.println();
    }

    public static void histogram(int arr[]) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int nSR[] = new int[n]; //next Smallest right
        int nSL[] = new int[n]; //next Smallest left

        //Calculate next Smallest right
        for(int i = n-1 ; i >= 0 ; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nSR[i] = n;
            } else {
                nSR[i] = s.peek();
            }  
            s.push(i);
        }

        //Calculate next Smallest left
        s = new Stack<>();
        for(int i = 0 ; i  < n ; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nSL[i] = -1;
            } else {
                nSL[i] = s.peek();
            }
            s.push(i);
        }

        System.out.print("Next Smallest right = ");
        print(nSR);
        System.out.print("Next Smallest left = ");
        print(nSL);

        //calculate max area 
        int maxArea = 0 ;
        for(int i = 0 ; i < arr.length ; i++) {
            int width = nSR[i] - nSL[i] - 1;
            int currArea = arr[i] * width ; 
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("Max Area in Histogram is = " + maxArea);

    }
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        histogram(heights);
    }
}