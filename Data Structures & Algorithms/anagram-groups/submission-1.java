class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map< String , List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String key = generateKey(strs[i]);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            } else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }
        }
        
        return new ArrayList<>(map.values());
    }

    private String generateKey(String str){
        char[] word = str.toCharArray();
        Arrays.sort(word);
        return new String(word);
    }
}
