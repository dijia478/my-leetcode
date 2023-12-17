package cn.dijia478;

import cn.dijia478.util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode() {}
 *  *     ListNode(int val) { this.val = val; }
 *  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  * }
 *
 * @author dijia478
 * @date 2023/12/17
 */
public class Code148 {

    public static void main(String[] args) {
        ListNode ln4 = new ListNode(3, null);
        ListNode ln3 = new ListNode(1, ln4);
        ListNode ln2 = new ListNode(2, ln3);
        ListNode ln1 = new ListNode(4, ln2);

        soutListNode(ln1);

        System.out.println("======");

        ListNode sortLn = sortList(ln1);

        soutListNode(sortLn);

    }

    public static ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode listNode = head;
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        list.sort(Comparator.comparingInt(o -> o));
        if (list.size() == 0) {
            return null;
        }
        ListNode[] listNodes = new ListNode[list.size()];
        for (int i = listNodes.length - 1; i >= 0; i--) {
            if (i == listNodes.length - 1) {
                listNodes[i] = new ListNode(list.get(i), null);
            } else {
                listNodes[i] = new ListNode(list.get(i), listNodes[i + 1]);
            }
        }
        return listNodes[0];
    }

    private static void soutListNode(ListNode listNode) {
        ListNode ln = listNode;
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }

}
