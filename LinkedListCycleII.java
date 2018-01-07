//The problem: https://leetcode.com/problems/linked-list-cycle-ii/description/

public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();        
        while(head!=null) {
        	if(set.contains(head))
        		return head;
        	else {
        		set.add(head);
        		head = head.next;
        	}
        }
        return null;
    }

