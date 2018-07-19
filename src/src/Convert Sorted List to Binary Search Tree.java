public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {return null;}
    return helper(head, null);        
}

private TreeNode helper(ListNode start, ListNode end) {
    // when start == end, the function is called root.left = helper(start, end), root is start && root is end
    // so return null
    if (start == end) {return null;}
    ListNode slow = start, fast = start;
    // while stop codition: fast == end.prev || fast == end.prev.prev
    while (fast != end && fast.next != end) {
        slow = slow.next;
        fast = fast.next.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = helper(start, slow);
    root.right = helper(slow.next, end);
    return root;
}