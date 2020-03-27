package com.agile.leetcode.algorithm;

/**
 * @author liuyi
 * @since 2020/3/24
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
   如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
   您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
   示例：
   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
   输出：7 -> 0 -> 8
   原因：342 + 465 = 807
 *
 */
public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        addTwoNumbers1(listNode1, listNode4);
    }

    /**
     * 解法一
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            //头节点
            ListNode headNode = null;
            //下一个节点
            ListNode nextNode =  null;
            //临时节点
            ListNode tmpNode = null;
            //相加是否进位，进位为1，不进位为0
            int tmp = 0;
            //相加的临时值
            int tmpVal = 0;
            while (l1 != null || l2 != null) {
                tmpVal = tmp != 0 ? tmp : 0;
                tmpVal = l1 == null ? tmpVal : tmpVal + l1.val;
                tmpVal = l2 == null ? tmpVal : tmpVal + l2.val;
                l1 = l1 == null ? l1 : l1.next;
                l2 = l2 == null ? l2 : l2.next;
                tmp = tmpVal / 10;
                tmpVal = tmpVal >= 10 ? tmpVal%10 : tmpVal;
                if (headNode == null) {
                    headNode = new ListNode(tmpVal);
                    nextNode = headNode;
                } else {
                    tmpNode = new ListNode(tmpVal);
                    nextNode.next = tmpNode;
                    nextNode = tmpNode;
                }
            }
            if (tmp == 1) {
                nextNode.next =  new ListNode(tmp);
            }
            return headNode;
        }
        return null;
    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
