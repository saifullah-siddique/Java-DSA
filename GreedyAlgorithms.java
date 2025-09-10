import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GreedyAlgorithms {

    //ACtivity selection problem 
    public static void select(int start[], int end[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int maxWork = 1 ;
        ans.add(0);
        int lastEnd = end[0];
        for(int i = 1 ; i < start.length ; i++) {
            if (start[i] >= lastEnd) {
                maxWork++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        
        System.out.println("MAx Activity Can be performbed = " + maxWork);
        for(int i = 0 ; i < ans.size() ; i++) {
            System.out.print("A"+ans.get(i) + " ");
        }  
    }

    public static void startSelect(int start[], int end[]) {
        int activities[][] = new int[start.length][3];
        for(int i = 0 ; i  < start.length ; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }  //sorting 2d array acording to their end time;
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        
        //actual work  
        ArrayList<Integer> ans = new ArrayList<>();
        int maxWork = 1 ;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for(int i = 1 ; i < start.length ; i++) {
            if (activities[i][1] >= lastEnd) {
                maxWork++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        
        System.out.println("MAx Activity Can be performbed = " + maxWork);
        for(int i = 0 ; i < ans.size() ; i++) {
            System.out.print("A"+ans.get(i) + " ");
        }  
    }


    //faractional Knapsack
    public static void kNapsack(int weight[], int value[], int w) {
        
        double ratio[][] = new double[weight.length][2];
        for(int i = 0 ; i < ratio.length ; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int totalVal = 0 ;
        for(int i = ratio.length -1 ; i >= 0 ; i--) {
            int idx = (int)ratio[i][0];
            if (weight[idx] <= capacity) {
                totalVal += value[idx];
                capacity -= weight[idx];
            } else {
                totalVal += ratio[i][1] * capacity;
                break;
            }

        }
        System.out.println(totalVal); 
    }

    //minimum sum absolute diffrence pairs 
    public static void absDiffPairs(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);

        int minAbsDiff = 0 ;
        for(int i = 0 ; i < A.length ; i++) {
            int diff = A[i] - B[i];
            minAbsDiff += Math.abs(diff);
        }

        System.out.println(minAbsDiff);
    }

    //maximum length chain of pair
    public static void maxLenChain(int pairs[][]) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1 ;
        int pairEnd = pairs[0][1];
        for(int i = 1 ; i < pairs.length ; i++) {
            int startLen = pairs[i][0];
            if (startLen > pairEnd) {
                chainLen++;
                pairEnd = pairs[i][1];
            }
        }

        System.out.println( chainLen);
    }

    //indian coins problems
    public static void IndianCoins(int value) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        Arrays.sort(coins,Comparator.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();
        int amount = value;
        int countOfCoin = 0;
        for(int i = 0 ; i < coins.length ; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    ans.add(coins[i]);
                    amount -= coins[i];
                    countOfCoin++;
                }
                if (amount == 0) {
                    break;
                }
            }
        }

        System.out.println("Total Used Coins : " + countOfCoin);
        for(int j = 0 ; j < ans.size() ; j++) {
            System.out.print(ans.get(j) + " ");
        }
    }

    //Job Squencing Problem
    public static void jobSquencing(int jobs[][]) {
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[2]));
        int time = 0;
        int profit = 0; 
        ArrayList<Character> ans = new ArrayList<>();
        for(int i = jobs.length-1 ; i >=0 ; i--) {
            int deadline = jobs[i][1];
            if (deadline > time) {
                ans.add((char)jobs[i][0]);
                profit += jobs[i][2];
                time++;
            }
        }

        System.out.println(profit);
        for(int i = 0 ; i <ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }

    //job sequencing didi 
    public static class  job{
        int deadline;
        int profit;
        int id;

        public job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
        
    }
    //working as main function;
    public static void JobSquencing() {
        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};

        ArrayList<job> jobs = new ArrayList<>();
        for(int i = 0 ; i < jobsInfo.length ; i++) {
           jobs.add(new job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        //Decending Order of Profit. 
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit - obj1.profit);
        
        ArrayList<Integer> seq = new ArrayList<>();   
        int time = 0;
        for(int i = 0 ; i < jobs.size(); i++) {
            job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("MAx Job = " + seq.size());
        for(int i = 0 ; i < seq.size() ; i++) {
            System.out.print((char)(65+seq.get(i)) + " ");
        }

    }

    

    public static void main(String[] args) {
        // int start[] = {1, 3, 0, 5, 8, 5};
        // int end[] = {2, 4, 6, 7, 9, 9};
        // select(start, end);

        // int start[] = {0,1,3,5,5,8};
        // int end[] = {6,2,4,7,9,9};
        // startSelect(start, end);


        //faractional Knapsack
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        kNapsack(weight, value,50);


        // //min Absolute Diffrence Pairs
        // int A[] = {4,1,8,7};
        // int B[] = {2,3,6,5};
        // absDiffPairs(A, B);

        // //maximum length chain of pairs
        // int pairs [] [] = { {5, 24},
        //                     {39, 60},
        //                     {5, 28},
        //                     {27, 40},
        //                     {50, 90}};
        // maxLenChain(pairs);

        // //Indian coins Problem
        // IndianCoins(590);

        //Job Squencing Problem 
        // int jobs[][] = {{'A',4,20},
        //                 {'B',1,10},
        //                 {'C',1,40},
        //                 {'D',1,30}};
        // jobSquencing(jobs);

        // //job Sequencing did method
        // JobSquencing();



        // //Chocola Problem 
        // Integer costVer[] = {2,1,3,1,4};
        // Integer costHor[] = {4,1,2};

        // Arrays.sort(costVer, Collections.reverseOrder());
        // Arrays.sort(costHor, Collections.reverseOrder());

        // int h = 0 , v = 0;
        // int hPeices = 1 , vPeices = 1;
        // int cost = 0 ;
        // while (h < costHor.length && v < costVer.length) {
        //     if(costVer[v] <= costHor[h]) {
        //         cost += (costHor[h] * vPeices);
        //         hPeices++;
        //         h++;
        //     } else {
        //         cost += (costVer[v] * hPeices);
        //         vPeices++;
        //         v++;
        //     }
        // }

        // while (h < costHor.length) {
        //     cost += (costHor[h] * vPeices);
        //     hPeices++;
        //     h++;
        // }

        // while (v < costVer.length) {
        //     cost += (costVer[v] * hPeices);
        //     vPeices++;
        //     v++;
        // }


        // System.out.println(cost);

    }
}
 