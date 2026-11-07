class Solution {

    public String sortString(String str){

        char[] charArr = str.toCharArray();

        Arrays.sort(charArr);

        return new String(charArr);
    }

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        s = sortString(s);
        t = sortString(t);

        int i = 0;

        while(i < s.length()){
            if(s.charAt(i) != t.charAt(i)){
                return false; 
            }
            i++;
        }

        return true;
    }
}
