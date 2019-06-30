package com.algorithm.graphs;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by anurag on 16/06/19.
 */
public class DijiktrasAlgorithms {

      int adjMatrix[][] ={{},
              {Integer.MAX_VALUE,Integer.MAX_VALUE,3,2,1,Integer.MAX_VALUE},
              {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,2},
              {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,1,Integer.MAX_VALUE},
              {Integer.MAX_VALUE,Integer.MAX_VALUE,1,Integer.MAX_VALUE,Integer.MAX_VALUE,3},
      {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}};

      int[] distance = {0,0,-1,-1,-1,-1};

      AdjacencyList adjacencyList = null;


    public DijiktrasAlgorithms(int vextexCount) {

        adjacencyList = new AdjacencyList(vextexCount);
        adjacencyList.addEdge(1,2,3);
        adjacencyList.addEdge(1,3,2);
        adjacencyList.addEdge(1,4,1);
        adjacencyList.addEdge(2,5,2);
        adjacencyList.addEdge(3,4,1);
        adjacencyList.addEdge(4,2,1);
        adjacencyList.addEdge(4,5,5);




    }

    public void printDijiktrasAlgorithms(){

        Comparator<GraphNode> valueComparator = (GraphNode v1 , GraphNode v2) ->{

            if(v1.getValue()> v2.getValue())
                return -1;
            return 1;
        };

         PriorityQueue<GraphNode> queue = new PriorityQueue(valueComparator);
         queue.offer(new GraphNode(1,0));
         int path[] = new int[6];

          while (!queue.isEmpty()){

              GraphNode node = queue.poll();
              List linkedList = AdjacencyList.getEdgeList()[node.name];
              List wtlinkedList = AdjacencyList.getEdgeValue()[node.name];

              for (int v = 1; v <= linkedList.size(); v++) {

                  int newDistance = distance[node.name] +(Integer)wtlinkedList.get(v-1);

                  if(distance[(Integer)linkedList.get(v-1)]==-1){

                      distance[(Integer)linkedList.get(v-1)]=newDistance;
                      path[(Integer)linkedList.get(v-1)]=node.name;
                      GraphNode node1 = new GraphNode((Integer)linkedList.get(v-1),newDistance);
                      queue.offer(node1);
                  }

                  if(distance[(Integer)linkedList.get(v-1)] > newDistance){

                      distance[(Integer)linkedList.get(v-1)]=newDistance;
                      path[(Integer)linkedList.get(v-1)]=node.name;
                      queue.offer(new GraphNode((Integer)linkedList.get(v-1),newDistance));
                  }

              }

          }


        for (int i = 1; i < path.length; i++) {
            System.out.println("Node : "+i+" Distance : " + distance[i] +"  "+ "path :" +path[i]);
        }
     }


    public static void main(String args[]){

       new DijiktrasAlgorithms(6).printDijiktrasAlgorithms();
    }
}

class GraphNode{

    int name;
    int value;

    public GraphNode(int name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}