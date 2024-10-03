
/*
 * 
 * This Java program implements a graph using an adjacency matrix and provides 
 * functionalities for Depth-First Search (DFS) and Breadth-First Search (BFS) traversals.
 * 
 * FILES ARE PROVIDED INSIDE THE FOLDER.
 * 
 */
import java.io.*;
import java.util.*;

public class MyGraph {
  private static char[][] adjMat;
  private static boolean[] visited;
  private static int size;

  public MyGraph(String fileName) {
    try {
      Scanner input = new Scanner(new File(fileName));

      size = Integer.parseInt(input.nextLine());
      adjMat = new char[size][size];
      // storing file data to adj matrix
      int i = 0;
      while (i < size) {
        String line = input.nextLine();
        String[] mat = line.split(" ");
        for (int j = 0; j < size; j++) {
          adjMat[i][j] = mat[j].charAt(0);
        }
      }

      input.close();

    } catch (IOException ex) {
      System.out.println("Input file error! " + "File: \"" + fileName + "\" not found.");
    }

  }

  // function to print Depth first search of graph given adjacency matrix
  public void printDFS(int v, boolean visited[]) {
    visited[v] = true;
    System.out.print(v + " ");
    for (int i = 0; i < size; i++) {
      if (adjMat[v][i] == '1' && !visited[i]) {
        printDFS(i, visited);
      }
    }
  }

  // function to print Breath first search of graph given adjacency matrix
  public void printBFS(int sv, boolean[] visited) {
    MyQueue pendingQueue = new MyQueue();
    pendingQueue.enqueue(sv);
    visited[sv] = true;
    while (!pendingQueue.empty()) {
      int currFront = pendingQueue.front.data;
      pendingQueue.dequeue();
      System.out.println(currFront + " ");
      for (int i = 0; i < size; i++) {
        if (i == currFront) {
          continue;
        }
        if (adjMat[currFront][i] == '1' && !visited[i]) {
          pendingQueue.enqueue(i);
          visited[i] = true;
        }
      }
    }
  }

  // function to print DFS for disconnected graph
  public void startDFS() {
    System.out.print("DFS Path: ");
    visited = new boolean[size];
    for (int i = 0; i < size; ++i) {
      if (visited[i] == false) {
        printDFS(i, visited);
      }
    }
  }

  // function to print BFS for disconnected graph
  public void startBFS() {

    System.out.print("BFS Path: ");
    visited = new boolean[size];
    for (int i = 0; i < size; i++) {
      visited[i] = false;
    }

    for (int i = 0; i < size; i++) {
      if (!visited[i]) {
        printBFS(i, visited);
      }
    }

  }

  // Main function
  public static void main(String[] args) {
    MyGraph g = new MyGraph(args[0]);

    if (args[1].equals("dfs")) {
      g.startDFS();
    } else if (args[1].equals("bfs")) {
      g.startBFS();
    }
  }

}

class QNode {
  public int data;
  public QNode next;

  public QNode(int c) {
    data = c;
    next = null;
  }

}

class MyQueue {
  public QNode front;
  public QNode rear;

  public MyQueue() {

    front = null;
    rear = null;

  }

  public void enqueue(int c) {
    QNode temp = new QNode(c);

    if (front == null) {
      front = temp;

    } else {
      rear.next = temp;

    }
    rear = temp;

  }

  public QNode dequeue() {
    QNode temp = null;

    if (front != null) {
      temp = front;
      front = front.next;
    }
    return temp;
  }

  public boolean empty() {
    return front == null;
  }

}