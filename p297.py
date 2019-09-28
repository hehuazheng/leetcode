# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    def serialize(self, root):
        '''Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        '''
        def recur(node, sb):
            if node==None: sb.append('X')
            else:
                sb.append(str(node.val))
                recur(node.left, sb)
                recur(node.right, sb)
        sb=[]
        recur(root, sb)
        return ','.join(sb)
        
    def deserialize(self, data):
        '''Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        '''
        def build_tree(items):
            val=items.pop(0)
            if val=='X':
                return None
            else:
                n=TreeNode(int(val))
                n.left=build_tree(items)
                n.right=build_tree(items)
                return n
        items=data.split(',')
        return build_tree(items)
        
if __name__ == '__main__':
    import pdb
    #pdb.set_trace()
    n1=TreeNode(1)
    n2=TreeNode(2)
    n1.left=n2
    n3=TreeNode(3)
    n1.right=n3
    n4=TreeNode(4)
    n3.left=n4
    n5=TreeNode(5)
    n3.right=n5
    n6=TreeNode(6)
    n2.right=n6
    
    codec = Codec()
    d=codec.serialize(n1)
    tmp=codec.deserialize(d)
    print(tmp)