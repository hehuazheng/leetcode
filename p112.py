# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        '''
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        '''
        if root==None: return False
        def recursive(node, sum):
            if node.left==None and node.right==None:
                return node.val==sum
            if node.left!=None:
                if recursive(node.left, sum-node.val): return True
            if node.right!=None:
                if recursive(node.right,sum-node.val): return True
            return False
        import pdb
        #pdb.set_trace()
        return recursive(root,sum)
        
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
    node33=TreeNode(1)
    node11.left=node21
    node21.left=node31
    node21.right=node32
    node12.left=node22
    node12.right=node23
    node23.right=node33
    root.left=node11
    root.right=node12
    print s.hasPathSum(root,22)
