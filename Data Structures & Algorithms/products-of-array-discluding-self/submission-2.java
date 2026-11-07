class Solution {
    public int[] productExceptSelf(int[] nums) {
        //two pass pattern
        // mutiple everythign but self

        int prefix = 1;
        int[] results = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            results[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            results[i] *= suffix;
            suffix *= nums[i];
        }

        return results;
    }
}  
