import java.util.*;

public class Hashset1 {

    public static void unionItersection(int arr1[], int arr2[]) {
        HashSet<Integer> union = new HashSet<>();
        for(int i = 0 ; i < arr1.length ; i++) {
            union.add(arr1[i]);
        }

        HashSet<Integer> intersection = new HashSet<>();
        for (int i = 0 ; i < arr2.length ; i++) {
            if (union.contains(arr2[i])) {
                intersection.add(arr2[i]);
            } else {
                union.add(arr2[i]);
            }
        }

        System.out.println("Count : " + union.size() + " Union Element : " + union);
        System.out.println("Count : " + intersection.size() + " Intersection : " + intersection);
    }


    //find start for itinerary from tickets 
    public static String getStart(HashMap<String, String > ticket) {
        HashMap<String, String > revMap = new HashMap<>();

        for (String key : ticket.keySet()) {
            revMap.put(ticket.get(key), key);
        }

        for (String key : ticket.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;
            }
        }

        return null;

    }
    
    public static void main(String args[]) {
        // HashSet<String> set = new HashSet<>();
        // set.add("New York");
        // set.add("London");
        // set.add("Tokyo");
        // set.add("Paris");
        // set.add("London");

        // // System.out.println(set);


        // // System.out.println(set.contains(2));

        // // //iteration over sets
        // // Iterator it = set.iterator(); // using iterrator
        // // while (it.hasNext()) {
        // //     System.out.println(it.next());
        // // }

        // // System.out.println();

        // for (String value : set) { // for each loop 
        //     System.out.println(value);
        // }

        // System.out.println();

        // //Linked Hashset
        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("New York");
        // lhs.add("London");
        // lhs.add("Tokyo");
        // lhs.add("Paris");

        // for (String city : lhs) {
        //     System.out.println(city);
        // }

        // //--Count Distict  elements 
        // int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        // HashSet<Integer> set = new HashSet<>();
        // for (int i = 0 ; i < num.length ; i++ ) {
        //     set.add(num[i]);
        // }
        // System.out.println("ans = " + set.size());
 

        // //union & Intersection of 2 arrays
        // int arr1[] = {7,3,9};
        // int arr2[] = {6,3,9,2,9,4};
        // unionItersection(arr1, arr2);


        // //find Itinerary  from tickets
        // HashMap<String, String > ticket = new HashMap<>();
        // ticket.put("Chennai","Bengaluru");
        // ticket.put("Mumbai","Delhi");
        // ticket.put("Goa", "Chennai");
        // ticket.put("Delhi","Goa");

        // String start = getStart(ticket); 
        // System.out.print(start);
        // for (String key : ticket.keySet()) {
        //     System.out.print("->" + ticket.get(start));
        //     start = ticket.get(start);
        // }

        // //largest sub array whith 0 sum
        int arr[] = {15,-2,2,-8,1,7,10,2,3};
        HashMap<Integer, Integer> mapZeroSum = new HashMap<>();

        int sumZeroSum = 0 ; 
        int len = 0 ; 
        for (int j = 0 ; j < arr.length ; j++) {
            sumZeroSum += arr[j];
            if (mapZeroSum.containsKey(sumZeroSum)) {
                len = Math.max(len, j - mapZeroSum.get(sumZeroSum));
            } else {
                mapZeroSum.put(sumZeroSum, j);
            }
        }

        // System.out.println(len);

        //Subarry sum equal to k 
        int array[] = {10,2,-2,-20,10};
        int k = -10 ;

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int ans = 0;
        map.put(0, 1);
        for (int j = 0 ; j < array.length ; j++) {
            sum += array[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum-k);
            } 
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        System.out.println("Total subarray: "+ans);
    }
}
