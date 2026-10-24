//1:55
class Solution {
    public int solution(int n, int[][] computers) {
        //방문 확인
        boolean[] visited= new boolean[n];
        int answer = 0;
        
        //전체 순회
        for(int i=0; i<n; i++){
            if(visited[i]==false) {
                answer++;
                dfs(i, computers, visited, n);
            }
        }
        return answer;
    }
    
    private void dfs(int current,int[][] computers, boolean[] visited, int n){
        visited[current] = true;
        for(int i=0; i<n; i++){
            if(computers[current][i]==1 && !visited[i])
                dfs(i, computers, visited, n);
        }
    }
}