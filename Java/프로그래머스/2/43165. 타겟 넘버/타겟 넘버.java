class Solution {
    
    int answer = 0;
    
    private void dfs(int[] numbers, int target, int depth, int sum){
     
        //모든 수를 다 사용했을 때
        if(depth == numbers.length) {
            if (sum == target) {
                answer++; // 일치하면 카운트 증가
            }
            return;
        }
        //모든 수를 사용하지 않았다면 다음 트리로 이동
        dfs(numbers, target, depth+1, sum+numbers[depth]);
        dfs(numbers, target, depth+1, sum-numbers[depth]);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);    
        return answer;
    }
}