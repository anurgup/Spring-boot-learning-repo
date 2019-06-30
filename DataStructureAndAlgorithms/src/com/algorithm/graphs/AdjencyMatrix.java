package com.algorithm.graphs;

/**
 * Created by anurag on 09/06/19.
 */
public class AdjencyMatrix {

    private static int countVertex;
    private static  int adjMatrix[][];

    public AdjencyMatrix(int countVertex) {
        this.countVertex = countVertex;
        adjMatrix = new int[countVertex][countVertex];
    }

    public static void addAdjencyMatrix(int i,int j){

        if(i>=0&&i<countVertex && j>=0 && j<countVertex){
            adjMatrix[i][j]=1;
            adjMatrix[j][i]=1;
        }

    }

    public static void deleteAdjencyMatrix(int i,int j){

        if(i>=0&&i<countVertex && j>=0 && j<countVertex){
            adjMatrix[i][j]=0;
            adjMatrix[j][i]=0;
        }

    }

    public static boolean isEdge(int i,int j){

        if(adjMatrix[i][j]==1 && adjMatrix[j][i]==1){
            return true;
        }
      return false;
    }

    public static void main(String args[]){


        AdjencyMatrix adjencyMatrix = new AdjencyMatrix(5);
        AdjencyMatrix.addAdjencyMatrix(1,2);
        AdjencyMatrix.addAdjencyMatrix(1,3);
        AdjencyMatrix.addAdjencyMatrix(1,4);
        AdjencyMatrix.addAdjencyMatrix(2,3);
        AdjencyMatrix.addAdjencyMatrix(3,4);

        System.out.println("checking is there any Edge : " + AdjencyMatrix.isEdge(1,4) );

        AdjencyMatrix.deleteAdjencyMatrix(1,4);

        System.out.println("Afer deletion Edge will be : " + AdjencyMatrix.isEdge(1,4) );
    }
}
