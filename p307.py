class STree(object):
    def __init__(self, s, e):
        self.s = s
        self.e = e
        self.sum = 0
        self.l = None
        self.r = None
        
class NumArray(object):

    def __init__(self, nums):
        '''
        :type nums: List[int]
        '''
        def buildtree(nums, s, e):
            if s> e: return None
            tn = STree(s, e)
            if s==e: tn.sum=nums[s]
            else:
                mid = (s+e)/2
                tn.left = buildtree(nums, s, mid)
                tn.right = buildtree(nums, mid+1, e)
                tn.sum = tn.left.sum + tn.right.sum
            return tn
        self.root = buildtree(nums, 0, len(nums)-1)
            
    def update(self, i, val):
        '''
        :type i: int
        :type val: int
        :rtype: void
        '''
        def update(node, pos, val):
            if node.s == node.e:
                node.sum = val
            else:
                mid = (node.s+node.e)/2
                if pos<=mid: update(node.left, pos, val)
                else: update(node.right, pos, val)
                node.sum = node.left.sum + node.right.sum
        update(self.root, i, val)
        
    def sumRange(self, i, j):
        '''
        :type i: int
        :type j: int
        :rtype: int
        '''
        def sumRange(node, s, e):
            if node.e==e and node.s==s: return node.sum
            mid = (node.s+node.e)/2
            if e <= mid: return sumRange(node.left, s, e)
            elif s>=mid+1: return sumRange(node.right, s, e)
            else: return sumRange(node.left, s, mid) + sumRange(node.right, mid+1, e)
        return sumRange(self.root, i, j)

# Your NumArray object will be instantiated and called as such:
if __name__ == '__main__':
    import pdb
    
    obj = NumArray([1,3,5])
    print obj.sumRange(0,2)
    #pdb.set_trace()
    obj.update(1,2)
    print obj.sumRange(0,2)