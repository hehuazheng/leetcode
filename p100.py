# Definition for a binary tree node.
class TreeNode(object):
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        if p==None and q!=None: return False
        if p!=None and q==None: return False
        if p==None and q==None: return True
        
        def find_candidates(tree, val, candidates):
            if tree.val == val:
                candidates.append(tree)
            if tree.left != None:
                find_candidates(tree.left, val, candidates)
            if tree.right != None:
                find_candidates(tree.right, val, candidates)
                
        def same_tree(p,q):
            if p==None and q==None: return True
            if p!=None and q==None: return False
            if p==None and q!=None: return False
            return p.val==q.val and same_tree(p.left,q.left) and same_tree(p.right,q.right)
            
        q1=q
        candidates=[]
        find_candidates(q1, p.val, candidates)
        for sq in candidates:
            if same_tree(p,sq):
                return True
        return False
        
if __name__ == '__main__':
    s=Solution()
    tn1 = TreeNode(1)
    tn2 = TreeNode(2)
    print s.isSameTree(tn1,tn2)
    tn2=TreeNode(1)
    print s.isSameTree(tn1,tn2)
    tn2.left=TreeNode(3)
    print s.isSameTree(tn1,tn2)