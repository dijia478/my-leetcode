package cn.dijia478;

import cn.dijia478.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *  
 *
 * @author dijia478
 * @date 2022/7/19
 */
public class Code234 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(isPalindrome(listNode4));

    }

    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(head.val);
            head = head.next;
            if (head == null) {
                break;
            }
        }

        int j;
        if (list.size() % 2 == 0) {
            j = list.size() / 2;
        } else {
            j = (list.size() - 1) / 2;
        }

        for (int i = 0; i < j; i++) {
            if (list.get(i).equals(list.get(list.size() - 1 - i))) {
                continue;
            }
            return false;
        }
        return true;
    }

}
