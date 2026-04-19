class Solution {

    public String encode(List<String> strs) {
        var res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        var res = new ArrayList<String>();
        while (i < str.length()) {
            int j=i;
            while (str.charAt(j) != '#') {
                j++;
            }
            var length = Integer.valueOf(str.substring(i, j));
            i = j+length+1;
            res.add(str.substring(j+1, i));
        }
        return res;
    }
}
