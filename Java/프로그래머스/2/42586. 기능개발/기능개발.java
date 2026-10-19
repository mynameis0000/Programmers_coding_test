import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
         //progresses[index]가 끝나는 날 확인
        //뒤에 있는 progresses의 끝나는 날 순서대로 확인.
            //progresses[0]보다 작거나 같은 값이면 index++, count++
            //progresses[0]보다 크면 break;
        int finish = 0;
        int count=1;
        int relese_day=0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++){
            finish = (100-progresses[i]) / speeds[i];
            if((100-progresses[i]) % speeds[i]!=0) finish++;
            queue.offer(finish);
        }
        
        relese_day = queue.poll();
        
        // 2. 큐가 빌 때까지 다음 기능들과 비교
        while (!queue.isEmpty()){
            
            if(relese_day>=queue.peek()){
                count++;
                queue.poll();
            }
            else {
                list.add(count);
                relese_day = queue.poll();
                count=1;
            }
            System.out.println(relese_day +"/"+ count +"/"+list);
           
        }
        // 3. 루프가 끝난 뒤 마지막 남아있는 묶음 추가
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}