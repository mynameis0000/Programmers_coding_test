import java.util.*;

class Solution {
    
    private boolean[][] graph;
    
    public int solution(int n, int[][] wires) {
        graph = new boolean[n+1][n+1];
        
        //연결
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }
        
        int minDiff= n;
        
        for(int[] wire: wires){
            int v1 = wire[0];
            int v2 = wire[1];
            
            //전선 임시 중단
            graph[v1][v2] = false;
            graph[v2][v1] = false;
            
            int myCount = bfs(1, n);
            
            int diff = Math.abs(myCount - (n- myCount));
            minDiff = Math.min(minDiff, diff);
            
            //전선 복구
            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }
        return minDiff;
    }
    
    private int bfs(int startNode, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        queue.offer(startNode);
        visited[startNode] = true;
        int count = 1;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next=1; next<=n; next++){
                if(graph[current][next] && !visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}