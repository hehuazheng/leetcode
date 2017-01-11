class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.max=-2147483648
        def recursive(node):
            if node.left==None and node.right==None:
                if node.val > self.max: self.max=node.val
                return node.val
            lsum,rsum=None,None
            if node.left!=None:
                lsum=recursive(node.left)
                if lsum>self.max: self.max=lsum
            if node.right!=None:
                rsum=recursive(node.right)
                if rsum>self.max: self.max=rsum
            if lsum!=None and rsum!=None:
                sum=lsum+rsum+node.val
                if sum>self.max: self.max=sum
            max=node.val
            if lsum!=None and lsum>0: max=node.val+lsum
            if rsum!=None and rsum>0 and node.val+rsum>max: max=node.val+rsum
            if max>self.max: self.max=max
            return max
            
        recursive(root)
        return self.max
        
if __name__ == '__main__':
    s=Solution()
    root=TreeNode(5)
    node11=TreeNode(4)
    node12=TreeNode(8)
    node21=TreeNode(11)
    node22=TreeNode(13)
    node23=TreeNode(4)
    node31=TreeNode(7)
    node32=TreeNode(2)
    node33=TreeNode(5)
    node34=TreeNode(1)
    node11.left=node21
    node21.left=node31
    node21.right=node32
    node12.left=node22
    node12.right=node23
    node23.left=node33
    node23.right=node34
    root.left=node11
    root.right=node12
    print s.maxPathSum(root)
