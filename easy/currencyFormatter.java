package easy;

import java.util.*;
import java.text.*;

public class currencyFormatter {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US: " + usFormat.format(payment));
        Locale indiaLocale = new Locale("en","IN");
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(indiaLocale);
        System.out.println("India: " + indiaFormat.format(payment));
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("China: " + chinaFormat.format(payment));
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("France: " + franceFormat.format(payment));
    }
}