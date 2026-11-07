class Solution {
    public int findMin(int[] nums) {
        // so if you rotate once it moves down the list one time, so i think we need to have two pointers, keep track of min 


        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
