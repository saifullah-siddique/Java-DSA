

public class DoubleLL {
    public class Node {
        int data;
        Node next; 
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public int removeFisrt() {
        if (head == null) {
            size = 0;
            return Integer.MIN_VALUE;
        }
        
        int del = head.data;

        if (head == tail) {
            size = 0;
            head = tail = null;
            return del;
        }
        size--;
        head = head.next;
        head.prev = null;
        
        return del;
    }

    public int removeLast(){
        if (head == null) {
            size = 0;
            return Integer.MIN_VALUE;
        }

        int del = tail.data;
        if (head == tail) {
            size = 0;
            head = tail = null;
            return del;
        }

        size--;
        tail = tail.prev;
        tail.next = null;
        return del;
    }

    public void print() {
        Node temp  = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println(temp);
    }


    public void reverse() {
        if (head == null) {
            return;
        }
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }

        head = prev;   

    }


    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
      

        dll.print();
        System.out.println("Size : " + size);

        System.out.println("Removed :" + dll.removeFisrt());
        dll.print();
        System.out.println(size);

        System.out.println("Removed :" + dll.removeLast());
        dll.print();
        System.out.println(size);

        dll.reverse();
        dll.print();

    }
}
