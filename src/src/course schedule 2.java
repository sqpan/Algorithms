public int[] findOrder(int numCourses, int[][] prerequisites) { 
    int[] result = new int[numCourses];
    if (prerequisites == null || prerequisites.length == 0) {
        for (int i = 0; i < numCourses; i++) {result[i] = i;}
        return result;
    }
    // map to record prerequisites
    boolean[][] map = new boolean[numCourses][numCourses];
    // indegree to record who many prerequisites a course have
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
        int pre = prerequisites[i][1];
        int cur = prerequisites[i][0];
        map[pre][cur] = true;
        inDegree[cur]++;
    }
    // a queue to bfs all the course can be took now
    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) {
        if (inDegree[i] == 0) {queue.offer(i);}
    }
    int count = 0;
    while (!queue.isEmpty()) {
        int cur = queue.poll();
        result[count++] = cur;
        for (int i = 0; i < numCourses; i++) {
            if (map[cur][i]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {queue.offer(i);}
            }
        }
    }
    // when count != numCourses, means not all course can be took. return an empty array
    if (count != numCourses) {return new int[0];}
    return result;
}