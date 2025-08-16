package easy;

import java.util.*;

public class stringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        // Write your code here.
        if(s.isEmpty()) {
            System.out.println(0);
            return;
        }
        
        String[] word = s.split("[ !,?._'@]+");
        System.out.println(word.length);
        
        for(int i=0; i<word.length; i++) {
            System.out.println(word[i]);
        }
        
        scan.close();
    }
}