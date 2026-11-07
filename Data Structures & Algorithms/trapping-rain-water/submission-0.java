class Solution {
    public int trap(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int[] fowardArray = new int[height.length];
        int[] backwardsArray = new int[height.length];
        int resultMax = 0;

        while (i < height.length) {
            max = Math.max(height[i], max);
            fowardArray[i] = max;
            i++;
        }

        max = 0;

        while (j >= 0) {
            max = Math.max(height[j], max);
            backwardsArray[j] = max;
            j--;
        }

        int min = 0;
        int k = 0;
        int[] resultArr = new int[height.length];

        while (k < height.length) {
            min = Math.min(fowardArray[k], backwardsArray[k]);
            resultArr[k] = min - height[k];
            k++;
        }

        for (int val = 0; val < resultArr.length; val++) {
            resultMax += resultArr[val];
        }

        return resultMax;
    }
}
