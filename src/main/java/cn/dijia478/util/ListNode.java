package cn.dijia478.util;

/**
 * leetcode上提供的，node单链表实现
 *
 * @author dijia478
 * @date 2022/7/19
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
