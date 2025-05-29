class Solution {
    class Result {
        int sum, length;
        Result(int sum, int length) {
            this.sum = sum;
            this.length = length;
        }
    }
    public int sumOfLongRootToLeafPath(Node root) {
        Result res = dfs(root);
        return res.sum;
    }

    private Result dfs(Node node) {
        if (node == null)
            return new Result(0, 0);
        
        Result left = dfs(node.left);
        Result right = dfs(node.right);

        if (left.length > right.length)
            return new Result(left.sum + node.data, left.length + 1);
        else if (right.length > left.length)
            return new Result(right.sum + node.data, right.length + 1);
        else
            return new Result(Math.max(left.sum, right.sum) + node.data, left.length + 1);
    }
}