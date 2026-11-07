class Solution {
    public boolean isAnagram(String s, String t) {

        if( s.length() != t.length()){
            return false;
        }

        List<Character> sortedS = new ArrayList<>();
        List<Character> sortedT = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            sortedS.add(s.charAt(i));
        }

        for(int i = 0; i < t.length(); i++){
            sortedT.add(t.charAt(i));
        }

        Collections.sort(sortedS);
        Collections.sort(sortedT);

        for(int i = 0; i < sortedS.size(); i++){
            if(sortedT.get(i) != sortedS.get(i)){
                return false;
            }
        }

        return true;
    }
}
