package com.company.mazeProblem;

public class MazeProblem {


    public static void main(String[] args) {
        int maze[][] = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
        };
        int[][] solution = new int[maze.length][maze[0].length];

        if(solve(maze, solution)){
            print(solution);
        }
        else System.out.println("No Solution Found!");
    }

    public static boolean solve(int[][] maze, int[][] solution){
        return backtrack(0, 0, maze, solution);
    }

    public static boolean backtrack(int i, int j, int[][] maze, int[][] solution){
        solution[i][j] = 1;
        if(i >= maze.length-1 && j >= maze[0].length-1) return true;

        if(i < maze.length - 1 && maze[i+1][j] == 1){
            if(backtrack(i+1, j, maze, solution)) return true;
        }

        if(j < maze[0].length - 1 && maze[i][j+1] == 1)
            if(backtrack(i, j+1, maze, solution)) return true;

        solution[i][j] = 0;
        return false;
    }

    public static void print(int[][] solution){
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
