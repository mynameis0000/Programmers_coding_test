import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        //종류/개수 분류
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes){
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        
        int answer=1;
        //모든 경우의 수 =  착장 안 하기, 착장a, 착장b...
        for(int cloth: map.values()){
            answer *= cloth+1;
        }   
        
        //모든 경우의 수 -1 (아무것도 착용 안 하기)
        return answer-1;
    }
}


