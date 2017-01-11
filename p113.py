# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if root==None: return []
        def recursive(node, sum, path, validpaths):
            if node.left==None and node.right==None:
                if node.val==sum:
                    validpaths.append(path + [node.val])
            if node.left!=None:
                path.append(node.val)
                recursive(node.left, sum-node.val, path, validpaths)
                path.pop()
            if node.right!=None:
                path.append(node.val)
                recursive(node.right,sum-node.val, path, validpaths)
                path.pop()
        import pdb
        #pdb.set_trace()
        validpaths=[]
        recursive(root,sum, [], validpaths)
        return validpaths
        
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
    print s.pathSum(root,22)
