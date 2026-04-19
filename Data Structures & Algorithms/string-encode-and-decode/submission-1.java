class Solution {

        public String encode(List<String> strs) {
            if (strs.isEmpty()) return "";
            var res = new StringBuilder();
            List<Integer> sizes = new ArrayList<>();
            strs.forEach(s -> sizes.add(s.length()));
            sizes.forEach(n -> res.append(n).append(','));
            res.append('#');
            strs.forEach(res::append);
            return res.toString();
        }

        public List<String> decode(String str) {
            if (str.isEmpty()) return new ArrayList<>();

            List<String> res = new ArrayList<>();
            List<Integer> sizes = new ArrayList<>();
            int i = 0;

            while (str.charAt(i) != '#') {
                var temp = new StringBuilder();
                while (str.charAt(i) != ',') {
                    temp.append(str.charAt(i++));
                }
                sizes.add(Integer.parseInt(temp.toString()));
                i++;
            }

            i++;
            for (int size: sizes) {
                res.add(str.substring(i, i + size));
                i += size;
            }

            return res;
        }
    }