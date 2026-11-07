class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int result = 0;

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i] - 1)){
                continue;
            }

            int count = 1;

            while(set.contains(nums[i] + 1)){
                count++;
                nums[i]++;
            }

           result =  Math.max(result, count);
        }

        return result;
    }
}