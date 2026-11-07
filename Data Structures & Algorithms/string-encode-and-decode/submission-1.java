class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for(String str : strs){
            encoded.append(str.length()).append("#").append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {

        int i = 0;

        List<String> result = new ArrayList<String>();

        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            result.add(str.substring(i, i + length));
            i += length;
        }
        return result;
    }
}
