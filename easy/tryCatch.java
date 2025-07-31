package easy;

import java.util.*;

public class tryCatch {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        try {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x >=0 && y >= 0) {
                System.out.println(x/y);
            }
        } catch(InputMismatchException ee) {
            System.out.println("java.util.InputMismatchException");
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}