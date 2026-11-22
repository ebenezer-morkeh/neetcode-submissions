class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create a place to store pairs - ArrayList
        // create a places to store count of dependencies
        // loop through to add courses and  preq
        // loop to take courses and check to if any coureses in the array are left, if no more. move
        // to result array
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) list.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        // add courses
        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];

            list.get(pre).add(course);
            indegree[course]++;
        }

        // add classes to queue
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        // take classes
        int[] order = new int[numCourses];
        int taken = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order[taken] = cur;
            taken++;

            for (int next : list.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.offer(next);
            }
        }

        return taken == numCourses ? order : new int[0];
    }
}
