package com.algorithm.graphs;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by anurag on 09/06/19.
 */


class BFSGraph{


    int vertexCount ;
    int adjMatrix[][] = new int[5][5];
    Queue<Integer> stack = new ArrayBlockingQueue<Integer>(5);
    static int count =0;
    Node vertexLists [] = new Node[5];
    public BFSGraph(int vertexCount) {

        this.vertexCount = vertexCount;
//        for (int i = 0; i <vertexCount ; i++) {
//            for (int j = 0; j <vertexCount ; j++) {
//                adjMatrix[i][j]=0;
//            }
//        }
    }
    public void addVertex(int data){
        vertexLists[count++] = new Node(data);
    }

    public void addEdge(int start,int end){
        adjMatrix[start][end]=1;
        adjMatrix[end][start]=1;
    }

    public void printNode(int v){

        System.out.println(vertexLists[v].tag);
    }


    public void bfs(){

        vertexLists[0].isVisited=true;
        stack.offer(0);
        printNode(0);

        while(!stack.isEmpty()){
            int v = checkWhetherItsVistited(stack.peek());
            if(v==-1)
                stack.poll();
            else{
                vertexLists[v].isVisited=true;
                stack.offer(v);
                printNode(v);
            }
        }
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int checkWhetherItsVistited(int v){

        for (int i = 0; i < vertexCount; i++) {
            if(adjMatrix[v][i]==1 && !vertexLists[i].isVisited){
                return i;
            }
        }
        return -1;
    }
}
public class BreadthFirstSearch {


    public static void main(String args[]){



        BFSGraph dfsGraph = new BFSGraph(5);
        dfsGraph.addVertex(1);
        dfsGraph.addEdge(0,1);
        dfsGraph.addVertex(2);
        dfsGraph.addEdge(1,2);
        dfsGraph.addVertex(3);
        dfsGraph.addEdge(0,3);
        dfsGraph.addVertex(4);
        //dfsGraph.addEdge(1,3);


        dfsGraph.bfs();

    }
}
