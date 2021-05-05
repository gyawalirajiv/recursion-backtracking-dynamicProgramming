package com.company.sudokuSolver;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudoku = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(solve(sudoku)) print(sudoku);
        else System.out.println("No Solutions Found!");
    }

    public static boolean solve(int[][] sudoku){
        return backtrack(0, 0, sudoku);
    }

    public static boolean backtrack(int i, int j, int[][] sudoku){
        if(i >= sudoku.length -1 && j == sudoku[0].length - 1) return true;
        if(j == sudoku[0].length) {
            if(backtrack(i+1, 0, sudoku)) return true;
            else return false;
        }

        if(sudoku[i][j] != 0) {
            if(backtrack(i, j+1, sudoku)) return true;
        }
        else {
            for(int num = 1; num <= 9; num++){
                if(!isValid(i, j, num, sudoku)) continue;
                sudoku[i][j] = num;
                if(backtrack(i, j+1, sudoku)) return true;
                sudoku[i][j] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y, int num, int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            if(sudoku[i][y] == num) return false;
        }
        for (int i = 0; i < sudoku[0].length; i++) {
            if(sudoku[x][i] == num) return false;
        }

        int boxSize = sudoku.length / 3;
        int rowOffset = (x / 3) * boxSize;
        int colOffset = (y / 3) * boxSize;
        for(int i = 0; i < boxSize; i++){
            for (int j = 0; j < boxSize; j++) {
                if(sudoku[rowOffset + i][colOffset + j] == num) return false;
            }
        }
        return true;
    }

    private static void print(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
