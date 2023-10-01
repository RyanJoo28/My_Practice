package Data_Sttructure_and_Algorithm.Graph;

import java.util.*;

public class Graph {
    public static void main(String[] args) {

    }
}

class GraphAdjMat {
    List<Integer> vertices; // List of vertices, elements represent vertex values, indices represent vertex indices
    List<List<Integer>> adjMat; // Adjacency matrix, rows and columns correspond to vertex indices

    /* Constructor */
    public GraphAdjMat(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMat = new ArrayList<>();

        // Add vertices
        for (int val : vertices) {
            addVertex(val);
        }

        // Add edges
        for (int[] e : edges) {
            addEdge(e[0], e[1]);
        }
    }

    /* Get the number of vertices */
    public int size() {
        return vertices.size();
    }

    /* Add a vertex */
    public void addVertex(int val) {
        int n = size();
        vertices.add(val);

        // Add a new row to the adjacency matrix
        List<Integer> newRow = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            newRow.add(0);
        }
        adjMat.add(newRow);

        // Add a new column to the adjacency matrix
        for (List<Integer> row : adjMat) {
            row.add(0);
        }
    }

    /* Remove a vertex */
    public void removeVertex(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        vertices.remove(index);
        adjMat.remove(index);

        for (List<Integer> row : adjMat) {
            row.remove(index);
        }
    }

    /* Add an edge */
    public void addEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new IndexOutOfBoundsException();
        }

        adjMat.get(i).set(j, 1);
        adjMat.get(j).set(i, 1);
    }

    /* Remove an edge */
    public void removeEdge(int i, int j) {
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new IndexOutOfBoundsException();
        }

        adjMat.get(i).set(j, 0);
        adjMat.get(j).set(i, 0);
    }

    /* Print the adjacency matrix */
    public void print() {
        System.out.print("Vertex List = ");
        System.out.println(vertices);
        System.out.println("Adjacency Matrix = ");
        for (List<Integer> row : adjMat) {
            System.out.println(row);
        }
    }
}

/* Implementation of GraphAdjList */
class GraphAdjList {
    Map<Vertex, List<Vertex>> adjList;

    /* Constructor */
    public GraphAdjList(Vertex[][] edges) {
        this.adjList = new HashMap<>();

        for (Vertex[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    /* Get the number of vertices */
    public int size() {
        return adjList.size();
    }

    /* Add an edge */
    public void addEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2) {
            throw new IllegalArgumentException();
        }

        adjList.get(vet1).add(vet2);
        adjList.get(vet2).add(vet1);
    }

    /* Remove an edge */
    public void removeEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2) {
            throw new IllegalArgumentException();
        }

        adjList.get(vet1).remove(vet2);
        adjList.get(vet2).remove(vet1);
    }

    /* Add a vertex */
    public void addVertex(Vertex vet) {
        if (!adjList.containsKey(vet)) {
            adjList.put(vet, new ArrayList<>());
        }
    }

    /* Remove a vertex */
    public void removeVertex(Vertex vet) {
        if (!adjList.containsKey(vet)) {
            throw new IllegalArgumentException();
        }

        adjList.remove(vet);

        for (List<Vertex> list : adjList.values()) {
            list.remove(vet);
        }
    }

    /* Print the adjacency list */
    public void print() {
        System.out.println("Adjacency List =");
        for (Map.Entry<Vertex, List<Vertex>> pair : adjList.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (Vertex vertex : pair.getValue()) {
                tmp.add(vertex.val);
            }
            System.out.println(pair.getKey().val + ": " + tmp + ",");
        }
    }
}

/* Vertex class for adjacency list */
class Vertex {
    int val;

    public Vertex(int val) {
        this.val = val;
    }
}

class GraphBFS {
    /* 广度优先遍历 BFS */
// 使用邻接表来表示图，以便获取指定顶点的所有邻接顶点
    List<Vertex> graphBFS(GraphAdjList graph, Vertex startVet) {
        // 顶点遍历序列
        List<Vertex> res = new ArrayList<>();
        // 哈希表，用于记录已被访问过的顶点
        Set<Vertex> visited = new HashSet<>();
        visited.add(startVet);
        // 队列用于实现 BFS
        Queue<Vertex> que = new LinkedList<>();
        que.offer(startVet);
        // 以顶点 vet 为起点，循环直至访问完所有顶点
        while (!que.isEmpty()) {
            Vertex vet = que.poll(); // 队首顶点出队
            res.add(vet);            // 记录访问顶点
            // 遍历该顶点的所有邻接顶点
            for (Vertex adjVet : graph.adjList.get(vet)) {
                if (visited.contains(adjVet))
                    continue;        // 跳过已被访问过的顶点
                que.offer(adjVet);   // 只入队未访问的顶点
                visited.add(adjVet); // 标记该顶点已被访问
            }
        }
        // 返回顶点遍历序列
        return res;
    }
}
