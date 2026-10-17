import java.util.*;
class Solution {
    public boolean solution(String s) {
        
        boolean answer = true;
        //조건1 : s 길이는 4 혹은 6 
        if(s.length()!=4 && s.length()!=6){ 
            return false;
        }   
        
        //조건2 : s는 숫자로만 구성
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)) {
                return false;
            }
        }
        return answer;
    }
}