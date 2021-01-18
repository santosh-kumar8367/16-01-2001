import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution
{
    int source,dest;
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        boolean[][] visited=new boolean[grid.length][grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return dfs(grid,i,j,visited);
                }
            }
        }
        return false;
    }
    public boolean issafe(int[][] gd,int s,int e){
        if(s<0 || e<0 || s>gd.length-1 || e>gd.length-1) return false;
        if( gd[s][e]==0) return false;
        return true;
    }
    public boolean dfs(int[][] grid,int s,int d,boolean[][] visited){
        if(issafe(grid,s,d) && visited[s][d]==false){
            if(grid[s][d]==2) return true;
            boolean path=false;
            int[] rOF={0,0,-1,1};
            int[] cOF={-1,1,0,0};
            for(int i=0;i<4;i++){
                visited[s][d]=true;
                path=dfs(grid,rOF[i]+s,d+cOF[i],visited);
                if(path) return true;
            }
        }
        return false;
    }
}
