# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):
        if root==None: return []
        
        def recursive(p, path, res):
            if p.left==None and p.right==None: res.append(path + [p.val])
            if p.left!=None:
                path.append(p.val)
                recursive(p.left, path, res)
                path.pop()
            if p.right!=None:
                path.append(p.val)
                recursive(p.right, path, res)
                path.pop()
        res=[]
        recursive(root, [], res)
        res2=[]
        for x in res:
            res2.append("->".join("{0}".format(c) for c in x))
        return res2
        
if __name__ == '__main__':
    n1=TreeNode(1)
    n2=TreeNode(2)
    n3=TreeNode(3)
    n5=TreeNode(5)
    n1.left=n2
    n1.right=n3
    n2.right=n5
    s=Solution()
    import pdb
    pdb.set_trace()
    print s.binaryTreePaths(n1)
