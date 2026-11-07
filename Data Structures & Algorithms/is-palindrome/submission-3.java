class Solution {
    public boolean isPalindrome(String s) {
        // run through the string from a -z
        // if the letter is not within a-z we need to remove or we can add to string builder and
        // make into a string

        s = s.toLowerCase();

        StringBuilder newString = new StringBuilder();

        for(Character c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                newString.append(c);
            }
        }

        System.out.println(newString);



        int i = 0; 
        int j = newString.length() - 1;

        while(i < j){
            if(newString.charAt(i) != newString.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
