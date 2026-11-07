class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // at some point your gunna have to sort
        // hashmap, sort word and then make key if its not in the hashmap already, if it is add to
        // arraylist

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] sArray = s.toCharArray();

            Arrays.sort(sArray);

            String key = new String(sArray);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
