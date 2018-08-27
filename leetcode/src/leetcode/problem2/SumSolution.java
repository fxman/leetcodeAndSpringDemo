package leetcode.problem2;

public class SumSolution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (null == l1) {
			return l2;
		}

		if (null == l2) {
			return l1;
		}
		
		ListNode first = new ListNode(0);
		ListNode current = first;
		
		int bit = 0;
		do {
			current.next = new ListNode((l1.val + l2.val + bit) % 10);
			bit = (l1.val + l2.val + bit) / 10;
			current = current.next;
			l1 = l1.next;
			l2 = l2.next;
		} while (l1 != null && l2 != null);

		while (l2 != null) {
			current.next = l2;
			bit = (l2.val + bit) / 10;
			l2.val = (l2.val + bit) % 10;
			if (bit == 0)
				break;
			current = current.next;
			l2 = l2.next;
		}
		
		while (l1 != null) {
			current.next = l1;
			l1.val = (l1.val + bit) % 10;
			bit = (l1.val + bit) / 10;
			if (bit == 0)
				break;
			current = current.next;
			l1 = l1.next;
		}
		
		if(0 != bit){
			current.next = new ListNode(bit);
		}
		return first.next;
	}
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
	      ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	    }

	public static void main(String[] args) {
		SumSolution  ss = new SumSolution();
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(7);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		
		l4.next = l5;
		l5.next = l6;
		ListNode rs = ss.addTwoNumbers1(l1, l4);
		while(null != rs){
			System.out.println(rs.val);
			rs = rs.next;
		}
		
	}
}
