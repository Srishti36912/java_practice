package easy;

class Singleton{
    private static Singleton obj;
    
    private Singleton() {
        
    }
    public String str;
    public static Singleton getSingleInstance() {
        if(obj == null) {
             obj = new Singleton();
        }
        return obj;
    }
}

public class singletonPattern {
    
}