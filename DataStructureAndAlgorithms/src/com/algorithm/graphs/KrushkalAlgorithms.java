package com.algorithm.graphs;

/**
 * Created by anurag on 29/06/19.
 */
import java.util.*;

// Data structure to store graph edges
class Edge1
{
    int src, dest, weight;

    public Edge1(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + src + ", " + dest + ", " + weight + ")";
    }
};

// class to represent a disjoint set
class KrushkalAlgorithms
{
    Map<Integer, Integer> parent = new HashMap<>();

    // perform MakeSet operation
    public void makeSet(int N)
    {
        // create N disjoint sets (one for each vertex)
        for (int i = 0; i < N; i++)
            parent.put(i, i);
    }

    // Find the root of the set in which element k belongs
    private int Find(int k)
    {
        // if k is root
        if (parent.get(k) == k)
            return k;

        // recur for parent until we find root
        return Find(parent.get(k));
    }

    // Perform Union of two subsets
    private void Union(int a, int b)
    {
        // find root of the sets in which elements
        // x and y belongs
        int x = Find(a);
        int y = Find(b);

        parent.put(x, y);
    }

    // construct MST using Kruskal's algorithm
    public static List<Edge1> KruskalAlgo(List<Edge1> edges, int N)
    {
        // stores edges present in MST
        List<Edge1> MST = new ArrayList();

        // initialize DisjointSet class
        // create singleton set for each element of universe
        KrushkalAlgorithms ds = new KrushkalAlgorithms();
        ds.makeSet(N);

        int index = 0;

        // MST contains exactly V-1 edges
        while (MST.size() != N - 1)
        {
            // consider next edge with minimum weight from the graph
            Edge1 next_edge = edges.get(index++);

            // find root of the sets to which two endpoint
            // vertices of next_edge belongs
            int x = ds.Find(next_edge.src);
            int y = ds.Find(next_edge.dest);

            // if both endpoints have different parents, they belong to
            // different connected components and can be included in MST
            if (x != y)
            {
                MST.add(next_edge);
                ds.Union(x, y);
            }
        }
        return MST;
    }

    public static void main(String[] args)
    {
        // (u, v, w) tiplet represent undirected edge from
        // vertex u to vertex v having weight w
        List<Edge1> edges = Arrays.asList(
                new Edge1(0, 1, 1), new Edge1(2, 4, 5),
                new Edge1(0, 4, 2), new Edge1(2, 3, 2),
                new Edge1(0, 2, 2),
                new Edge1(1, 4, 4),
                new Edge1(1, 3, 2),
                new Edge1(3, 4, 2)
        );

        // sort edges by increasing weight
        Collections.sort(edges, (a, b) -> a.weight - b.weight);

        // Number of vertices in the graph
        final int N = 7;

        // construct graph
        List<Edge1> e = KruskalAlgo(edges, N);

        for (Edge1 edge: e) {
            System.out.println(edge);
        }
    }
}
