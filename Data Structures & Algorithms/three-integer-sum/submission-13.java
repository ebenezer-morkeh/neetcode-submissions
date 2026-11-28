class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort array
        // 3 pointer question, so we need 3 pointers
        // input is a array full of ints, output is a List within another List at has integers
        //  check for duplicates, if i is the same as i before, move to the next i
        // we need to also check after we move left and right becuase left can also have duplicates

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return result;
    }
}
