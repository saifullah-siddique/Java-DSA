

public class Tries {
    static class Node {
        Node children[] = new Node[26];
        boolean isEOW = false;

        Node() {
            for(int i = 0 ; i < 26 ; i++) {
                children[i] = null;
            }
        }
        
    }

    public static Node root = new Node();

    //Insert in Tries
    public static void insert(String word) { //(L)
        Node curr = root;

        for(int level = 0 ; level < word.length() ; level++) {
            int idx = word.charAt(level) - 'a' ; 
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.isEOW = true ; 
    }

    //search in tries
    public static boolean search(String word) {
        Node curr = root;

        for(int i = 0 ; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.isEOW == true;
    }

    //Words Break Problem 
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
         
        for(int i = 1 ; i <= key.length() ; i++) {
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    //Prefix Problem 
    /*    static class NODE {
        NODE children[] = new NODE[26];
        boolean isEOW = false;
        int freq;

        NODE() {
            for (int i = 0 ; i < 26 ; i++) {
                children[i] = null;
            }
            freq = 0;
        }
    }

    static NODE Root = new NODE();

    public static void Insert(String word) {
        NODE curr = Root;

        for (int i = 0 ; i < word.length() ; i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new NODE();
            }
            curr = curr.children[idx];
            curr.freq++;
        }

        curr.isEOW = true;
    }

    public static String findprefix(String word) {
        NODE curr = Root;
        for(int i = 0 ; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx].freq == 1) {
                return word.substring(0,i+1);
            }
            curr = curr.children[idx];
        }

        return null;
    }


    public static void Prefix(NODE root, String ans) {
        if (root == null) {
            return;
        }

        if (root.freq == 1) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0  ; i < root.children.length ; i++) {
            if (root.children[i] != null) {
                Prefix(root.children[i], ans+ (char)(i+'a'));
            }
        }
    }

    */

    //StartWith Problem
    public static boolean starstWith(String prefix) {
        Node curr = root;

        for(int i = 0 ; i < prefix.length() ; i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for(int i = 0 ; i < 26 ; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count +1;
    }

    //longest word with all prefix 
    static String ans = "";
    public static void longestWord(Node root, StringBuilder tempAns) {
        if (root == null) {
            return;
        }
        for (int i = 0 ; i < 26 ; i++) {
            if (root.children[i] != null && root.children[i].isEOW) {
                tempAns.append((char)(i+'a'));
                if (tempAns.length() > ans.length()) {
                    ans = tempAns.toString();
                }
                longestWord(root.children[i], tempAns);
                //backtrack
                tempAns.deleteCharAt(tempAns.length()-1);
            }
        }

    }

    public static void main(String[] args) {
        // //insert in Tries
        // String words[] = {"the" , "a" , "there" , "their" , "any" , "thee"};
        // for (String word : words) {
        //     insert(word);
        // }

        // //search in Tries
        // System.out.println(search("the"));

        // //Words Break Problem
        // String word[] = {"i", "like" , "sam" , "samsung" , "ice"};
        // for(String w : word) {
        //     insert(w);
        // }
        // String key = "ilikeice";
        // System.out.println(wordBreak(key));


        // //Prefix Problem 
        // String st[] = {"zebra", "dog", "duck", "dove"};
        // for(String s : st) {
        //     Insert(s);
        // }
        // // ArrayList<String> unique = new ArrayList<>();
        // // for(String s : st) {
        // //     unique.add(findprefix(s));
        // // }
        // Prefix(Root, "");

        // //start With Problem 
        // String words[] = { "apple", "app", "mango", "man", "woman" };
        // for (String word : words) {
        //     insert(word);
        // }
        // String prefix = "man";
        // System.out.println(starstWith(prefix));


        // //Count uniquq Substring 
        // String str = "ababa";
        // for (int i = 0 ; i < str.length() ; i++) {
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println("Total No. of Uniuqe Subtring : " + countNodes(root));


        //Longest word 
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for (String word : words) {
            insert(word);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);



    }
}
