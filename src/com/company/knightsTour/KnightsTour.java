package com.company.knightsTour;

import java.util.Arrays;

public class KnightsTour {

    public static final int[] xMoves = {2,1,-1,-2,-2,-1,1,2};
    public static final int[] yMoves = {1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) {
        solve(8);
    }

    public static void solve(int size){

        int[][] board = new int[size][size];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], -1);
        }
        board[0][0] = 1;

        if(helperRecursion(2, 0, 0, board)) printBoard(board);
        else System.out.println("No solution found!");
    }

    public static boolean helperRecursion(int step, int row, int col, int[][] board){
        if(step == board.length * board.length + 1) {
            return true;
        }

        for(int i = 0; i < xMoves.length; i++){
            int nextX = row + xMoves[i];
            int nextY = col + yMoves[i];

            if(!isValid(nextX, nextY, board)) continue;
            board[nextX][nextY] = step;
            if(helperRecursion(step+1, nextX, nextY, board)) return true;
            board[nextX][nextY] = -1;
        }

        return false;
    }

    public static boolean isValid(int i, int j, int[][] board){
        if(i < 0 || i >= board.length) return false;
        if(j < 0 || j >= board.length) return false;
        if(board[i][j] != -1) return false;
        return true;
    }

    public static void printBoard(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
