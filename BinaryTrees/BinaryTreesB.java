package BinaryTrees;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTreesB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        //pre order traversal
        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");

            preOrder(root.left);
            preOrder(root.right);
        }

        //inOrder traversal
        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        //post order traversal
        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        //level order traversal 
        /*
        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(currNode);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
                
            }

        }
        */

        //count height
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            return 1 + Math.max(left, right);
        }

        //count no of nodes
        public static int countNode(Node root) {
            if (root == null) {
                return 0;
            }

            int left = countNode(root.left);
            int right = countNode(root.right);

            return left + right + 1;
        }
        
        //sum of nodes
        public static int sumNode(Node root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sumNode(root.left);
            int rightSum = sumNode(root.right);
            return root.data + leftSum + rightSum;
        }

        //diameter of a tree O(n^2)
        /* */
        public static int diameter(Node root) {
            if (root == null) {
                return 0;
            }
            int leftDiam = diameter(root.left);
            int leftHT = height(root.left);
            int rightDiam = diameter(root.right);
            int rightHT = diameter(root.right);

            int selfDiam = leftHT + rightHT + 1;

            return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
        }

        //diameter of a tree O(n) using height
        /*
        static class Info {
            int diam;
            int ht;

            Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }

        public Info Diameter(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = Diameter(root.left);
            Info rigtInfo = Diameter(root.right);

            int diam = Math.max( Math.max(leftInfo.diam, rigtInfo.diam) , leftInfo.ht + rigtInfo.ht +1);
            int ht = Math.max(leftInfo.ht, rigtInfo.ht) + 1 ;

            return new Info(diam, ht);

        }
        */
    }
    

    // Check if a binary tree is a subtree of another binary tree
    /*
    public static boolean isIdentical(Node root, Node subroot) {
        if(root == null && subroot == null) {
            return true;
        } else if (root == null || subroot == null || root.data != subroot.data) {
            return false;
        }

        if (!isIdentical(root.left, subroot.left)) {
            return false;
        }

        if (!isIdentical(root.right, subroot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subroot) {
        if (root == null) {
            return false;
        }

        if (root.data == subroot.data) {
            if (isIdentical(root,subroot)) {
                return true;
            }
        }

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }
    */


    // Top view of binary tree
    static class Info {
        Node node;
        int hd; // horizontal distance

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        //leverl order traversal
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0 , max = 0 ; 
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
                
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }

                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for (int i = min ; i <= max ; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    //K-th level of a Tree 
    public static void kthLevel(Node root, int k) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1; 
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty() || level > k) {
                    break;
                } else {
                    q.add(null);
                    level++;
                }
            } else {
                if (level == k) {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    //K-th level of tree recursive way 
    public static void kLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
    }

    //lowest comman ancestors  //O(n) sc = O(n);
    public static boolean getPath(Node root, int n , ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean leftFound = getPath(root.left, n, path);
        boolean rightFound = getPath(root.right, n, path);

        if (rightFound || leftFound) {
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }

    public static Node commanAncestor(Node root, int n1 , int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1, path1);
        getPath(root,n2, path2);

        int i;
        for (i = 0 ; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lc = path1.get(i-1);
        return lc;
    }

    //lowest comman ancestor without axuallary space 
    public static Node cAncestors(Node root , int n1 , int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = cAncestors(root.left, n1, n2);
        Node rigthLCA = cAncestors(root.right, n1, n2);

        if (rigthLCA == null) {
            return leftLCA;
        }

        if (leftLCA == null) {
            return rigthLCA;
        }

        return root;
    }


    //Minimum distance b/w two nodes 
    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        } else if (root.data == n) {
            return 0;
        }

        int leftDistance = lcaDist(root.left, n);
        int rightDisance = lcaDist(root.right, n);

        if (leftDistance == -1 && rightDisance == -1 ) {
            return -1; 
        } else if (rightDisance == -1) {
            return leftDistance +1;
        } else {
            return rightDisance+1;
        }
    }

    public static int minDistance(Node root, int n1 , int n2) {
        Node lca = cAncestors(root, n1, n2);
        int leftDist = lcaDist(lca, n1);
        int rightDist = lcaDist(lca, n2);

        return leftDist + rightDist;
    }

    //k-th ancestor of node
    public static int KthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        } else if (root.data == n) {
            return 0;
        }

        int leftDist = KthAncestor(root.left, n,k);
        int rightDist = KthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1 ) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max +1 == k ) {
            System.out.println(root.data);
        }

        return max+1;

    }

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        int sum = root.data + leftSum + rightSum;
        root.data = leftSum + rightSum;
      
        return sum;
    }

    public static void main(String[] args) {
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);

        // how to traverse on Binary Tree 
        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root);
       
        //Height of a Tree
        // System.out.println(tree.height(root));

        // //count node of tree
        // System.out.println(tree.countNode(root));

        // //sum of Nodes 
        // System.out.println(tree.sumNode(root));

        // //diameter of tree
        // System.out.println(tree.diameter(root));

        // //diameter approach O(n)
        // System.out.println(tree.Diameter(root).diam);

        // //subtree of another tree
        // Node subroot = new Node(2);
        // subroot.left = new Node(4);
        // subroot.right = new Node(0);

        // System.out.println(isSubtree(root, subroot));


        //top view of binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // topView(root);

        //K-th level of a tree
        // kthLevel(root, 1); //itarative
        // kLevel(root, 1, 2); //recusive

        // //Lowest comman ancestors
        // System.out.println(commanAncestor(root, 4, 5).data);

        //min Distance b/w two nodes
        // System.out.println(minDistance(root, 4, 6));

        // //kth Ancestor of Node
        // KthAncestor(root, 5, 2) ;

        //transform tp Sum tree
        transform(root);
        BinaryTree.preOrder(root);

        

    }
}
  