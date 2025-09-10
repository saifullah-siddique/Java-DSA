package BinaryTrees;
import java.util.ArrayList;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
        
    }

    //insert in a bst
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            //left sub tree
            root.left = insert(root.left, val); 
        } else {
            //right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root ,int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }

    //delete node in BST
    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        }
        else if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else { //voila

            //case 1 = leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            //case 2 = single child
            if (root.left == null ) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //case 3 = both child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <=k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void rootToLeafPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);
        path.removeLast();
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0 ; i < path.size() ; i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        } 
        else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, root) 
                && isValidBST(root.right, root, max);
    }

    public static Node mirror(Node root) {
        if (root == null) {
            return root;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node balancedBST(int arr[], int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node root = new Node(arr[mid]);
        root.left = balancedBST(arr ,si, mid-1);
        root.right = balancedBST(arr, mid+1, ei);

        return root;
    }

    //Convert Bst to Blanaced BST
    public static void inOrderSeq(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        inOrderSeq(root.left,arr);
        arr.add(root.data);
        inOrderSeq(root.right,arr);
    }

    public static Node balBST(ArrayList<Integer> arr, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node root = new Node(arr.get(mid));
        root.left = balBST(arr, si, mid-1);
        root.right = balBST(arr, mid+1, ei);

        return root;
    }

    public static Node convertBST(Node root) {
        //inorder seq
        ArrayList<Integer> arr = new ArrayList<>();
        inOrderSeq(root,arr);

        //sorted inorder -> balanced BST
        return balBST(arr, 0, arr.size()-1);
    }

    //size of largets BST in a BT
    public static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
    
        Info left = largestBST(root.left);
        Info right = largestBST(root.right);
        int size = left.size + right.size + 1;
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        if (root.data <= left.max || root.data >= right.min) {
            return new Info(false, size, min, max);
        }

        if (left.isBST && right.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String args[]) {
        //build a tree.
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int v : values) {
            root = insert(root, v);
        }
        // // System.out.print(search(root, 0));
        // //print tree
        // inOrder(root);
        // System.out.println();

        // //delete a node of bst
        // delete(root, 1);
        // inOrder(root);

        // //Print in A Range 
        // printInRange(root, 8, 14);


        // //root to leaf path
        // ArrayList<Integer> path = new ArrayList<>();
        // rootToLeafPath(root,path);

        // //Validate BST
        // if(isValidBST(root, root, root)) {
        //     System.out.println("Valid");
        // } else {
        //     System.out.println("Invalid ");
        // }

        // //mirror of a BST
        // preOrder(root);
        // System.out.println();
        // mirror(root); 
        // preOrder(root);


        // //shorted array to balanced tree
        // int arr[] = {3,5,6,8,10,11,12};
        // Node balancedTree = balancedBST(arr, 0 , arr.length-1);
        // preOrder(balancedTree);


        // //Convert BST to Blanced BST
        // Node BSTroot = new Node(8);
        // BSTroot.left = new Node (6);
        // BSTroot.left.left = new Node(5);
        // BSTroot.left.left.left = new Node(3);

        // BSTroot.right = new Node (10);
        // BSTroot.right.right = new Node (11);
        // BSTroot.right.right.right = new Node(12);

        // preOrder(BSTroot);
        // BSTroot = convertBST(BSTroot);
        // System.out.println();
        // preOrder(BSTroot);




        //Size of Largest BST in BT
        Node BTroot = new Node(50);
        BTroot.left = new Node (30);
        BTroot.left.left = new Node(5);
        BTroot.left.right = new Node(20);
        
        BTroot.right = new Node (60);
        BTroot.right.left = new Node(45);
        BTroot.right.right = new Node(70);
        BTroot.right.right.left = new Node(65);
        BTroot.right.right.right = new Node (80);

        Info info = largestBST(BTroot);
        System.out.println("Largest BST size = " + maxBST+  " " + info);
        


       


    }
}
