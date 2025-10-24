class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int k = n - 2; k >= 2; k--) {
            Map<Integer, Integer> diffCount = new HashMap<>();
            for (int l = k + 1; l < n; l++) {
                int diff = nums[l] - nums[k];
                diffCount.put(diff, diffCount.getOrDefault(diff, 0) + 1);
            }

            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    int sum = nums[i] + nums[j];
                    res += diffCount.getOrDefault(sum, 0);
                }
            }
        }

        return res;
    }
}