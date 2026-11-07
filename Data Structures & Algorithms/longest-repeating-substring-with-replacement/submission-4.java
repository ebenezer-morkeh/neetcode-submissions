
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        int i = 0;
        int j = 0;
        int topFreq = 0;
        int longest = 0;

        while (j < s.length()) {
            char rightChar = s.charAt(j);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            topFreq = Math.max(topFreq, map.get(rightChar));

            while ((j - i + 1) - topFreq > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }

            longest = Math.max(longest, (j - i + 1));

            j++;
        }

        return longest;
    }
}

