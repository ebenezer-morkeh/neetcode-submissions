class Solution {
    public boolean isPalindrome(String s) {

        String newString = "";

        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))){
                newString = newString + Character.toLowerCase(s.charAt(i))
;
            }
        }

        int i = 0;
        int j = newString.length() - 1;

        while(i <= j){
            if(newString.charAt(i) != newString.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
