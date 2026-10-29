//3.25

import java.util.*;

class Solution {
    
    
    
    public class Node{
        int m;
        boolean visited = false;
        List<Node> win = new ArrayList<>();
        List<Node> lose = new ArrayList<>();
        Node(int m) {this.m = m;}
    }
    
    public int bfs(Node startNode, boolean isWin, int n) {
        //승패 여부에 따른 win, lose 개수 세기
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(startNode);
        visited[startNode.m] = true;
        
        int result_count = 0;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // isWin 여부에 따라 다음으로 갈 후보 리스트 결정
            List<Node> nextList = isWin ? current.win : current.lose;
            
            for (Node next : nextList) {
                // 아직 방문하지 않은 연결 노드만 큐에 추가
                if (!visited[next.m]) {
                    visited[next.m] = true;
                    queue.offer(next);
                    result_count++;
                }
            }
        }
        return result_count;
    }
    
    
    public int solution(int n, int[][] results) {
        //노드 생성
        List<Node> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new Node(i));
        }
        
        //노드 내에 win, lose 노드를 생성
        for(int[] result : results){
            Node winner = list.get(result[0]);
            Node loser = list.get(result[1]);
            
            winner.win.add(loser);
            loser.lose.add(winner);
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int win_count = bfs(list.get(i), true, n);
            int lose_count = bfs(list.get(i), false, n);
            
            if (win_count + lose_count == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}