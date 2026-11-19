import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        //상태
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        //행동
        while(!q.isEmpty()){
            //current
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            //endpoint
            if(x==N-1 && y==M-1){
                return dist;
            }
            
            //next
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                //조건
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(maps[nx][ny]==0 || visited[nx][ny]) continue;                
                
                //complete
                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny, dist+1});
            }
        }
    return -1;
    }
}