package com.algprithm.problems;

import com.data.LinkedNode;
import com.data.tree.LinkedListNode;
import com.data.tree.TreeNode;

/**
 * 把二叉树转化为双链表
 * 
 */
public class Al01ConvertTree2LinkedList {

  public static void main(String[] args) {
    int[] ary = new int[] { 10, 6, 14, 4, 8, 12, 16 };
    TreeNode root = TreeNode.newTree(ary);
    LinkedListNode<Integer> list = new LinkedListNode<Integer>();
    midorder(root, list);
    LinkedNode<Integer> link = new LinkedNode<Integer>();
    midOrder(root,link);
    
    System.out.println(link.toAllBeforeString());
  }

  //只有一个索引的前提下，进行转换
  private static void midOrder(TreeNode root, LinkedNode<Integer> link) {
	if(root == null) return ;
	if(root.getLeft() != null){
		midOrder(root.getLeft(), link);
	}
	LinkedNode<Integer> node  = new LinkedNode<Integer>(null, (Integer)root.getValue(), null);
	link.next = node;
	node.prev = link;
	link = node;
	if(root.getRight() != null){
		midOrder(root.getRight(), link);
	}
}

/**
   * 先序遍历
   */
  private static LinkedListNode<Integer> midorder(TreeNode root, LinkedListNode<Integer> list) {
    if (root.getLeft() != null) {
      midorder(root.getRight(), list);
    }
    list.add((Integer) root.getValue());
    if (root.getRight() != null) {
      midorder(root.getLeft(), list);
    }
    return list;
  }
}
