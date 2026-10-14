import java.util.*;

class Solution {public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> name_wiht_num1 = new HashMap<>();
        HashMap<String, Integer> name_wiht_num2 = new HashMap<>();

        //중복 거르기
        for(String par : participant){
            name_wiht_num1.put(par, name_wiht_num1.getOrDefault(par,0)+1);}
        for(String com : completion){
            name_wiht_num2.put(com, name_wiht_num2.getOrDefault(com,0)+1);}

        for(String par : name_wiht_num1.keySet()){
            if(!Objects.equals(name_wiht_num1.get(par), name_wiht_num2.get(par))) 
                answer = par;
        }
        return answer;
    }
} 