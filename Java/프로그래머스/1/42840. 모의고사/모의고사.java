//3명의 수포자는 각각 정해진 찍기 방식이 존재
//정답이 주어지니, 이 문제를 가장 많이 맞춘 사람이 누구. 
//중복일 시, 오름차순.

//list
//인덱스 - n번 수포자
//내부 값 - 수포자의 찍는 패턴

//answers의 만큼 list에게 값을 패턴별로 추가해야 함
//list를 돌면서, 값이 동일하면 right++한다
//카운트 값은 answer에 넣기.

//List에 배열 인덱스 연산자([]) 사용 불가 -> List안에 List 넣기

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
                            {1, 2, 3, 4, 5},
                            {2, 1, 2, 3, 2, 4, 2, 5},
                            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
                        };
        
        
        List<List<Integer>> people = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            people.add(new ArrayList<>());
        }
        
        for(int i=0; i<answers.length; i++){
            people.get(0).add(pattern[0][i%pattern[0].length]);
            people.get(1).add(pattern[1][i%pattern[1].length]);
            people.get(2).add(pattern[2][i%pattern[2].length]);
        }
        
        
        
        int[] scores = new int[3];
        for(int person=0; person<3; person++){
            int right = 0;
            int index = 0;
            for (int i = 0; i < answers.length; i++) {
                if (people.get(person).get(i) == answers[i])
                    right++;
            }
            scores[person] = right;
        }
        
              
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        List<Integer> same_winer = new ArrayList<>();
        if (scores[0] == maxScore) same_winer.add(1);
        if (scores[1] == maxScore) same_winer.add(2);
        if (scores[2] == maxScore) same_winer.add(3);
        
        int[] answer = new int[same_winer.size()];
        for(int i=0; i<same_winer.size(); i++){
            answer[i] = same_winer.get(i);
        }
        
        return answer;
    }
}