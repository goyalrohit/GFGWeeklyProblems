//Traffic Lights
//You are responsible for managing the traffic lights on a long stretch of highway. Initially, all traffic
//lights on the highway are set to red. There are n traffic lights in total. You will be given q queries,
//each of which instructs you to change the signal of a segment of the traffic lights.
//Each query specifies two indices [a , b ], indicating that all traffic lights from a to b (both inclusive) should change their signals in the following manner:

//A red light ('R') changes to yellow ('Y').
//A yellow light ('Y') changes to green ('G').
//A green light ('G') changes to red ('R').

//Return a string of length n with the final state of all n traffic lights where the i character in the
//string denotes the state of the ith traffic light after all the queries have been processed in the
//given order.

//Example 1:
//Input:
//n = 5, q= 3,
//queries = [[1,5], [1,4], [3,4]]
//Output: "GGRRY"
//Explanation:
//Initial signal of the traffic lights is all red(RRRRR). After 1st query all traffic lights signal changes to Yellow(YYYYY).
//After 2nd query the signal changes for all traffic lights from index 1 to 4. The state of traffic lights is now GGGGY.
//After 3rd query the signal changes for all traffic lights from index 3 to 4. The final state of traffic lights is now GGRRY.

public class TrafficLights {

    public static String trafficLights(int n, int q, int[][] queries) {
     // code here
        String s = "R".repeat(n);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < q; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            String str = sb.substring(a - 1, b);
            String str2 = sb.substring(a - 1, b);
            if(str.contains("R")) sb.replace(a - 1, b, str.replace("R", "Y"));
            str2 = sb.substring(a - 1, b);
            if(str.contains("Y")) sb.replace(a - 1, b, str.replace("Y", "G"));
            str2 = sb.substring(a - 1, b);
            if(str.contains("G")) sb.replace(a - 1, b, str.replace("G", "R"));
        }
        return sb.toString();
    }
    public static boolean diffString(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                return false; // Characters are the same at this position
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TrafficLights tl = new TrafficLights();
        int n = 5;
        int q = 3;
        int[][] queries = {{1, 5}, {1, 4}, {3, 4}};
        System.out.println(tl.trafficLights(n, q, queries));
    }
}
