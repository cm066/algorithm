package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cm
 * @create 2021/12/20-7:51 下午
 */
public class MergeKLists {
    public static void main(String[] args) {

    }

    /**
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        };
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
        for (ListNode list : lists) {
            if (list != null){
                queue.add(list);
            }

        }
        ListNode tmp = head;
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            tmp.next = poll;
            tmp = tmp.next;
            if (poll.next != null){
                queue.add(poll.next);
            }
        }
        return head.next;
    }
}
