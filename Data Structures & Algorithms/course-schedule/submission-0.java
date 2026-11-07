class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // first create list to hold courses
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        //read every rule
        for(int[] p : prerequisites){
            int course = p[0]; 
            int pre = p[1];
            //add courses that need to be unloacked by pre
            adj.get(pre).add(course);
            indegree[course]++;
        }

        //fill the ready line
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        //take course untill line is empty
        int taken = 0; 
        while(!queue.isEmpty()){
            int cur = queue.poll();
            taken++;
            for(int next : adj.get(cur)){
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
        }

        return taken == numCourses;
    }
}
