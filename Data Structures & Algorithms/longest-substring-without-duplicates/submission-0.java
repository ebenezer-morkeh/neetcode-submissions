class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet();

        int i = 0;
        int j = 0;
        int longSub = 0;

        while(j < s.length()){
            char letter = s.charAt(j);
            if(!(set.contains(letter))){
                set.add(letter);
                longSub = Math.max(longSub, set.size());
                j++;

            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }

        return longSub;
    }
}