class Pair{
    int r,c;
    Pair(int i,int j){
        this.r=i;
        this.c=j;
    }
}
class Solution {
    public boolean isSafe(int r,int c,int[][] grid){
        if(r<0 || c<0 || r>grid.length-1 || c>grid[0].length-1) return false;
        if(grid[r][c]==2 || grid[r][c]==0) return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> que=new LinkedList();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) que.add(new Pair(i,j));    
            }
        }
        int[] rowOff={-1,1,0,0};
        int[] colOff={0,0,-1,1};
        int time=0;
        while(!que.isEmpty()){
            time++;
            int siz=que.size();
            for(int k=0;k<siz;k++){
                Pair first=que.poll();
                for(int i=0;i<4;i++){
                    if(isSafe(rowOff[i]+first.r,colOff[i]+first.c,grid)){
                        que.add(new Pair(rowOff[i]+first.r,colOff[i]+first.c));
                        grid[rowOff[i]+first.r][colOff[i]+first.c]=2;
                    }
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time==0?0:time-1;
    }
}
