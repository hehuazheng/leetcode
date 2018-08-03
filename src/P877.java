public class P877 {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int i : piles) {
            sum += i;
        }
        int[][] tb = new int[piles.length][piles.length];
        int max = recur(piles, 0, piles.length - 1, tb);
        return max > sum / 2;
    }

    public int recur(int[] piles, int start, int end, int[][] tb) {
        if (end == start + 1) {
            return piles[start] > piles[end] ? piles[start] : piles[end];
        }
        if (tb[start][end] > 0) {
            return tb[start][end];
        }
        // Alex first Lee first
        int max1 = piles[0] + recur(piles, start + 2, end, tb);
        // Alex first Lee Last
        int max2 = piles[0] + recur(piles, start + 1, end - 1, tb);
        // Alex Last Lee First
        int max3 = piles[end] + recur(piles, start + 1, end - 1, tb);
        // Alex Last Lee Last
        int max4 = piles[end] + recur(piles, start, end - 2, tb);
        int max = max1;
        if (max < max2) {
            max = max2;
        }
        if (max < max3) {
            max = max3;
        }
        if (max < max4) {
            max = max4;
        }
        tb[start][end] = max;
        return max;
    }

    public static void main(String[] args) {
        P877 p = new P877();
        System.out.println(p.stoneGame(new int[]{5, 3, 4, 5}));
    }
}
