public class D_22_Find_Building_Where_Alice_and_Bob_Can_Meet {
    public static void main(String[] args) {
        // Example heights and queries
        int[] heights = {10, 20, 15, 25, 30};
        int[][] queries = {
            {0, 4},
            {1, 3},
            {2, 2}
        };

        // Call the function and display the results
        Solution solution = new Solution();
        int[] results = solution.leftmostBuildingQueries(heights, queries);
        System.out.println("Results: " + Arrays.toString(results));
    }
}

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int m = queries.length;

        // Ensure each query is in the form [l, r] where l <= r
        for (int i = 0; i < m; ++i) {
            if (queries[i][0] > queries[i][1]) {
                queries[i] = new int[]{queries[i][1], queries[i][0]};
            }
        }

        // Sort queries by the right endpoint in descending order
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[j][1] - queries[i][1]);

        // Clone and sort heights for binary search
        int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);

        int[] results = new int[m];
        int j = n - 1;
        BinaryIndexedTree bit = new BinaryIndexedTree(n);

        for (int i : idx) {
            int l = queries[i][0];
            int r = queries[i][1];

            // Update BIT with heights greater than current right endpoint
            while (j > r) {
                int k = n - Arrays.binarySearch(sortedHeights, heights[j]) + 1;
                bit.update(k, j);
                --j;
            }

            // Determine the result for the current query
            if (l == r || heights[l] < heights[r]) {
                results[i] = r;
            } else {
                int k = n - Arrays.binarySearch(sortedHeights, heights[l]);
                results[i] = bit.query(k);
            }
        }

        return results;
    }
}

class BinaryIndexedTree {
    private final int inf = Integer.MAX_VALUE;
    private int n;
    private int[] tree;

    public BinaryIndexedTree(int n) {
        this.n = n;
        tree = new int[n + 1];
        Arrays.fill(tree, inf);
    }

    public void update(int x, int value) {
        while (x <= n) {
            tree[x] = Math.min(tree[x], value);
            x += x & -x;
        }
    }

    public int query(int x) {
        int minValue = inf;
        while (x > 0) {
            minValue = Math.min(minValue, tree[x]);
            x -= x & -x;
        }
        return minValue == inf ? -1 : minValue;
    }
}
