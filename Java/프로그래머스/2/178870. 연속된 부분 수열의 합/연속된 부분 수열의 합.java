import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        
        //연속된 값의 합 = 투 포인트
        int left=0;
        int rigth=0;
        int total=sequence[0];

        int min_len = sequence.length;
        int min_left=0;
        int min_rigth=0;
        
        while(rigth<sequence.length){
            
            //total==k
            if(total==k){
                //가장 짧은 길이 or 시작점이 가장 작은 것
                if(min_len>(rigth-left)){
                    min_len=rigth-left;
                    min_left=left;
                    min_rigth=rigth;
                }
                //다음을 위해 전진
                total -= sequence[left++];  
            }
            //total<k
            else if(total<k){
                rigth++;
                if (rigth < sequence.length){
                    total += sequence[rigth];
                }
            }
            //total>k
            else{
                total -= sequence[left++];    
            }
        }
        return new int[]{min_left,min_rigth};
    }
}