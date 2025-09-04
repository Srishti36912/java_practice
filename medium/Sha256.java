package medium;

import java.util.*;
import java.security.*;

public class Sha256 {
    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] enc = md.digest(s.getBytes());
        StringBuilder sb = new StringBuilder();
        
        for(byte b: enc) {
            sb.append(String.format("%02x", Byte.toUnsignedInt(b)));
        }
        
        System.out.println(sb.toString());
        
    }
}