package com.codingchallenges.leetcode;

import java.util.*;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) return null;

        List<Integer> mergedValues = new ArrayList<Integer>();

        for (ListNode node : lists) {
            while (node != null) {
                mergedValues.add(node.val);
                node = node.next;
            }
        }

        if (mergedValues.size() <= 0) return null;

        Collections.sort(mergedValues);

        ListNode result = new ListNode();
        ListNode nextNode = result;

        ListIterator<Integer> mergedValuesIterator = mergedValues.listIterator();
        while (mergedValuesIterator.hasNext()) {
            nextNode.val = mergedValuesIterator.next();
            if (mergedValuesIterator.hasNext()) nextNode = nextNode.next = new ListNode();
        }

        return result;
    }
}

