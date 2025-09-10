public class LinkedListP2 {

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
    public static int size = 0 ;


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
        System.out.println(temp);
        System.out.println();
    }


    //Detect a Loop/ cycle in a linked list
    public boolean isCycle() {
        Node slow = head;
        Node fast = head; 

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    //remove a Loop/Cycle in LL
    public void removeCycle() {
        Node slow = head;
        Node fast = head;

        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (isCycle == false) return;

        slow = head; 
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;

    }


    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //merge sort in LL
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        //step 1 get midd
        Node mid = getMid(head);

        //step 2 break in two parst and sort 
        Node rightHead = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right =  mergeSort(rightHead);

        //step 3  merge sorted part
        return merge(left, right);
    
    }

    public Node merge(Node left , Node right) {
        Node temp = new Node(-1);
        Node mergedLL = temp;

        //step 1 comapre and merge 
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        //step 2 arrane ramiaing parts 
        if (left != null) {
            temp.next = left;
        }
        // for remaing right 
        if (right != null) {
            temp.next = right;
        }

        return mergedLL.next;
    }

    //find mid 
    public Node listMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node revList(Node node) {
        Node prev = null;
        Node current = node;
        Node Next;

        while (current != null) {
            Next = current.next;
            current.next = prev;
            prev = current;
            current = Next;
        }

        return prev;  
    }


    //convert LL in a ZigZag manner
    public void zigZag() {
        Node mid = listMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        rightHead = revList(rightHead);


        Node leftHead = head;
        Node nextLeft = null;
        Node nextRight = null;
        while (leftHead != null && rightHead != null) {
            nextLeft = leftHead.next; //store next node of left head
            leftHead.next = rightHead;
            nextRight = rightHead.next; // store next node or right head
            rightHead.next = nextLeft; 
            rightHead = nextRight;
            leftHead = nextLeft;
        }

    }


    public void ZigZag(Node head) {
        //find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //revers half
        Node current = slow.next;
        slow.next = null;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        //allternate merge 
        Node right = prev;
        Node left = head;

        while (left != null && right != null) {
            Node nextLeft = left.next; //store next node of left head
            Node nextRight = right.next; // store next node or right head
            
            left.next = right;
            right.next = nextLeft; 
           
            right = nextRight;
            left = nextLeft;
        }
    }
 

    
    public static void main(String[] args) {
        LinkedListP2 ll = new LinkedListP2();
        ll.addLast(9);
        ll.addLast(1);
        ll.addLast(6);
        ll.addLast(3);
        ll.addLast(8);
        ll.addLast(10);

        tail.next = head.next.next.next;
        // ceck there is a cycle in ll
        ll.isCycle();


        // remove cycle if found
        ll.removeCycle(); 
        ll.print(); 

        //sort ll in accending order 
        head = ll.mergeSort(head) ;
        ll.print();


        //make linked list zig-zag
        ll.zigZag();
        ll.print();

        ll.ZigZag(head);
        ll.print();

    }
}









//linked list using java collection framework
// import java.util.LinkedList;

// public class LinkedListP2 {

    

//     public static void main(String[] args) {
//         LinkedList<Integer> ll = new LinkedList<>();
//         ll.add(2);
//         ll.add(3);
//         ll.addLast(4);
//         ll.addFirst(0);
//         System.out.println(ll);
//         ll.remove(1);
//         System.out.println(ll);
//     }
// }
