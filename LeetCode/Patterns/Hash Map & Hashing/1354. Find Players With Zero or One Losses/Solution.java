class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> losses = new HashMap<>();
        Set<Integer> players = new HashSet<>();
        for(int[] match : matches){
            int winner = match[0];
            int losser = match[1];
            players.add(winner);
            players.add(losser);
            losses.put(losser, losses.getOrDefault(losser,0)+1);
        }
        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for(int player : players){
            if(!losses.containsKey(player)){
                zeroLoss.add(player);
            }
            else if(losses.get(player)==1){
                oneLoss.add(player);
            }
        }
        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zeroLoss);
        ans.add(oneLoss);
        return ans;
    }
}