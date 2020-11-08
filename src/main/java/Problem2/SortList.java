package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode mid = head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = mid;
            mid = mid.next;
            fast = fast.next.next;
        }

        ListNode nextList = mid;
        slow.next = null;

        return nextList;
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {

        if (list1 == null)
        {
            return list2;
        }

        if (list2 == null)
        {
            return list1;
        }

        if (list1 == null && list2 == null)
        {
            return null;
        }

        ListNode merge;
        if (list1.val < list2.val)
        {
            merge = list1;
            merge.next = mergeLists(list1.next, list2);
        }
        else
            {
            merge = list2;
            merge.next = mergeLists(list1, list2.next);
        }
        return merge;
    }

}
