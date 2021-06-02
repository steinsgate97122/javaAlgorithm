package demo16Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    //构造方法
    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //插入边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回顶点的个数
    public int getNumOfVertexes() {
        return vertexList.size();
    }

    //返回边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回两个节点之间的权重
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //根据下标获取节点
    public String getValueByIndex(int v1) {
        return vertexList.get(v1);
    }

    //查看邻接矩阵
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    //找到节点的第一个邻接节点
    public int getFirstNeighbor(int v1) {
        for (int i = 0; i < getNumOfVertexes(); i++) {
            if (edges[v1][i] != 0) {
                return i;
            }
        }
        return -1;
    }

    //找到节点的下一个邻接节点，前一个是v2
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < getNumOfVertexes(); i++) {
            if (edges[v1][i] != 0) {
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历 迭代进行 从i节点开始
    public void dfs(int i, boolean[] isVisited) {
        //先输出当前节点
        System.out.println(getValueByIndex(i));
        isVisited[i] = true;
        //从i节点开始，找到第一个邻接节点
        int w = getFirstNeighbor(i);
        while (w != -1) {
            //判断w有没有被访问过
            if (!isVisited[w]) {
                dfs(w, isVisited);
            }
            //w已经访问过
            w = getNextNeighbor(i, w);
        }
    }

    //重载一个dfs，考虑到非连通图，将所有节点都作为起始节点，调用上面的dfs方法
    public void dfs() {
        isVisited = new boolean[getNumOfVertexes()];
        for (int i = 0; i < getNumOfVertexes(); i++) {
            //如果i节点没有被访问过，那么作为起点调用一下
            if (!isVisited[i]) {
                dfs(i, isVisited);
            }
        }
    }

    //广度优先
    public void bfs(int i, boolean[] isVisited) {
        //先访问当前节点
        System.out.println(getValueByIndex(i));
        isVisited[i] = true;
        //入队列，队列里面都是已经访问过的
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(i);

        while (!queue.isEmpty()){
            int u = queue.removeFirst();
            //找到u的第一个邻接节点
            int w = getFirstNeighbor(u);
            while (w != -1){ //访问到了
                //判断w是否已经访问过
                if(!isVisited[w]){ //没访问过，访问一下，然后加入队列
                    System.out.println(getValueByIndex(w));
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //找到u的下一个邻接节点
                w = getNextNeighbor(u,w);
            }
        }
    }

    //重载一下bfs，对每个节点遍历一遍
    public void bfs() {
        isVisited = new boolean[getNumOfVertexes()];
        for (int i = 0; i < getNumOfVertexes(); i++) {
            if(!isVisited[i]) {
                bfs(i, isVisited);
            }
        }
    }
}
