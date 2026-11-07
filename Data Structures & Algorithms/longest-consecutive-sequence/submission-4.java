class Solution {
    public int longestConsecutive(int[] nums) {
        // HashSet
        //  check if hashset contains num - 1, if it does , its not the start of a sequence
        // so skip and go to the next element, if t is start adding

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (Integer n : nums) {
            set.add(n);
        }

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentLength = 1;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i] + 1)) {
                    currentLength++;
                    nums[i]++;
                }
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
