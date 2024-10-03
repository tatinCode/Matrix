# Matrix
This Java program implements a graph using an adjacency matrix and provides functionalities <br>
for Depth-First Search (DFS) and Breadth-First Search (BFS) traversals. <br>

Reads graph data from a file.

<h1>Sample input</h1>

```
4
0 1 1 0
1 0 0 1
1 0 0 1
0 1 1 0
```

output:

```
BFS Path: 0 
1 
2 
3
```

Explanation:

Starting from vertex 0, BFS first visits its neighbors 1 and 2.
Then it moves to vertex 1 and visits its unvisited neighbor, vertex 3.
Finally, it explores vertex 3 (which has no unvisited neighbors), completing the traversal.
This handles a connected graph, and both DFS and BFS will visit all vertices.
