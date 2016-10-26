package com.zlz.datastruct.graph;

import java.util.Stack;

/**
 * @author zhailzh
 * 
 */
public class BaseGraph {

  private int[][] edgs = null;

  private Boolean[] visited = null;

  public BaseGraph(int pointNum) {
    edgs = new int[pointNum][pointNum];
    visited = new Boolean[pointNum];
    for (int i = 0; i < edgs.length; i++) {
      for (int j = 0; j < edgs.length; j++) {
        edgs[i][j] = 0;
      }
    }

    for (int i = 0; i < edgs.length; i++) {
      visited[i] = false;
    }
  }

  public void addEdgs(int i, int j) {
    addEdgs(i - 1, j - 1, 1);
    addEdgs(j - 1, i - 1, 1);
  }

  public void delEdgs(int i, int j) {
    addEdgs(i - 1, j - 1, 0);
    addEdgs(j - 1, i - 1, 0);
  }

  public boolean addEdgs(int from, int to, int quext) {

    if (to > -1 && to < visited.length && from < visited.length && from > -1) {
      edgs[from][to] = quext;
      return true;
    }

    return false;
  }

  public Boolean isExistEdgs(int i, int j) {
    return edgs[i][j] == 0 && edgs[j][i] == 0;
  }

  private String dps() {
    Stack<Integer> theStack = new Stack<Integer>();
    theStack.push(0);
    visited[0] = true;
    String temp = "0";

    while (!theStack.isEmpty()) {
      int v = getAdjUnvisitedVertex(theStack.peek());
      if (v != -1 && !visited[v]) {
        theStack.push(v);
        visited[theStack.peek()] = true;
        temp = temp + " " + theStack.peek();
      } else {
        theStack.pop();
      }
    }

    return temp;

  }

  private int getAdjUnvisitedVertex(Integer peek) {
    for (int i = 0; i < visited.length; i++) {
      if (edgs[peek][i] != 0 && !visited[i]) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    BaseGraph graph = new BaseGraph(6);
    graph.addEdgs(6, 1);
    graph.addEdgs(6, 2);
    graph.addEdgs(2, 3);
    graph.addEdgs(1, 3);
    graph.addEdgs(3, 4);
    graph.addEdgs(3, 5);
    String value = graph.dps();
    System.out.println(value);

  }

}
