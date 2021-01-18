
  
class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public boolean issafe(char[][] grid,int i,int j){
        if(i<0 || i>m-1 || j<0 || j>n-1) return false;
        if(grid[i][j]!='1') return false;
        return true;
    }
    public void dfs(char[][] grid,int r,int c){
        if(issafe(grid,r,c)){
            grid[r][c]='2';
            int[] rows={0,0,-1,1};
            int[] cols={-1,1,0,0};
            for(int i=0;i<4;i++){
                int row=r+rows[i];
                int col=c+cols[i];
                dfs(grid,row,col);
            }
        }
    }
}

