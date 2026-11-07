class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        int[] need = new int[128];
        int[] have = new int[128];
        int required = 0;

        for(char c : t.toCharArray()){
            if(need[c] == 0) required++;
            need[c]++;
        }

        int formed = 0;
        int left = 0; 
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            have[c]++;
            if(need[c] > 0 && have[c] == need[c]) formed++;

            while(formed == required){
                if(right - left + 1 < bestLen){
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                char l = s.charAt(left);
                if(need[l] > 0 && have[l] == need[l]) formed--;
                have[l]--;
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
