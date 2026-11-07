class Solution {

    public String encode(List<String> strs) {
        
       //StringBuilder 
       StringBuilder encoded = new StringBuilder();

       for(String str : strs){
        encoded.append(str.length()).append("#").append(str);
       }

       return encoded.toString();
    }

    public List<String> decode(String str) {
        // identify splitters
        //identify words -> substring

        List<String> list = new ArrayList<String>();

        int i = 0;

        while(i < str.length()){
            int j = i; 

            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            list.add(str.substring(i, i + length));
            i += length;
            
        }

        return list;
    }
}
