package com.algprithm.problems;

import com.data.LinkedNode;

/**
 * @author zhailzh
 * 
 * @Date 2015年11月6日——下午4:46:12
 * 
 *       判断两个单链表是否相交，有环，无环
 * 
 *       相交：判断最后一个位置是否相交 第一个节点，人为的增加的环 判断环的第一个节点
 */
public class LinkedListJoin {

  public static void main(String[] args) {

  }

  // 判断最后一个节点
  public boolean isConNLoop(LinkedNode<?> h1, LinkedNode<?> h2) {
    if (h1 == null || h2 == null)
      return false;
    LinkedNode<?> n1 = h1;
    LinkedNode<?> n2 = h2;
    while (n1.next != null)
      n1 = n1.next;
    while (n2.next != null)
      n2 = n2.next;

    if (n1 == n2)
      return true;
    return false;
  }

  // 找到两个节点相交的地方
  public LinkedNode<?> findPointNLoop(LinkedNode<?> h1, LinkedNode<?> h2) {
    if (h1 == null || h2 == null)
      return null;
    LinkedNode<?> n1 = h1;
    LinkedNode<?> n2 = h2;
    int len1 = 0;
    int len2 = 0;
    while (n1 != null) {
      n1 = n1.next;
      len1++;
    }
    while (n2 != null) {
      n2 = n2.next;
      len2++;
    }

    n1 = h1;
    n2 = h2;
    if (len1 < len2) {
      n1 = h2;
      n2 = h1;
    }

    for (int i = len1 - len2; i > 0; i--)
      n1 = n1.next;

    while (n1 != null && n1 != n2) {
      n1 = n1.next;
      n2 = n2.next;
    }
    return n1;
  }

  public boolean isLoop(LinkedNode<?> h2) {
    return loopEntry(h2) != null;
  }

  // 判断是否有环
  public LinkedNode<?> loopEntry(LinkedNode<?> head) {
    if (head == null)
      return null;
    LinkedNode<?> slow = head;
    LinkedNode<?> fast = slow.next;
    while (fast != null && fast.next != null && fast != slow) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast == slow) {
      fast = head;
      slow = slow.next;
      while (fast != slow) {
        slow = slow.next;
        fast = fast.next;
      }
      return slow;
    }
    return null;
  }

}
