package easy;

import java.util.*;

public class hashSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        //Write your code here
        HashSet<String> pairs = new HashSet<>();

        for(int i=0; i<t; i++) {
            String str = pair_left[i] + " " + pair_right[i];
            String rev = pair_right[i] + " " + pair_left[i];
            
            if(!pairs.contains(rev)) {
                pairs.add(str);
            }
            System.out.println(pairs.size());
        }

    }
}