
public class LinkedList{

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        //create new Node
        Node newNode = new Node(data);
        size++;
        //if null 
        if(head == null) {
            head = tail = newNode;
            return;
        }

        //Storing refrec of  head
        newNode.next = head;

        // change head to newnode
        head = newNode;
    }

    public void addLast(int Data) {
        Node newNode = new Node(Data);
        size++;
        if (head == null ) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        if (temp == null) {
            System.out.println(temp);
            return;
        }
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp);

        System.out.println();
    }

    public void add(int index, int data) {
        if (index == 0 ) {
            addFirst(data);
            return;
        }
        Node temp = head;
        Node newNode = new Node(data);
        size++;
        int i = 0; 
        while (i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    //remove 1st
    public int  removeFirst() {
        if (size == 0 ) {
            System.out.println("Linked List Is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val  = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //remove last 
    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked List Is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size  = 0 ;
            return val;
        }
        Node prev = head;
        for(int i = 0 ; i < size-2 ; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    //itr seacrh 
    public int  search(int key) {
        Node temp = head;
        for (int i = 0 ; temp != null ; i++ ) {
            if (temp.data == key) {
                return i ;
            }
            temp = temp.next;
        }

        return -1;
    }

    //search using recursion 
    public int helper(int key , Node head) {
        if(head == null) {
            return -1;
        } else if(head.data == key) {
            return 0;
        }
        int idx = helper(key, head.next); 

        if (idx == -1) {
            return idx;
        }     
        return idx + 1;
        
    }

    // search in linked list 
    public int recSearch(int key) {
        return helper(key, head);
    }


    //reverse a linked list (iterative approachh)
    public void irtReverse() {
        Node  prev = null;
        Node current = tail = head;
        Node Next;
        
        
        while (current != null) {
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;   
        }

        head  = prev;
       
    }

    // find and remove nth node from ENd 
    public void removeN(int n) {
        Node temp = head;
        int len = 0 ;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        if (n == len) {
            head = head.next;
            return;
        }
       
        Node prev = head;
        for(int i = 1 ; i < size-n ; i++ ) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
    }

    //check if  given linked list is pelindrome or not 
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head; 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPelindrome() {
        Node left = head;
        Node mid = findMid(head);

        Node prev = null;
        Node current = mid;
        Node Next; 

        while (current != null) {
            Next = current.next;
            current.next = prev;
            prev = current; 
            current = Next;
        }

        Node right = prev;
      
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }



    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        // ll.add(2, 3);
        ll.print();
        // System.out.println(size);
        // System.out.println(ll.removeFirst());
        // ll.print();
        // System.out.println(ll.removeLast());
        // ll.print();
        // System.out.println(size);
        // System.out.println(ll.search(5));
        // System.out.println(ll.recSearch(6));
        // ll.irtReverse();
        // ll.print();

        // // find and remove nth node from ENd 
        // ll.removeN(5);
        // ll.print();


        // //check if a linked list is a pelindrom or not 
        // System.out.println(ll.isPelindrome());
        
    }
 }