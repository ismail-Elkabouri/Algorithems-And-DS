
// DFS algorithm implementation writen by 伊斯玛

import java.util.LinkedList;
import java.util.Stack;

 class DFS {
    // DFS need three method
    // we need a constractor to initialize the graph.
    private int V;
    private  LinkedList<Character> graph[];

    @SuppressWarnings ("unchecked") DFS(int v) {
        V = v;
        graph = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    // add edges into the graph addEdge().
    public  void addEdge(char vertix1, char vertix2) {
        int index1 = vertix1 - 'A';
        int index2 = vertix2 - 'A';
        graph[index1].add(vertix2);
        graph[index2].add(vertix1);
    }

    // dfs(); function 
    public  void dfs(char currentVertix) {

        boolean[] visited = new boolean[V];
        Stack<Character> stack = new Stack<>();
        stack.push(currentVertix);

        while (!stack.isEmpty()) {
            currentVertix = stack.pop();
            int index = currentVertix - 'A';

            if (!visited[index]) {
                visited[index] = true;
                System.out.print(currentVertix + " ");

                for (char nextVertix : graph[index]) {
                    if (!visited[nextVertix - 'A'])
                        stack.push(nextVertix);
                }
            }
        }

    }

    // main();

    public static void main(String[] args) {
        char startVetix = 'A';
        DFS obj = new DFS(10);
        obj.addEdge('A', 'B');
        obj.addEdge('A', 'C');
        obj.addEdge('B', 'A');
        obj.addEdge('C', 'E');
        obj.addEdge('C', 'F');
        obj.addEdge('E', 'E');
        obj.addEdge('E', 'F');
        obj.addEdge('F', 'E');
        obj.addEdge('F', 'E');
        System.out.println("The DFS search withen this graph is : ");
        obj.dfs(startVetix);

    }

}
