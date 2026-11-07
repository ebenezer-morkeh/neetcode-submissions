class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create place to store coures
        //create place to store number of coures required
        //dependency/cycle detection - queue or linkedlist

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) list.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        //check rule to see dependency 
        for(int[] p : prerequisites){
            int course = p[0];
            int pre = p[1];
            list.get(pre).add(course);
            indegree[course]++;
        }

        //get the start
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) queue.offer(i);
        }


        //take classes
        int taken = 0;
        int[] order = new int[numCourses];

        while(!queue.isEmpty()){
            int curr = queue.poll();
            order[taken] = curr;
            taken++;
            for(int next : list.get(curr)){
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

        if (taken == numCourses) return order;
        return new int[0];
    }
}
