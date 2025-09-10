import java.util.Queue;
import java.util.LinkedList;

/*---SAIFULLAH SIDDIQUI--- */

public class QueueD {

    //Interleave 2 halves of a Queue (even leanth);
    public static void interLeave(Queue<Integer> q) {
        int n = q.size();
        Queue<Integer> fHalf = new LinkedList<>();
        for(int i = 0 ; i < n/2 ; i++) {
            fHalf.add(q.remove());
        }
        for(int i = 0 ; i < n ; i++) {
            //push in queue alternatively 
            if (i%2 == 0) {
                q.add(fHalf.remove());
            } else {
                q.add(q.remove());
            }
        }
        
        //call to print funtion
        System.out.print("Result : ");
        printQueue(q);
    }

    //print Queue [Extra work]
    public static void printQueue(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //interleave 2 halves of a queue (even length)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1 ; i < 11 ; i++) {
            q.add(i);
        }
        //function call
        interLeave(q);
    }
}
