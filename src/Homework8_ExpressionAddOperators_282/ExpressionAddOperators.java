//https://segmentfault.com/a/1190000003797204
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }
    
    public void helper(List<String> res, String path, String num, int target, int pos, long preResult, long multied) {
        if (pos == num.length()) {
            if(preResult == target) {
                res.add(path);
            }
            return;            
        }

        for (int i = pos; i < num.length(); i++) {
            //["1*0+5", "1*5", "10-5"] ==> correct aws: ["1*0+5","10-5"]
            //          105
            //   1          10       105
            // 0  05(skip)   5
            //5
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));      //05 -> 5     
            
            if (pos == 0) {
                helper(res, path + cur, num, target, i + 1, cur, cur);              
            } else {
                helper(res, path + "+" + cur, num, target, i + 1, preResult + cur,  cur);
                helper(res, path + "-" + cur, num, target, i + 1, preResult - cur, -cur);
                helper(res, path + "*" + cur, num, target, i + 1, (preResult - multied) + cur * multied , multied * cur);
                
                //for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, 
                //now your eval is 6 right? If you want to add a * between 3 and 4, 
                //you would take 3 as the digit to be multiplied, so you want to take it out from the existing eval. 
                //You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4). 
            }                                
        }
    }
}
