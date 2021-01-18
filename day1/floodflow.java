/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

*/



class Solution {
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m=image.length;
        n=image[0].length;
        int color=image[sr][sc];
        dfs(image,sr,sc,newColor,color);
        return image;
    }
    public boolean issafe(int[][] img,int s,int e,int nc,int color){
        if(s<0 || e<0 || s>m-1 || e>n-1) return false;
        if(img[s][e]!=color || img[s][e]==nc) return false;
        return true;
    }
    public void dfs(int[][] img,int s,int e,int nc,int color){
        if (issafe(img,s,e,nc,color)){
            img[s][e]=nc;
            int[] rOff={0,0,-1,1};
            int[] cOff={-1,1,0,0};
            for(int i=0;i<4;i++){
                dfs(img,s+rOff[i],e+cOff[i],nc,color);
            }
        }
            
        
    }
    
    
}
