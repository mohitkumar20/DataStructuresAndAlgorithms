class TreeNode:
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    diameter = 0
    def diameterOfBinaryTree(self,root):
        if(root is None):
            return 0
        self.func(root)
        return self.diameter


    def func(self,root):
        
        if(root is None):
            return 0
        lHeight = self.func(root.left) # left subtree height
        rHeight = self.func(root.right)
        if(lHeight + rHeight > self.diameter):
            self.diameter = lHeight + rHeight
        return max(lHeight,rHeight) + 1
        
