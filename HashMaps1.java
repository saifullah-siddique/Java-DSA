import java.util.*;

public class HashMaps1 {

    //majority elements 
    public static void majorityElemnts(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }

        for (Integer k : map.keySet()) {
            if (map.get(k) > n/3) {
                System.out.println("Key : " + k + " Freq : " + map.get(k));
            }
        }
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false ;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) +1);
        }

        for (int i  = 0 ; i < t.length() ; i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) -1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
    
    public static void main(String[] args) {
        /*//create 
        HashMap<String, Integer> hm = new HashMap<>();

        //insert
        hm.put("India", 1000);
        hm.put("China", 1500);
        hm.put("US", 50);

        System.out.println(hm);

        //get O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("Hello"));

        //containskey 
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("UK"));

        //remove O(1)
        System.out.println(hm.remove("India"));
        System.out.println(hm);

        //size 
        System.out.println(hm.size());

        // hm.clear();
        //is Empty
        System.out.println(hm.isEmpty());

        
        //iteration over HashMap 
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        //Iterate 
        Set<String> key = hm.keySet();
        System.out.println(key);

        for (String k : key) {
            System.out.println("Key=" + k + " Value=" + hm.get(k));
        }

        System.out.println();

        */


        // //linked hash map  
        // LinkedHashMap<String,Integer> Lhm = new LinkedHashMap<>();
        // Lhm.put("India", 100);
        // Lhm.put("Brazil", 300);
        // Lhm.put("Germany", 400);
        // Lhm.put("France", 500);
        // Lhm.put("Italy", 600);
        // Lhm.put("Spain", 700);
        // Lhm.put("Japan", 800);
        // Lhm.put("Canada", 900);

        // System.out.println(Lhm);

        //tree map O(log n ) // sorted 
        /*
        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("Brazil", 300);
        tm.put("Germany", 400);
        tm.put("France", 500);
        tm.put("Italy", 600);
        tm.put("Spain", 700);
        tm.put("Japan", 800);
        tm.put("Canada", 900);
      
        System.out.println(tm);
        */

        // //Majority Element
        // int nums[] = {1,3, 2, 5, 1, 3, 1, 5, 1};
        // majorityElemnts(nums);


        // Valid Anargams
        String s = "race";
        String t = "cere";
        System.out.println(isAnagram(s, t));

  
    }
}
