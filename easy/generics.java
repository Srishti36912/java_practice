package easy;

public class generics {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int arr[] = {1,2,3};
        String s[] = {"Hello", "World"};
        printArray(arr, s);
        
    }
    public static void printArray(int arr[], String s[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
        for(int i=0; i<s.length; i++) {
            System.out.println(s[i]);
        }
    }
}