class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] need = new int[26];
        int[] have = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
            have[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need, have))
            return true;

        for (int right = s1.length(); right < s2.length(); right++) {
            have[s2.charAt(right) - 'a']++;
            have[s2.charAt(right - s1.length()) - 'a']--;
            if (Arrays.equals(need, have))
                return true;
        }
        return false;
    }
}
