package com.algorithm.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by anurag on 23/06/19.
 */
public class BellmanFordAlgorithm {


    private int distance[] ={0,0,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
    private int vertexCount;
    private AdjacencyList adjacencyList;
    private Queue<GraphNode> integerQueue = new LinkedList<>();
    private int path[] ;//= new int[v]


    public BellmanFordAlgorithm(int vertexCount){
     this.vertexCount=vertexCount;

     path = new int[vertexCount+1];
     adjacencyList = new AdjacencyList(vertexCount);
     adjacencyList.addEdge(1,2,2);
     adjacencyList.addEdge(1,3,5);
     adjacencyList.addEdge(3,4,-3);
     adjacencyList.addEdge(4,2,-1);


    }


    public void printBellManFord(){

        integerQueue.offer(new GraphNode(1,0));

        while (!integerQueue.isEmpty()){

            GraphNode node = integerQueue.poll();
            List nodeName = AdjacencyList.getEdgeList()[node.name];
            List edgeWt = AdjacencyList.getEdgeValue()[node.name];

            for (int v = 1; v <=nodeName.size() ; v++) {

                int wt =(Integer) edgeWt.get(v-1);
                int newDistance = distance[node.name] +wt ;

                if(distance[(Integer) nodeName.get(v-1)] > newDistance){

                    distance[(Integer) nodeName.get(v-1)] = newDistance;
                    path[(Integer) nodeName.get(v-1)]= node.name;
                }
                if (!integerQueue.contains(new GraphNode((Integer) nodeName.get(v-1),wt))){
                    integerQueue.offer(new GraphNode((Integer) nodeName.get(v-1),wt));
                }
            }


        }

        for (int i = 1; i < path.length; i++) {
            System.out.println("Node : "+i+" Distance : " + distance[i] +"  "+ "path :" +path[i]);
        }
    }
    public static void main(String args[]){
        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm(4);
        bellmanFordAlgorithm.printBellManFord();
    }
}
