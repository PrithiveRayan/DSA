package graph;

public class GraphMain {
    public static void main(String[] args) {

        int[][] graph = {
                {0,1,0,0,1},
                {1,0,1,0,1},
                {0,1,0,1,0},
                {0,0,1,0,1},
                {1,1,0,1,0},
        };

        GraphUsingLL lg1 = new GraphUsingLL(5);
        lg1.addEdge(0,1);
        lg1.addEdge(2,3);
        lg1.addEdge(2,2);
        lg1.addEdge(3,4);
        lg1.addEdge(0,4);
        lg1.addEdge(1,4);

        lg1.printAdjList();

        lg1.bfs(0);
        System.out.println();
        lg1.dfs(0);
    }
}
