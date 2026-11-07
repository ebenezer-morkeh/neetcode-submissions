class Solution {
    public boolean hasDuplicate(int[] nums) {
        // HashSet
        HashSet<Integer> set = new HashSet<>();

        for(Integer n: nums){
            set.add(n);
        }

        return nums.length != set.size();
    }
}