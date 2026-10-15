import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
        
        for(String player: callings){
            int back_index = rankMap.get(player);
            String front_string = players[back_index-1];

            players[back_index-1] = players[back_index];
            players[back_index] = front_string;
            rankMap.put(player, back_index-1);
            rankMap.put(front_string, back_index);
        }
        return players;
    }
}