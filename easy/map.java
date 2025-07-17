package easy;

import java.util.*;

class map{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
        HashMap<String, String> phoneNumber = new HashMap<>();
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			String phone=in.nextLine();
			phoneNumber.put(name, phone);    
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
            if(phoneNumber.containsKey(s)) {
                System.out.println(s + "=" + phoneNumber.get(s));
            }
            else {
                System.out.println("Not found");
            }
		}
	}
}