class Solution {
    // \U0001f9f1 Our little block counter - remembers which character and how many we have
    static class CharCount {
        char character;  // Which letter we're tracking
        int count;       // How many in a row we've seen
        
        CharCount(char c, int count) {
            this.character = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        // \U0001f3aa Our magical stacking arena (we'll put blocks here)
        Deque<CharCount> stack = new ArrayDeque<>();

        // \U0001f504 Let's go through each character in the string
        for (char c : s.toCharArray()) {
            // \U0001f914 Check if top block matches our current character
            if (!stack.isEmpty() && stack.peek().character == c) {
                stack.peek().count++;  // Just add to the count - same color!
            } else {
                stack.push(new CharCount(c, 1));  // New color? New block!
            }
            
            // ✨ MAGIC CHECK: Do we have K identical blocks?
            if (!stack.isEmpty() && stack.peek().count == k) {
                stack.pop();  // POOF! They disappear! \U0001fa84
            }
        }

        // \U0001f3d7️ Now let's see what's left after all the magic
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            CharCount cc = stack.removeLast();  // Take from bottom (reverse order)
            // Add each character the number of times it appears
            result.append(String.valueOf(cc.character).repeat(cc.count));
        }
        
        return result.toString();  // \U0001f389 Here's our final tower!
    }
}