class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }


        char[] stringOne = s.toCharArray();
        char[] stringTwo = t.toCharArray();

        Arrays.sort(stringOne);
        Arrays.sort(stringTwo);



        for(int i = 0; i < s.length(); i++){
            if(stringOne[i] != stringTwo[i]){
                return false;
            }
        }

        return true;
    }
}
