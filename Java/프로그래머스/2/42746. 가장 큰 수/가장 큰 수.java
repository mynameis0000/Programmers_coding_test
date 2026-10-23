import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. int 배열을 String 배열로 변환
        List<String> list = new ArrayList<>();
        for(int num : numbers){
            list.add(String.valueOf(num));
        }
        

        // 2. 두 문자를 합쳤을 때 더 큰 조합이 앞으로 오도록 내림차순 정렬
        list.sort((s1, s2) -> (s1+s2).compareTo(s2+s1));


        // 3. [0, 0, 0] 케이스 예외 처리 (맨 앞이 0이면 결과는 무조건 "0")
        int count=0;
        for(String str : list){
            if(str.equals("0")) count++; 
        }
        if(count==list.size()) return "0";

        // 4. 문자열 합치기
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i));
        }
        
        return sb.toString();
    }
}