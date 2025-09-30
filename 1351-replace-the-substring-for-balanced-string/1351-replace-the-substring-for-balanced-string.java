class Solution {
    HashMap<Character,Integer> map = new HashMap<>();
    int target;
    public int balancedString(String s) {
        target = s.length()/4;
        int minLength = s.length();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        if(isBalanced())
        {
            return 0;
        } 
        int start=0; int end =0;
        for(;end<s.length(); end++){
            char removeChar = s.charAt(end);
            map.put(removeChar, map.getOrDefault(removeChar,0)-1);

            while(start<=end && isBalanced()){
                minLength = Math.min(minLength, end-start+1);

                char addChar = s.charAt(start);
                map.put(addChar, map.getOrDefault(addChar,0)+1);
                start++;
            }
        }

        return minLength;
    }

    public boolean isBalanced(){
        for(char ch: map.keySet()){
            if(map.get(ch) > target)
               return false;
        }
        return true;
    }
}