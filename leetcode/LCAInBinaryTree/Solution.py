# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):

    def __init__(self):
        self.lca = None

    def lowestCommonAncestor(self,root,p,q):

        #return type : TreeNode
        if(root == None):
            return None

        self.func(root,p,q)
        return self.lca

    def func(self,root,p,q):
        
        if(root == None):
            return 0

        elif(root != p and root != q):

            leftSearch = self.func(root.left,p,q)
            if(leftSearch == 2):
                return 2
            rightSearch = self.func(root.right,p,q)
            if(rightSearch == 2):
                return 2

            if(leftSearch == 1 and rightSearch == 1):
                self.lca = root
                return 2
            if(leftSearch == 0 and rightSearch == 0):
                return 0
            return 1

        else:
            leftSearch = self.func(root.left,p,q)
            if(leftSearch == 1):
                self.lca = root
                return 2
            rightSearch = self.func(root.right,p,q)
            if(rightSearch == 1):
                self.lca = root
                return 2
            return 1
