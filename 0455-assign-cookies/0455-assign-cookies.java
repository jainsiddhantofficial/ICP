import java.util.Arrays;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int satis=0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                satis++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return satis;
    }
}