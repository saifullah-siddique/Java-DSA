import java.util.*;
import java.util.LinkedList;

public class QueueB {
    /*---SAIFULLAH SIDDIQUI--- */
    // static class Node {
    //     // int data; 
    //     // Node next;

    //     // Node(int data) {
    //     //     this.data = data;
    //     //     this.next = null;
    //     // }
    // }

    // static class Queue {

    //     static Node head = null;
    //     static Node tail = null;


    //     //check if empty
    //     public static boolean isEmpty() {
    //         return head == null && tail == null;
    //     }

    //     //add funtion with time complexity of O(1)
    //     public static void add(int data) {
    //         Node newNode = new Node(data);
    //         if(isEmpty()) {
    //             head = tail = newNode;
    //             return;
    //         }
    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     //remove funtion with time complexity of O(1)
    //     public static int remove() {
    //         if (isEmpty()) {
    //             System.out.println("Queue is Empty");
    //             return -1;
    //         }
    //         int val = head.data;
    //         if (tail == head) {
    //             head = tail = null;
    //         } else {
    //             head = head.next;
    //         }
    //         return val;
    //     }

    //     //return peek(first in element)
    //     public static int peek() {
    //         if (isEmpty()) {
    //             System.out.println("Queue is Empty!");
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    /*
    // Queue using two stack  Method 1 push O(n)
    public static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }


        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.peek();
        }
    }
    */

    /*
    //Queue using two stack method with pop(n)
    public static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            s1.push(data);
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int del = s2.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return del;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int peek = s2.peek();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return peek;
        }
    }
    */

    /*
    //Stack using 2 queues method 1 add/puch O(n)
    public static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (q1.isEmpty()) {
                q1.add(data);
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            } else  {
                q2.add(data);
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
            }
        }


        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            if (q1.isEmpty()) {
                return q2.remove();
            } else {
                return q1.remove();
            }
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            if (q1.isEmpty()) {
                return q2.peek();
            } else {
                return q1.peek();
            }
        }
        
    }
    */

    /*
    //stack using 2 Queues methdo 2 pop/remove(n)
    public static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1; 
            }
            int top = -1; 
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }

            return top; 

        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1; 
            }
            int peek = -1; 
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    peek = q1.remove();
                    q2.add(peek);
                }
            } else {
                while (!q2.isEmpty()) {
                    peek = q2.remove();
                    q1.add(peek);
                }
            }
            return peek;

        }
    }
    */
       

    //first NON reapeating letter in a Stream 
    public static void nonRepeat(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a'] += 1;
            while (!q.isEmpty() && freq[q.peek() -'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }


    //Interleave 2 halves of a Queue (even leanth);
    public static void interLeave(Queue<Integer> q) {
        int n = q.size();
        Queue<Integer> first = new LinkedList<>();
        for(int i = 0 ; i < n/2 ; i++) {
            first.add(q.remove());
        }
        while(!first.isEmpty()) {
            q.add(first.remove());
            q.add(q.remove());
        }
        
        System.out.println(q);
    }

    
    //Queue Reversal
    /*
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> s = new Stack<>();
        while (!queue.isEmpty()) {
            s.push(queue.remove());
        }
        while (!s.isEmpty()) {
            queue.add(s.pop());
        }
    }
    */
    
    public static void printQueue(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    //Stack using Deque
    public static class Stack {
        private static Deque<Integer> d = new LinkedList<>();

        public static boolean isEmpty() {
            return d.isEmpty();
        }

        public static void push(int data) {
            d.addLast(data);
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return d.removeLast();
        }
        
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return d.getLast();
        }
    }

    // Queue Usin Deque
    public static class QueueC {
        private static Deque<Integer> d = new LinkedList<>();

        public static boolean isEmpty() {
            return d.isEmpty();
        }

        public static void add(int data) {
            d.addLast(data);
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return d.removeFirst();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return d.getFirst();
        }
        
    } 

    public static void main(String[] args) {
        // Queue<Integer> q = new ArrayDeque<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);


        // q.remove();
        // q.add(5);
        // q.remove();
        // q.add(6);

        // while (!q.isEmpty()) {
        //     System.out.print(q.peek() + " ");
        //     q.remove();
        // }


        //implementation of queue using two stack
        /*
        //queue using 2 stack 
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);


        q.remove();
        q.add(5);
        q.remove();
        q.add(6);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }

        q.add(45);
        q.remove();
        q.add(43);
        System.out.println(q.peek());
        */
        


        //Implemen tation of Stack using 2 queue
        /*
        Stack s = new Stack();
        s.push(12);
        s.push(9);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
         */
    
        /*
        //First non repeating Letter in a stream of charecters.
        String str = "aabccxb";
        nonRepeat(str);
        */


        //interleave 2 halves of a queue (even length)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1 ; i < 11 ; i++) {
            q.add(i);
        }
        // interLeave(q);


        // //reverse a Queue
        // reverseQueue(q);
        // printQueue(q);

        

        // //deque
        // Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(2);
        // deque.addFirst(3);
        // deque.addLast(1);
        // System.out.println(deque);


        //Stack and quque using Deque 
        /*
        Stack s = new    Stack();
        s.push(4);
        s.push(6);
        s.push(2);
        
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        System.out.println();
        QueueC list = new QueueC();
        list.add(2);
        list.add(3);
        list.add(1);

        while (!list.isEmpty()) {
            System.out.println(list.remove());
        }

        */


    }
}

 