class MinStack {



    private class Node{
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    Node top = null;

    public MinStack() {
        
    }
    
    public void push(int val) {
        int min = (top == null) ? val : Math.min(val, top.min);
        top = new Node(val, min, top);
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;
    }
}
