package com.algorithm.graphs;

import java.util.*;

/**
 * Created by anurag on 09/06/19.
 */
public class AdjacencyList {


    private static int vertexCount;
    private static List ls = new ArrayList();
    private static List<Integer> [] list;
    private static List<Integer> [] list1;
    private int weight ;

    public AdjacencyList(int vertexCount) {
        this.vertexCount = vertexCount;

        list = new List[vertexCount+1];
        list1= new List[vertexCount+1];

        for (int i = 1; i <= vertexCount; i++) {

            ls.add(i);
            list[i] = new LinkedList();
            list1[i] = new LinkedList();
        }

    }


    public static void addEdge(int source , int destination, int weight){


      /*  int i = ls.indexOf(source);
        int j = ls.indexOf(destination);

        if(i!=-1 || j!=-1){*/

           list[source].add(destination);
           list1[source].add(weight);
     //   }
        weight = weight;

    }

    public static List[] getEdgeValue(){
        return list1;
    }
    public static List[] getEdgeList(){
        return list;
    }
    public static void main(String args[]){

     /*   Comparator<value> valueComparator = (value v1 , value v2) ->{

            if(v1.getValue()> v2.getValue())
                return -1;
                return 1;
        };

        PriorityQueue<value> pq = new PriorityQueue<>(valueComparator);
        pq.offer(new value(1,2));
        pq.offer(new value(2,1));
        pq.offer(new value(3,5));
        pq.offer(new value(4,3));

        value v = pq.poll();
*/
   //     System.out.println("After Sorting :  " + v);

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.offer(2);
        pq1.offer(1);
        pq1.offer(5);
        pq1.offer(3);

        System.out.println("Before sorting: " + pq1.poll());

    }

}

/*
class value{

    int name;
    int value;

    public value(int name, int value) {
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

    @Override
    public String toString() {
        return "value{" +
                "name=" + name +
                ", value=" + value +
                '}';
    }
}*/
