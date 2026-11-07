class KthLargest {

    private int k;
    private PriorityQueue<Integer> heap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n : nums) add(n);

    }
    
    public int add(int val) {
        heap.offer(val);
        if(heap.size() > k) heap.poll();
        return heap.peek();
    }
}
