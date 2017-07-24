import sys
class TreeNode(object):
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def __init__(self):
        self.max = -1 * sys.maxsize


    def maxPathSum(self,root):
        if(root == None):
            return 0
        self.func(root)
        return self.max
    
    def func(self,root):
        if(root == None):
            return 0
        left = self.func(root.left)
        right = self.func(root.right)
        self.max = max(self.max,root.val,root.val + left,root.val + right,root.val + left + right)
        return max(node.val,root.val + left,root.val + right)
