public class palindrome {
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

    public void addFirst(int data) {
        //create new Node
        Node newNode = new Node(data);
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
        int i = 0; 
        while (i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

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

    public Node reverse(Node mid) {
        findMid(mid);
        Node prev = null;
        Node current = mid;
        Node Next; 

        while (current != null) {
            Next = current.next;
            current.next = prev;
            prev = current; 
            current = Next;
        }

        return prev;

    }

    public boolean isPelindrome() {
        Node lp = head;
        Node mid = findMid(head);
        Node rp = reverse(mid);
        while (rp != null) {
            if (lp.data != rp.data) {
                return false;
            }
            lp = lp.next;
            rp = rp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.print();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        // ll.add(2, 3);
        ll.print();

        //check if a linked list is a pelindrom or not 
        System.out.println(ll.isPelindrome());

    }

}
