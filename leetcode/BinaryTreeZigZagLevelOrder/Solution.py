class TreeNode:
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def zigzagLevelOrder(self,root):
        ans = []
        if(root is None):
            return ans
        st1 = [] # stack 1, we will always pop from this stack
        st2 = [] # stack 2, we will only push in this stack

        st1.append(root)
        level = 0
        while(len(st1) > 0):
            row = []
            size = len(st1)
            while(size):
                curr = st1.pop()
                row.append(curr.val)
                if(level % 2 == 0):
                    if(curr.left is not None):
                        st2.append(curr.left)

                    if(curr.right is not None): 
                        st2.append(curr.right)
                else:
                    if(curr.right is not None):
                        st2.append(curr.right)

                    if(curr.left is not None):
                        st2.append(curr.left)

                size = size - 1
            ans.append(row)
            st1,st2 = st2,st1
            level = level + 1
        return ans
