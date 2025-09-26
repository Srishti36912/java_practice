package medium;

import java.util.*;

public class array1D {
    
    private static boolean canWin(int leap, int[] game, boolean[] visited, int pos) {
 
        if(pos >= game.length) return true;
        if(pos < 0 || game[pos] != 0 || visited[pos]) return false;
        
        visited[pos] = true;
        
        return canWin(leap, game, visited, pos-1) || 
        canWin(leap, game, visited, pos+1) || canWin(leap, game, visited, pos+leap);
    }
    
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return canWin(leap, game, new boolean[game.length], 0);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}