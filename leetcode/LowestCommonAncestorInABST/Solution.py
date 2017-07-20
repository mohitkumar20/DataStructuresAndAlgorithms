#Definition for a binary tree node

class TreeNode(object):
    def __init(self,x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def lowestCommonAncestor(self,root,p,q):

        if(p.val <= q.val):
            return self.func(root,p,q)
        else:
            return self.func(root,q,p)


        
    def func(self,root,p,q):
        if(root == None):
            return None
        elif(root.val >= p.val and root.val <= q.val):
            return root
        elif(root.val > q.val):
            return self.func(root.left,p,q)
        elif(root.val < p.val):
            return self.func(root.right,p,q)
