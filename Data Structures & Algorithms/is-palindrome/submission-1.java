class Solution {
    public boolean isPalindrome(String str) {
        var s = str.replaceAll("[^a-zA-Z0-9]", "");
        for(int l=0, r=s.length()-1; l<=r && l<s.length() && r>=0; l++, r--){
            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
                return false;
            }
        }
        return true;
    }
}
