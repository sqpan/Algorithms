public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null) {
        return true;
    }    
    int n = numCourses;
    //create a map to save pre-req and need pre-req relation, so the pre-requeist relation can be quickly checked
    //map[1][0] == true means 0 is the pre-request class for 1
    boolean[][] map = new boolean[n][n];
    int[] inDegree = new int[n];
    for (int i = 0; i < prerequisites.length; i++) {
        int pre = prerequisites[i][1];
        int cur = prerequisites[i][0];
        inDegree[cur]++;
        map[pre][cur] = true;
    }
    int count = 0;
    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < n; i++) {
        if (inDegree[i] == 0) {
            queue.offer(i);
        }
    }
    while (!queue.isEmpty()) {
        int cur = queue.poll();
        count++;
        for (int i = 0; i < n; i++) {
            if (map[cur][i]) {
                inDegree[i]--;
                // be careful here, need to check in the pre-requeist statement
                // or it will be dead loop
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
    }
    return count == n;
}