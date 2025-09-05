package medium;

import java.util.*;

class stack {
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {
            String input=sc.nextLine();
            //Complete the code
            boolean isBalance = isBalanced(input);
            System.out.println(isBalance);
            
        }
    }
    public static boolean isBalanced(String input) {
        Stack<Character> st = new Stack<>();
        
        for(char ch: input.toCharArray()) {
            if(ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            }
            else if(ch == '}' || ch == ']' || ch == ')') {
                if(st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                
                if((ch == '}' && top != '{') || (ch == ']' && top != '[') 
                || (ch == ')' && top != '(')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }	
}