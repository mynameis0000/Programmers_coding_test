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
            if(c == ' ') {answer.append(c);}
            else{
            
                int change = (int)c + n;
            
                //소문자인가?
                if(Character.isLowerCase(c)){
                    //범위를 넘었다면
                    if(change>122) {
                        change = change-122+97-1;
                    }
                }
                //대문자인가?    
                if(Character.isUpperCase(c)){
                    //범위를 넘었다면
                    if(change>90) {
                        change = change-90+65-1;   
                    }
                }  
            answer.append((char)change);
            }
        }
        return answer.toString();
    }
}