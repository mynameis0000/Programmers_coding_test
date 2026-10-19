import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        //스타트는 언제나 (로 시작
        //( stack을 쌓고, )가 들어오면 빼주기.
        //내부에 값이 남아있다면 false
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(stack.isEmpty()){
                if(s.charAt(i)!='(') return false;
                else stack.push(s.charAt(i));
            }
            else{
                if(stack.peek()==c){
                    stack.push(c);
                }
                else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}