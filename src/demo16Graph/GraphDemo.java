package demo16Graph;

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] arr = {"A", "B", "C", "D", "E"};

        for (String vertex : arr) {
            graph.insertVertex(vertex);
        }
        //0-1 0-2 1-2 1-3 1-4
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(2, 1, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        graph.showGraph();

        System.out.println("深度优先：");
        graph.dfs();
        System.out.println("广度优先：");
        graph.bfs();
    }
}
