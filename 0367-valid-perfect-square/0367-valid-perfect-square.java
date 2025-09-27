class Solution {
    public boolean isPerfectSquare(int num) {
     
      int low=1, high= num;
      while(low<= high){
         int mid= (low + high)/2;
        if((long)mid* mid== num) return true;// found perfect square
        else if((long)mid* mid > num) high= mid-1;// too large → go left
        else  low= mid +1;  // too small → go right
      }
      return false;  // not a perfect square
    }
}