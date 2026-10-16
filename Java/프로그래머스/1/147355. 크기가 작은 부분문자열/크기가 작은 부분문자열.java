import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len_p = p.length();
        int len_t = t.length();
        long num = Long.parseLong(p);
        
        // t를 len_p길이만큼 자르기
        List<Long> list = new ArrayList<>();
        for (int i = 0; i <= len_t-len_p; i++) {
            list.add(Long.parseLong(t.substring(i, i + len_p)));
        }
           
        //잘라진 t값이 p보다 작은지 확인 및 카운트
        for(int i=0; i<list.size(); i++){
            if(list.get(i)<=num) answer++;
        }
        
        return answer;
    }
}