class Solution {
    public int longestConsecutive(int[] nums) {
        // remove duplicates -> HashSet
        // sort array

        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (Integer n : nums) {
            set.add(n);
        }

        int maxLength = 0;

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currentLength = 1;

                while (set.contains(n + 1)) {
                    n++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
