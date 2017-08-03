package leetcodes51_100;

import helpers.InitUtils;
import helpers.ListNode;

/**
 * @author JUANJUAN
 * @version 2017年8月3日下午10:37:43
*/
public class L86 {
	
	public ListNode partition(ListNode head, int x) {
        if(head == null){
        	return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p=head, cur = head,firstmore =null, morecur= null, more=null;
        while(p!=null){
        	
        	while(p!=null && p.val < x){
        		cur = p;
        		p = p.next;
        	}
        	more =p;
        	while(p!=null && p.val>=x){
        		more =p;
        		p = p.next;
        	}
        	InitUtils.printList(cur);
        	InitUtils.printList(p);
        	if(more!=null && p!=null)
        		more.next = p.next;
        	if(p!=null && cur!=null){
        		p.next= cur.next;
        	}
        	if(cur!=null){
        		cur.next = p;
        	}
        	InitUtils.printList(more);
        }
        InitUtils.printList(firstmore);
        cur.next = firstmore;
        
        return newHead.next;
    }
	
	
	public static void main(String[] args) {
		int[] nums = {1,4,3,2,5,2};
		ListNode head = InitUtils.initList(nums);
		L86 test = new L86();
		ListNode p=test.partition(head, 3);
		InitUtils.printList(p);
	}
}
