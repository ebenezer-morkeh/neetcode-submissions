class Solution {
    public boolean isAnagram(String s, String t) {
        // sort and compare

        if (s.length() != t.length())
            return false;

        ArrayList<Character> sList = new ArrayList<>();
        ArrayList<Character> tList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            sList.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            tList.add(t.charAt(i));
        }

        Collections.sort(sList);
        Collections.sort(tList);

        for (int i = 0; i < sList.size(); i++) {
            if (sList.get(i) != tList.get(i)) {
                return false;
            }
        }

        return true;
    }
}
