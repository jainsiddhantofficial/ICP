class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1, max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i])
                ans++;
            else {
                max = Math.max(max, ans);
                ans = 1;
            }
        }
        return Math.max(max, ans);
    }
}