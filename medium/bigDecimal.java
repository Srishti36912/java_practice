package medium;

import java.math.BigDecimal;
import java.util.*;

class bigDecimal{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        String[] sortedStr = Arrays.stream(s).filter(Objects:: nonNull)
       .sorted((a, b) -> (new BigDecimal(b))
        .compareTo(new BigDecimal(a))).toArray(String[]::new);
        
        for(int i=0; i<n; i++) {
            s[i] = sortedStr[i];
        }
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}