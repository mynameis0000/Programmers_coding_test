import java.util.*;

class Solution {
    public String solution(String new_id) {
        //1단계
        String answer = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        List<Character> ignoreList = List.of('-', '_', '.');
        
        //2단계
        for(char ch : answer.toCharArray()){
            if(Character.isLowerCase(ch) || Character.isDigit(ch) || ignoreList.contains(ch))
                sb.append(ch);
        }
        
        answer = sb.toString();
        
        //3,4단계
        answer = answer.replaceAll("\\.+", ".");
        if(answer.startsWith("."))
            answer = answer.substring(1);
        if(answer.endsWith(".")) 
            answer = answer.substring(0, answer.length() - 1);
        
        //5단계
        if (answer.isEmpty()) {
            answer = "a";
        }
            
        //6단계
        if(answer.length()>=16){
            answer = answer.substring(0, 15);
            if (answer.endsWith("."))
                answer = answer.substring(0, answer.length() - 1);
        }
            
        //7단계
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }
            
        
        return answer;
    }
}