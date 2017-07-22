package leetcodes1_50;

import helpers.ListNode;

/**
 * @author JUANJUAN
 * @version 2017年6月30日下午6:38:49
 */
public class L19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		int num = 0;
		int n2 = 1;
		ListNode p = head;
		while (p != null) {
			// p2已经走到最后一个节点处
			if (p.next == null) {
				num = n2;
				break;
			}else{
				// 如果当前p2还有下下个节点
				if (p.next.next != null) {
					p = p.next.next;
					n2 += 2;
					// p2只有下个节点没有下下个结点
				} else {
					p = p.next;
					n2++;
				}
			}
		}

		p = head;
		int i;
		for (i = 1; i < num - n; i++) {
			p = p.next;
		}
		if (num==1) {
			return null;
		} else if(n==1){
			p.next = null;
		}else if(n==num){
			return head.next;
		}else {
			ListNode temp = p.next.next;
			p.next = temp;
		}
		return head;
	}
	public ListNode removeNthFromEnd2(ListNode head, int n) {
	    
	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;
	    //把快指针移动到第n+1位，使得快指针与慢指针之间相隔n个结点
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //这样快慢节点一起移动，快节点到了末尾，而慢节点也刚好到了倒数第n位
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
	
}
