//1:00
import java.util.*;

class Solution {
    
    //Dx, Dy
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        bfs(maps, n, m);
        if(maps[n-1][m-1] == 1) return -1;
        return maps[n-1][m-1];
    }
    
    //bfs
    private void bfs(int[][] maps, int n, int m){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        
        //모든 쿼리를 다 사용할 때 까지
        while(!queue.isEmpty()){    
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            //도착하면 멈추기
            if(cx==n-1 && cy==m-1)
                return;
            
            //이동반경 확인
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                //canMove
                if(canMove(maps, nx,ny,n, m)){
                    maps[nx][ny] = maps[cx][cy] + 1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        return;
    }
    
    //canMove
    private boolean canMove(int[][] maps, int x, int y, int n, int m){
        return (isInBounds(maps, x, y, n, m) && maps[x][y]==1) ? true:false;
    }

    //isInBounds
    private boolean isInBounds(int[][] maps, int x, int y, int n, int m){
        return (x>=0 && x<n && y>=0 && y<m) ? true:false;
    }
}