package medium;

import java.util.*;
import java.util.regex.*;
import java.security.*;

public class MD5 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String str;
        boolean result = false;
        
        while(sc.hasNext()) {
            str = sc.nextLine().trim();
            result = Pattern.matches("^[a-zA-Z0-9]+$", str);
            
            if(result) {
               try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(str.getBytes());
                byte[] digest = md.digest();
                
                for(byte b: digest) {
                    System.out.printf("%02x", b);
                }
                System.out.println();
               }
               catch(Exception e) {
                
               }
            }
        }
    }
}