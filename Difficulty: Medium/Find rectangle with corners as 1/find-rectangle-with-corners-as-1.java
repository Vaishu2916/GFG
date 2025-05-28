class Solution {
    public boolean ValidCorner(int mat[][]) {
        // Code here
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                for (int k = 0; k < m; k++)
                    if (mat[i][k] == 1 && mat[j][k] == 1 && ++count > 1)
                        return true;
            }
        return false;
    }
}