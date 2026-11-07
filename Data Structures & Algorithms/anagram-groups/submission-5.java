class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       // hashmap, arraylist 

       if(strs.length < 0){
        return new ArrayList<>();
       }

       HashMap<String, List<String>> map = new HashMap<>();

       for(String s : strs){

        char[] word = s.toCharArray();
        Arrays.sort(word);
        String key = s.valueOf(word);

        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(s);
       }

       return new ArrayList<>(map.values());
    }
}
