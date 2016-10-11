public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        Set<String> result = new HashSet<>();
        if (s == null || s.length() < 2) return new ArrayList<String>();
        String left = s.substring(0, 2);
        if (left.equals("++")) {
            result.add("--" + s.substring(2));
        }
        for (String mid : generatePossibleNextMoves(s.substring(1, s.length() - 1))) {
            result.add(s.substring(0, 1) + mid + s.substring(s.length() - 1));
        }
        String rh = s.substring(s.length() - 2);
        if (rh.equals("++")) {
           result.add(s.substring(0, s.length() - 2) + "--");
        }
        List<String> res = new ArrayList<>();
        for (String move : result) {
            res.add(move);
        }
        return res;
    }
}