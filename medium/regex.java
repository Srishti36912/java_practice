package medium;

import java.util.Scanner;

class regex{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

//Write your code here
class MyRegex {
    String pattern;
    MyRegex() {
        this.pattern = "^(\\d{1,2}\\.|[01]\\d{2}\\.|2[0-4]\\d\\.|25[0-5]\\.){3}(\\d{1,2}|[01]\\d{2}|2[0-4]\\d|25[0-5])$";
    }  
}