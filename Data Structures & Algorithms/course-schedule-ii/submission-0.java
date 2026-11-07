class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        //Read each rule
        for(int[] p : prerequisites){
            int course = p[0];
            int pre = p[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }

        //assign the start 
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        } 

        //take classes
        int[] order = new int[numCourses];
        int taken= 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            order[taken] = cur;
            taken++;
            for(int next : adj.get(cur)){
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
        }

        if(taken == numCourses) return order;
        return new int[0];
    }
}
