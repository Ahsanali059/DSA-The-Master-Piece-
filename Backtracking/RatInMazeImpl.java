package Backtracking;

import java.util.ArrayList;
import java.util.List;

class RatInMaze {
    static int N;

    /* A utility function to print solution matrix sol */
    void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    /* A utility function to print the path */
    void printPath(List<int[]> path) {
        System.out.println("Path taken by the rat:");
        for (int[] position : path) {
            System.out.println("[" + position[0] + ", " + position[1] + "]");
        }
    }

    /**
     * Check if x, y is a valid index for N*N maze
     */
    boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    /**
     * This function solves the Maze problem using Backtracking. It mainly uses
     * solveMazeUtil() to solve the problem. It returns false if no path is
     * possible, otherwise returns true and prints the path in the form of 1s.
     * Please note that there may be more than one solution, this function prints one of the feasible solutions.
     */
    public boolean solveMaze(int maze[][]) {
        int sol[][] = new int[N][N];
        List<int[]> path = new ArrayList<>();
        if (!solveMazeUtil(maze, 0, 0, sol, path)) {
            System.out.println("No solution exists");
            return false;
        }

        printSolution(sol);
        printPath(path);
        return true;
    }

    /**
     * A recursive utility function to solve Maze problem
     */
    boolean solveMazeUtil(int maze[][], int x, int y, int sol[][], List<int[]> path) {
        // If (x, y) is the destination, return true
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            path.add(new int[]{x, y});
            return true;
        }

        // Check if maze[x][y] is a valid move
        if (isSafe(maze, x, y)) {
            // Mark x, y as part of the solution path
            sol[x][y] = 1;
            path.add(new int[]{x, y});

            // Move forward in x direction
            if (solveMazeUtil(maze, x + 1, y, sol, path))
                return true;

            // If moving in x direction doesn't give solution then move down in y direction
            if (solveMazeUtil(maze, x, y + 1, sol, path))
                return true;

            // If moving in y direction doesn't give solution then move up in x direction
            if (solveMazeUtil(maze, x - 1, y, sol, path))
                return true;

            // If moving in x direction doesn't give solution then move left in y direction
            if (solveMazeUtil(maze, x, y - 1, sol, path))
                return true;

            // If none of the above movements work then BACKTRACK: unmark x, y as part of solution path
            sol[x][y] = 0;
            path.remove(path.size() - 1);
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        RatInMaze rat = new RatInMaze();
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 0, 0, 1 },
                { 0, 0, 0, 0 },
                { 1, 1, 1, 1 }
        };

        N = maze.length;
        rat.solveMaze(maze);
    }
}
