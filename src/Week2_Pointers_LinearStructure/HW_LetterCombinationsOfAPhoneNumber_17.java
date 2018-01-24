class Solution {      
//By DFS. This is not optimized solution. Need to study LC solution
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        
        HashMap<String, List<String>> map = new HashMap();
        map.put("1", new ArrayList<>(Arrays.asList("1")));
        map.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        map.put("*", new ArrayList<>(Arrays.asList("*")));
        map.put("0", new ArrayList<>(Arrays.asList("0")));
        map.put("#", new ArrayList<>(Arrays.asList("#")));
        
        helper(digits, new StringBuilder(), res, map);
        return res;
    }
    
    private void helper(String digits, StringBuilder path, List<String> result, HashMap<String, List<String>> map) {
        if (digits.equals("")) {
            result.add(path.toString());
            return;
        }
        
        String cur = digits.substring(0, 1);
        String rest = digits.substring(1);
        
        List<String> strs = map.get(cur);
        
        for (String str : strs) {
            path.append(str);
            helper(rest, path, result, map);
            path.deleteCharAt(path.length() - 1);
        }        
    }
}
