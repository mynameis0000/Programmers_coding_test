//k명을 명예의 전당에 올림
//발표 점수 = 최하위 점수
//score.length = 일수 

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        int day = score.length;
        
        for(int i=0; i<day; i++){
            pq.add(score[i]);
            if(pq.size()>k){
                pq.poll();
            }
            list.add(pq.peek());
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}