import java.util.*;

class Solution {public String solution(String[] participant, String[] completion) {
        //이름, 등장횟수, 중복 여부를 확인해야 함 - hashmap
        HashMap<String, Integer> map = new HashMap<>();
    
        //참가자 카운트
        for(String par : participant){
            map.put(par, map.getOrDefault(par,0)+1);
        }
        //완주자 제거
        for(String com : completion){
            map.put(com, map.get(com)-1);
        }
        //0이 아닌 사람(-1 이하 혹은 1이상) 찾기
        for(String key: map.keySet()){
            if(map.get(key)!=0) return key;
        }
        return "";
    }
} 