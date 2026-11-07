class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> dist(b) - dist(a)
        );

        for(int[] p : points){
            heap.offer(p);
            if(heap.size() > k) heap.poll();
        }

        int[][] result = new int[k][];
        for(int i = 0; i < k; i++) result[i] = heap.poll();
        return result;
    }

    int dist(int[] p){
        return p[0] * p[0] + p[1] * p[1];
    }
}
