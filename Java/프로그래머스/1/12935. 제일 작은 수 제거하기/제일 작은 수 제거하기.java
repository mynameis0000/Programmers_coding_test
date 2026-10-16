import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        //순서가 중요, set 사용하면 안됨
        //최소값을 찾기
        int min = arr[0];
        for(int i : arr){
            if(min>i){
                min=i;
            }
        }
        
        //최솟값 제외하고 List에 넣기
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(i!=min){
                list.add(i);
            }
        }
        
        //List -> int[]로 바꾸기
        int[] answer = new int[list.size()];
        if(list.size()==0)  {
                return new int[]{-1};
            }
        else{
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
}