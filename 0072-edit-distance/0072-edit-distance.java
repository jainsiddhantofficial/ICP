class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()][word2.length()];
        return helper(word1, word2, 0, 0,dp);
    }

    private static int helper(String word1,String word2,int i,int j,int[][] dp){
        int ans=0;
        if(i==word1.length())
        {
            return word2.length()-j;
        } 
        if(j==word2.length())
        {
            return word1.length()-i;
        }
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        if (word1.charAt(i)==word2.charAt(j))
        {
            ans=helper(word1,word2,i+1,j+1,dp);
        }
        else{
        int insert = 1+helper(word1,word2,i,j+1,dp);
        int delete = 1+helper(word1,word2,i+1,j,dp);
        int replace = 1+helper(word1,word2,i+1,j+1,dp);

        ans=Math.min(insert,Math.min(delete,replace));
        }
        return dp[i][j]=ans;
    }
}
