package com.weihua.leetcode;

public class NumberOfIsland {
    public static void main(String[] args) {
        NumberOfIsland islandNumberCounter = new NumberOfIsland();
        char[][] grid = {{'0'}};
        System.out.println(islandNumberCounter.numIslands(grid));
    }
    
    public int numIslands(char[][] grid) {
        if (grid.length==0 || grid[0].length == 0) {
            return 0;
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0' && !visited[i][j]) {
                    visitGraph(i,j, grid, visited);
                    counter++;
                }
            }
        }
        return counter;
    }
    
    private void visitGraph(int i, int j, char[][] grid, boolean[][] visited) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) {
            return;
        }
        if (visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        visitGraph(i+1, j, grid, visited);
        visitGraph(i-1, j, grid, visited);
        visitGraph(i, j+1, grid, visited);
        visitGraph(i, j-1, grid, visited);
    }
}
