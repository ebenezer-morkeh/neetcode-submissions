class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
           String key = sortedStrings(str);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());

    }

    private String sortedStrings(String str){
        char[] charArr = str.toCharArray();

        Arrays.sort(charArr);

        return new String(charArr);
    }

}