package demo22Prim;

import java.util.ArrayList;

public class PrimAlgorithm {
    public static void main(String[] args) {
        int vertexNumber = 7;
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weights = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        MGraph graph = new MGraph(vertexNumber);
        for (char vertex : vertexes) {
            graph.insertVertex(vertex);
        }
        graph.setWeights(weights);
        MGraph minGraph = prim(graph, 6);
        minGraph.showWeights();
    }

    //prim算法，找到最小生成图，返回一个最小生成树对象，v代表算法的起始顶点
    public static MGraph prim(MGraph graph, int v){
        MGraph minGraph = new MGraph(graph.vertexNumber);
        minGraph.insertVertex(graph.vertexList.get(v));
        int[] visited = new int[graph.vertexNumber];
        visited[v] = 1;
        for(int k = 1; k < graph.vertexNumber; k++){
            //需要找到num-1条边
            //将权值初始化为10000
            int minWeight = 10000;
            //将边的顶点下标初始化
            int h1 = -1;
            int h2 = -1;
            for(int i = 0; i<graph.vertexNumber;i++){
                if(visited[i] == 0){
                    //当i未访问过时，直接进入下一次循环
                    continue;
                }
                for(int j = 0;j<graph.vertexNumber;j++){
                    if(visited[j] == 0 && graph.weights[i][j] < minWeight){
                        //当j未访问过时，才进行进一步判断，判断当前边的权重是否更小
                        minWeight = graph.weights[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //出循环时，找到最小的边了，是h1到h2的边
            //将h2标记为已访问
            visited[h2] = 1;
            //输出对应信息
            System.out.println("边:"+graph.vertexList.get(h1)+graph.vertexList.get(h2)+"的权重为"+minWeight);
            //同时将其加入到minGraph中
            minGraph.insertVertex(graph.vertexList.get(h2));
            minGraph.insertEdge(h1,h2,minWeight);
        }
        return minGraph;
    }
}

class MGraph {
    ArrayList<Character> vertexList;
    int[][] weights;
    int vertexNumber;

    public MGraph(int n) {
        vertexList = new ArrayList<Character>(n);
        weights = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<n ; j++){
                weights[i][j] = 10000;
            }
        }
        vertexNumber = n;
    }

    //插入节点
    public void insertVertex(char vertex) {
        vertexList.add(vertex);
    }

    //插入边
    public void insertEdge(int v1, int v2, int weight) {
        weights[v1][v2] = weight;
        weights[v2][v1] = weight;
    }

    //设置邻接矩阵
    public void setWeights(int[][] weights) {
        this.weights = weights;
    }

    //写一个方法，用来输出邻接矩阵
    public void showWeights(){
        for (int[] row : weights) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}