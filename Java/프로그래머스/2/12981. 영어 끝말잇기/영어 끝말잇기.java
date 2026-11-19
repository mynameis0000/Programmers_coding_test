//중복x
//한 글자x
//탈락자 없으면 [0,0]

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();

        set.add(words[0]);
        String old = words[0];
        
        for (int i = 1; i < words.length; i++) {
            String str = words[i];
            if(old.charAt(old.length()-1)!=str.charAt(0)
              ||set.contains(str)
              ||str.length() == 1){
                return new int[]{(i%n)+1, (i/n)+1};
            }
            set.add(str);
            old = str;
        }
        //탈락자가 없음
        return new int[]{0, 0};
    }
}