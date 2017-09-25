public class Solution
{
    public String longestCommonPrefix(String[] mat)
    {
        if(mat == null || mat.length == 0)
            return "";
        return findPrefix(mat);
    }

    public String findPrefix(String[] mat)
    {
        int length = findLength(mat);
        if(length == 0)
            return "";
        else
            return mat[0].substring(0,length);
    }

    public int findLength(String[] mat)
    {
        int length = 0;
        int j = 0;
        int rows = mat.length;
        while(true)
        {
            System.out.println("outside");
            for(int i = 0 ; i < rows ; i++)
            {
                System.out.println("inside");
                if(j >= mat[i].length())
                    return length;
                else if(i == 0)
                    continue;
                else if(mat[i].charAt(j) != mat[i - 1].charAt(j))
                    return length;
            }
            length++;
            j++;
        }
    }
}
