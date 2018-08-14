public class P744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int[] arr = new int[26];
        for (int i = 0; i < letters.length; i++) {
            arr[letters[i] - 'a'] = 1;
        }
        for (int i = 0; i < 26; i++) {
            int pos = (target - 'a' + i + 1) % 26;
            if (arr[pos] == 1) {
                return (char) ('a' + pos);
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        System.out.println(new P744().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(new P744().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }
}
