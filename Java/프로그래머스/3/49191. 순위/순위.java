import java.util.*;
class Solution {
    
    public class Node{
        int n;
        boolean visited = false;
        List<Node> win = new ArrayList<>();
        List<Node> lose = new ArrayList<>();
        Node(int n){
            this.n = n;
        }
    }
    
    public int dfs(int current, List<List<Integer>> graph, boolean[] visited){
        visited[current] = true;
        int count = 1;

        for (int next : graph.get(current)) {
            if (!visited[next]) {
                count += dfs(next, graph, visited);
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] results) {
        List<List<Integer>> winList = new ArrayList<>();
        List<List<Integer>> loseList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            winList.add(new ArrayList<>());
            loseList.add(new ArrayList<>());
        }
        
        int answer = 0;
        
        for (int[] r : results) {
            int winner = r[0];
            int loser = r[1];

            winList.get(winner).add(loser);
            loseList.get(loser).add(winner);
        }
        
           for (int i = 1; i <= n; i++) {
            boolean[] visitedWin = new boolean[n + 1];
            boolean[] visitedLose = new boolean[n + 1];

            int winCount = dfs(i, winList, visitedWin) - 1;
            int loseCount = dfs(i, loseList, visitedLose) - 1;

            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}