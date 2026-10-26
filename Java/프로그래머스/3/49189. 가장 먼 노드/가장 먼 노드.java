//BFS를 사용할 때, 최단으로 닿는 바닥 = 가장 먼 노드
//1번과 가장 멀리 떨어져 있는 노드.

//Node로 묶기
//BFS시도 

import java.util.*;

class Solution {
    
    public class Node{
        int n;
        int dist = -1;
        List<Node> links = new ArrayList<>();
        Node(int n){
            this.n = n;
        }
    }
    
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        //노드 생성
        List<Node> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new Node(i));
        }
        //간선 연결
        for(int[] e: edge){
            Node nodeA = list.get(e[0]);
            Node nodeB = list.get(e[1]);

            nodeA.links.add(nodeB); // A의 이웃에 B 추가
            nodeB.links.add(nodeA);
        }
        
        Queue<Node> queue = new LinkedList<>();
        Node start = list.get(1); 
        start.dist = 0;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            Node current = queue.poll(); 
            for(Node next : current.links){
                if(next.dist == -1){
                    next.dist = current.dist + 1;
                    queue.offer(next);
                }
            }
        }
            
        int maxDist = 0;
        for(int i=1; i<=n; i++){
            maxDist = Math.max(maxDist, list.get(i).dist);
        }
            
        for(int i=1; i<=n; i++){
            if(list.get(i).dist == maxDist){
                answer++;
            }
        }
        
        return answer;
    }
}