import java.util.*;
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];

        for (int i = 0; i < n; i++) {
            startTime[i] = flowers[i][0];
            endTime[i] = flowers[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int person = people[i];
            int upperBound = upperBound(startTime, person);
            int lowerBound = lowerBound(endTime, person);
            ans[i] = upperBound - lowerBound;
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
