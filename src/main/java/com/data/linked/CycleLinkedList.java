package com.data.linked;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhailzh 双向循环链表
 */
public class CycleLinkedList<E> {

  transient int size = 0;
  transient Node<E> first = null;

  public CycleLinkedList(Collection<? extends E> c) {
    this();
    addAll(c);
  }

  public CycleLinkedList() {}

  private boolean addAll(Collection<? extends E> c) {
    Object[] a = c.toArray();
    int numNew = a.length;
    if (numNew == 0)
      return true;

    for (Object o : a) {
      @SuppressWarnings("unchecked")
      E e = (E) o;
      if (first == null) { // 如果是null的cycle linkedlist
        Node<E> newNode = new Node<E>(null, e, null);
        newNode.next = newNode;
        newNode.prev = newNode;
        first = newNode;
      } else {
        // 添加元素
        Node<E> newNode = new Node<E>(first, e, first.next);
        first.next = newNode;
        newNode.next.prev = newNode;
      }
    }
    size += numNew;
    return true;
  }

  public boolean add(E e) {

    if (first == null && size == 0) {
      Node<E> newNode = new Node<E>(null, e, null);
      newNode.next = newNode;
      newNode.prev = newNode;
      first = newNode;
    } else {
      // 添加元素
      Node<E> newNode = new Node<E>(first, e, first.next);
      first.next = newNode;
      newNode.next.prev = newNode;
    }
    size = size + 1;
    return true;
  }

  public E get() {
    if (first != null) {
      return first.item;
    } else {
      return null;
    }
  }

  public List<E> toArray() {
    if (first == null) {
      return null;
    } else {
      List<E> arraylist = new ArrayList<E>();
      arraylist.add(first.item);
      Node<E> fiNode = first;
      while (fiNode.prev != first) {
        arraylist.add(fiNode.prev.item);
        fiNode = fiNode.prev;
      }
      return arraylist;
    }

  }

  public Boolean del() {
    if (first == null) {
      return false;
    } else {
      Node<E> firstnode = first;
      first.prev.next = first.next;
      first.next.prev = first.prev;
      first = first.next;
      firstnode.item = null;
      firstnode.next = null;
      firstnode.prev = null;
      firstnode = null;
    }
    return true;
  }

  @Override
  public String toString() {
    return toArray().toString();
  }

  // 数据元素，数据节点
  private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
      this.item = element;
      this.next = next;
      this.prev = prev;
    }

    @Override
    public String toString() {
      return "Node [item=" + item + ", next=" + next + ", prev=" + prev + "]";
    }
  }

  public static void main(String[] args) {

    Collection<Integer> nums = new ArrayList<Integer>();
    nums.add(12);
    nums.add(13);
    nums.add(14);
    nums.add(15);
    nums.add(16);
    nums.add(17);
    CycleLinkedList<Integer> cycle = new CycleLinkedList<Integer>(nums);
    System.out.println(cycle.toArray().toString());
    cycle.del();
    System.out.println(cycle.toArray().toString());
    cycle.del();
    System.out.println(cycle.toArray().toString());
    cycle.del();
    System.out.println(cycle.toArray().toString());
  }
}
