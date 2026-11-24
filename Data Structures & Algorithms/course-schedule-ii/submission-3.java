class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // first we have to create space for the courses arraylist
        // this will require us to use indegree
        // arraylist, indegree, queue for geting the next item
        // we have to add a course to the pre, so for [[1,0]] list: ([0] -> [1])
        // take courses, loop each course to take then if it equals 0 add to queue
        // the numcourse is also the course to look for

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) list.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        // add courses and prequestites
        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];

            list.get(pre).add(course);
            indegree[course]++;
        }

        // find first course we an take
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        // start taking classes
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
