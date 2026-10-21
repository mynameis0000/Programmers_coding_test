import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length==1)
            return new int[]{-1};
        
        //가장 작은 수를 삭제 후 리턴
        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        
        list.sort(Comparator.naturalOrder());
        int min = list.get(0);
        
        int[] answer = new  int[arr.length-1];
        
        int count=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=min) {
                answer[count] = arr[i];
                count++;
            }
        }
        return answer;
    }
}