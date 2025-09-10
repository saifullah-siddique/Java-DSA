import java.util.*;
import java.util.LinkedList;;

public class HashMaps2 {
    static class HashMap<K,V> { //k and v are generic
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
            
        }

        private int n; //n number of nodes
        private int N; // size of hashmap array 
        private LinkedList<Node>[] buckets; //N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4 ; 
            this.buckets = new LinkedList[4];
            for(int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0 ;

            for (Node node : ll) {
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> olldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;

            for (int i = 0 ; i < N ; i++) {
                buckets[i] = new LinkedList<>();
            }

            //nodes-> add in bucket
            for(int i = 0 ; i < olldBucket.length ; i++) {
                LinkedList<Node> ll = olldBucket[i];
                for (int j = 0 ; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }

        }

        public void put(K key, V value) {
            int bi = hashFunction(key); //bucket index
            int di = searchInLL(key,bi); //data index  // valid; -1

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lamda = (double)n/N;
            if (lamda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) { //valid
                return true;
            } else { //-1
                return false;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0 ; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }
            System.out.println(keys);
            return keys;
        }

        public boolean isEmpty() {
            return n == 0 ;
        }

        public int nodes() {
            return n;
        }

        public int size() {
            return N;
        }
        
    }

    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Brazil", 300);
        hm.put("Germany", 400);
        hm.put("France", 500);
        hm.put("Italy", 600);
        hm.put("Spain", 700);
        hm.put("Japan", 800);
        hm.put("Canada", 900);
        
        hm.keySet();

        System.out.println(hm.get("India"));
        hm.remove("Us");
        hm.keySet();

        System.out.println("No. of nodes : " + hm.nodes() + " Size of map: " + hm.size());

    }
}
