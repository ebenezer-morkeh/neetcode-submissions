class Solution {
    public int[] twoSum(int[] nums, int target) {
        //complment, nums[i] + _ = target

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int answerIndex = target - nums[i];
            if(map.containsKey(answerIndex)){
                return new int[]{map.get(answerIndex),i};
            }
            else{
                map.put(nums[i], i);
            }
        }

        return new int[]{}; 
    }
}
