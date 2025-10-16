class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image[sr][sc];
        if(m==color)
        {
            return image;
        }
        dfs(image,m,color,sr,sc);
        return image;
    }
    public static void dfs(int[][] image, int m, int color,int r,int c)
    {
        if(r<0||c<0||r>=image.length||c>=image[0].length||image[r][c]!=m){
            return;
        }
        image[r][c]=color;
        dfs(image,m,color,r,c+1);
        dfs(image,m,color,r,c-1);
        dfs(image,m,color,r+1,c);
        dfs(image,m,color,r-1,c);
    }
}