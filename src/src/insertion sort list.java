public ListNode insertionSortList(ListNode head) {
	if (head == null || head.next == null) {return head;}
	ListNode newNode = head;
	while (head != null) {
		ListNode temp = head.next;
		newHead = insertNode(newHead, head);
		head = temp;
	}        
	return newHead;
}

private ListNode insertNode(ListNode newHead, ListNode head) {
	if (newHead == head) {return newHead;}
	if (head.val < newHead.val) {
		head.next = newHead;
		return head;
	}
	ListNode copy = newHead;
	while (copy.next != null) {
		if (copy.next.val < head.val) {copy = copy.next;}
		else {
			ListNode temp = copy.next;
			copy.next = head;
			head.next = temp;
			return newHead;
		}	
	}
	copy.next = head;
	return newHead;
}