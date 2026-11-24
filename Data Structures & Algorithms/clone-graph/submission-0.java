/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // you duplicate the relationship
        // we can sue a hashset to rememeber nodes
        // we use BFS to vist each node
        // for each neighbor you add it to the queue
        if (node == null)
            return null;

        Node clone = new Node(node.val);
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        map.put(node, clone);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (Node n : cur.neighbors) {
                if (!map.containsKey(n)) {
                    Node copy = new Node(n.val);
                    map.put(n, copy);
                    queue.offer(n);
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
}