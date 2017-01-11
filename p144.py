# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root==None: return []
        stack=[root]
        res=[]
        i=0
        while len(stack)>0:
            top=stack.pop()
            if top.left==None and top.right==None: continue
            while top!=None:
                res.append(top.left.val)
                if top.left!=None:
                    stack.append(top.left)
                    top = top.left
            elif top.right!=None:
                res.append(top.right.val)
                stack.append(top.right)
        return res
        
if __name__ == '__main__':
    n1=TreeNode(1)
    n2=TreeNode(4)
    n3=TreeNode(3)
    n4=TreeNode(2)
    n1.left=n2
    n1.right=n3
    n2.left=n4
    s=Solution()
    import pdb
    pdb.set_trace()
    print s.preorderTraversal(n1)
