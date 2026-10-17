import java.util.*;
class Solution {
    public String solution(String s, int n) {
            
        StringBuilder answer = new StringBuilder(s.length());
        List<Character> list = new ArrayList<>();
        
        for(char c : s.toCharArray()){
            list.add(c);
        }

        for(char c : list){  
            //공백인가?
            if(c == ' ') {
                answer.append(c);
                continue;
            }
            //소문자인가?
            if(Character.isLowerCase(c)){
                answer.append((char)('a' + (c + n -'a') % 26));
            }
            //대문자인가?    
            if(Character.isUpperCase(c)){
                answer.append((char)('A' + (c + n -'A') % 26));
            }  
        }
        return answer.toString();
    }
}