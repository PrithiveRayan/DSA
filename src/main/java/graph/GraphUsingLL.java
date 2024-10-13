package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphUsingLL {

    List<List<Integer>> adjList = new ArrayList<>();

    GraphUsingLL(int size){
        for(int i=0; i<size; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printAdjList(){
        for(List i : adjList){
            System.out.println(i.toString());
        }
    }

    public void bfs(int v){
        int size = adjList.size(); // total number of vertices
        boolean[] visited = new boolean[size];

        visited[v] = true;

        Queue<Integer> que = new LinkedList<>();
        que.add(v);

        while(que.size() != 0){
            int vertex = que.remove();
            System.out.print(vertex + " ");
            for(int i=0; i<adjList.get(vertex).size(); i++){
                int av = adjList.get(vertex).get(i);
                if(!visited[av]){
                    que.add(av);
                    visited[av] = true;
                }
            }
        }
    }

    public void dfs(int v){

        int size = adjList.size(); // total number of vertices
        boolean[] visited = new boolean[size];
        dfs(v, visited);

    }

    public void dfs(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+" ");
        for(int i=0; i<adjList.get(v).size(); i++){
            int av = adjList.get(v).get(i);
            if(!visited[av]){
                dfs(av, visited);
            }

        }

    }
}
