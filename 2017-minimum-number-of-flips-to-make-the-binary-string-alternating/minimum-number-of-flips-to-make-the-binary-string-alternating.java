class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;
        int count0 = 0, count1 = 0;

        for (int j = 0; j < n; j++) {
            char expected = t.charAt(j);

            if (expected != (j % 2 == 0 ? '0' : '1')) count0++;
            if (expected != (j % 2 == 0 ? '1' : '0')) count1++;
        }

        int min_flips = Math.min(count0, count1);

        for (int i = 1; i < n; i++) {
            char old_char = t.charAt(i - 1);
            char new_char = t.charAt(i + n - 1);

            int contrib0 = (old_char != '0') ? 1 : 0;
            int contrib1 = (old_char != '1') ? 1 : 0;

            boolean last_pos_char = ((n - 1) % 2 == 0);

            int new_contrib0 = (new_char != (last_pos_char ? '0' : '1')) ? 1 : 0;
            int new_contrib1 = (new_char != (last_pos_char ? '1' : '0')) ? 1 : 0;

            count0 = (n - 1) - (count0 - contrib0) + new_contrib0;
            count1 = (n - 1) - (count1 - contrib1) + new_contrib1;

            min_flips = Math.min(min_flips, Math.min(count0, count1));
        }

        return min_flips;
    }
}