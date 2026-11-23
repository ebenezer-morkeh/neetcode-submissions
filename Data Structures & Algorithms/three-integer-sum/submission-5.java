class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // no duplicates, check for duplicates
        // 3 points so maybe n^2
        // return in any order
        // has to equal 0

        // create arraylist
        // create loop and loop through nums
        //  we can use to pointers to do some math
        // while left < right
        // if nums[i] + nums[left] + nums[right] == 0 add all the elements to the list
        //  check to see if there is any duplicates
        // return result list if list has items or new list with no items

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }

        return results;
    }
}
