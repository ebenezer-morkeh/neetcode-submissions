class Solution {
    public int findDuplicate(int[] nums) {

        int cont = 0;

        for (int i = 0; i < nums.length; i++) {
            int seen = nums[i];
            cont = i + 1;

            while (cont < nums.length) {
                if(seen == nums[cont]){
                    return seen;
                } else{
                    cont++;
                }
            }

            // floyd cycle detection
        }

        return 0;
    }
}
