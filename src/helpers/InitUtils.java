package helpers;
/**
 * @author JUANJUAN
 * @version 2017年8月3日下午10:59:24
*/
public class InitUtils {
	public static ListNode initList(int[] nums){
		ListNode head = new ListNode(0), p = head;
		
		for(int i=0; i< nums.length; i++){
			p.next = new ListNode(nums[i]);
			p = p.next;
		}
		return head.next;
	}
	
	public static void printList(ListNode head){
		ListNode p = head;
		while(p!=null){
			System.out.print(p.val+ "->");
			p = p.next;
		}
		System.out.println();
	}
	
}
