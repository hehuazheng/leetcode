class NumArray {
    static class LineSegment {
        LineSegment left;
        LineSegment right;
        int start;
        int end;
        int sum;
    }

    LineSegment ls = null;

    public NumArray(int[] nums) {
        ls = buildLineSegment(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        doUpdate(ls, i, val);
    }

    void doUpdate(LineSegment ls, int i, int val) {
        if(ls.start == ls.end) {
            ls.sum = val;
        } else {
            int mid = (ls.start + ls.end)/2;
            if(mid < i) {
                doUpdate(ls.right, i, val);
            } else {
                doUpdate(ls.left, i, val);
            }
            ls.sum = ls.left.sum + ls.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return doSumRange(ls, i, j);
    }

    int doSumRange(LineSegment ls, int i, int j) {
        if(ls.start == i && ls.end == j) {
            return ls.sum;
        }
        int mid = (ls.start + ls.end) / 2;
        if(j <= mid) {
            return doSumRange(ls.left, i, j);
        }
        if(i >= mid+1) {
            return doSumRange(ls.right, i, j);
        }
        return doSumRange(ls.left, i, mid) + doSumRange(ls.right, mid+1, j);
    }

    LineSegment buildLineSegment(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        if(start == end) {
            LineSegment ls = new LineSegment();
            ls.start = start;
            ls.end = end;
            ls.sum = nums[start];
            return ls;
        }
        int mid = (start + end)/2;
        LineSegment ls = new LineSegment();
        ls.left = buildLineSegment(nums, start, mid);
        ls.right = buildLineSegment(nums, mid + 1, end);
        ls.sum = ls.left.sum + ls.right.sum;
        ls.start = start;
        ls.end = end;
        return ls;
    }

    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{0,9,5,7,3});
        System.out.println("end");
    }
}