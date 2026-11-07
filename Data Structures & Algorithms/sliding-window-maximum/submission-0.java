class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            if (!queue.isEmpty() && queue.peekFirst() <= right - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }
            queue.offerLast(right);

            if (right >= k - 1) {
                result[right - k + 1] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
