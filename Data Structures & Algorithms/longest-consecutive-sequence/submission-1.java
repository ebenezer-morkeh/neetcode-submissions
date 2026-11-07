
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int maxLength = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int currLength = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    currLength++;
                }

                maxLength = Math.max(maxLength, currLength);
            }
        }

        return maxLength;
    }
}

