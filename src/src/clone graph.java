public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {return node;}
    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    // use a hashmap to save the nodes
    // key: node value.  used to create new node, since newly create node may not have all the neighbors it suppose to have,
    //      value is the only common attribute
    Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    queue.offer(node);
    map.put(newNode.label, newNode);
    while(!queue.isEmpty()) {
        UndirectedGraphNode cur = queue.poll();
        for (UndirectedGraphNode neighbor : cur.neighbors) {
            if (!map.containsKey(neighbor.label)) {
                map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                queue.offer(neighbor);
            }
            map.get(cur.label).neighbors.add(map.get(neighbor.label));
        }
    }
    return newNode;
}