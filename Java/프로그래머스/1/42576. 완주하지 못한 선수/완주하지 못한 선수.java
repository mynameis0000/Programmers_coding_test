import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String par : participant){
            map.put(par, map.getOrDefault(par,0) + 1);
        }

        //!
        for(String person : completion){
            map.put(person, map.getOrDefault(person,0) -1);
        }
        
        //!
        for(String par : map.keySet()){
            if(map.get(par)!=0){
                return par;
            }
        }
        return answer;
    }
}