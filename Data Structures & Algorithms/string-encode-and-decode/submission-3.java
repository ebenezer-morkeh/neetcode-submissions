class Solution {
    public String encode(List<String> strs) {
        // build a string that contains length and splitter
        // return a whoel string for the arraylist

        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {
            encoded.append(strs.get(i).length()).append('#').append(strs.get(i));
        }

        return encoded.toString();
    }

    // 3#ate4#food
    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            i = j + 1;

            result.add(str.substring(i, i + length));

            i += length;
        }

        return result;
    }
}
