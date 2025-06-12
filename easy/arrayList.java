package easy;
import java.util.*;

public class arrayList {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.*/
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = sc.nextInt();
        
        for(int i=0; i<n; i++) {
            ArrayList<Integer> newList = new ArrayList<>();
            int el = sc.nextInt();
            for(int j=0; j< el; j++) {
                newList.add(sc.nextInt());
            }
            list.add(newList);
        }
        int q = sc.nextInt();
        for(int i=0; i<q; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            if(list.get(x).size() > y) {
                System.out.println(list.get(x).get(y));
            } else {
                System.out.println("ERROR!");
            }
            
        }
    }
}
