package com.algorithm.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.Float.NaN;
/**
 * Created by anurag on 23/06/19.
 */
public class FloydWarshalAlgorithm {

    final static int INF = 99999;

    int adjMatrix[][]=  {{0,   5,  INF, 10},
            {INF, 0,   3, INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0} };

    int nodes[][] = new int[4][4];

    public FloydWarshalAlgorithm() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nodes[i][j] = adjMatrix[i][j];
            }

        }

        for (int k = 0; k < 4; k++) {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    if(nodes[i][k] + nodes[k][j] < nodes[i][j]){
                        nodes[i][j] = nodes[i][k] + nodes[k][j];
                    }
                }

            }
        }

        for (int i=0; i<4; ++i)
        {
            for (int j=0; j<4; ++j)
            {
                if (nodes[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(nodes[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){

        FloydWarshalAlgorithm floydWarshalAlgorithm = new FloydWarshalAlgorithm();
       // floydWarshalAlgorithm.F
    }
}
