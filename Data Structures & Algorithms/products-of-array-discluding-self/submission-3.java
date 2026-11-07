class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;

        int[] results = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            results[i] = prefix;
            prefix *= nums[i];
        }

        for (Integer i : results) {
            System.out.println(i);
        }

        int suffix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            // first store the result
            // then store the suffix which is suffix x nums[i]

            results[i] *= suffix;
            suffix *= nums[i];
        }

        for (Integer i : results) {
            System.out.println(i);
        }

        return results;
    }
}
