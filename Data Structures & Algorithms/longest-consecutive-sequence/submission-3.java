class Solution {
    public int longestConsecutive(int[] nums) {
        // HashSet
        // if set doesnt not contain - 1 than its a start of a sequence,
        //  track the current length and track the maxlength in case an array has more than one
        //  sequence

        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        for (Integer n : nums) {
            set.add(n);
        }

        int maxLength = 0;

        for (Integer n : set) {
            int currentLength = 1;

            if (!set.contains(n - 1)) {
                while (set.contains(n + 1)) {
                    n++;
                    currentLength++;
                }
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
