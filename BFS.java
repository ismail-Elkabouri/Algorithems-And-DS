
// DFS algorithm implementation writen by 伊斯玛
import java.util.LinkedList;
import java.util.Queue;

class BFS {
  public   int v ;
  private  LinkedList<Integer> graph[] ;
  
  @SuppressWarnings ("unchecked") BFS(int v) {
    this.v = v;
    graph = new LinkedList[v];
    for (int i = 0; i < v ; i++) {
        graph[i] = new LinkedList<>();
    }
  }

  public  void addEdge ( int v , int w) {
    graph[v].add(w);
  }

  public  void bfs(int startVetix) {

    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[v];
    visited[startVetix] = true;
    System.out.print(startVetix + " ");
    queue.add(startVetix);

    while (!queue.isEmpty()) {
      int currentVertix = queue.poll();
      if (!visited[currentVertix]) {
        visited[currentVertix] = true;
        System.out.print( currentVertix + " ");
      }

      for ( int nextVertix : graph[currentVertix]) {
        if (!visited[nextVertix]) {
            queue.add(nextVertix);
        }
      }
  
    }
  }

  public static void main(String [] args) {

    int vertices = 5;
    BFS graph = new BFS(vertices);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 4);

    System.out.println("BFS search starting from 0 is : ");
    graph.bfs(0);
  }
}
