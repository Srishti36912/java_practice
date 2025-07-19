package easy;

import java.util.BitSet;
import java.util.Scanner;

public class bitSet {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet[] B = new BitSet[] {new BitSet(n), new BitSet(n) };
        
        for(int i=0; i<m; i++) {
            String s = sc.next();
            int left = sc.nextInt()- 1;
            int right = sc.nextInt() - 1;
            
            switch(s) {
                case "AND"-> B[left].and(B[right]);
                case "OR" -> B[left].or(B[right]);
                case "XOR" -> B[left].xor(B[right]);
                case "FLIP"-> B[left].flip(right + 1);
                case "SET" -> B[left].set(right + 1);
                default -> {}
            }
            System.out.print(B[0].cardinality());
            System.out.print(" ");
            System.out.print(B[1].cardinality());
            System.out.println();
        }
    }         
}
