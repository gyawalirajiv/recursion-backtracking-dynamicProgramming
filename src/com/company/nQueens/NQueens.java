package com.company.nQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<String>> list = new ArrayList<>();

    public static void main(String[] args) {
        solve(4);
    }

    public static void solve(int n){
        int[][] board = new int[n][n];

        if(helperRecursion(0, 0, board)) {
            printBoard(board);
        } else System.out.println("NOT SOLVED");
    }

    public static boolean helperRecursion(int i, int j, int[][] board){
        if(j >= board.length) return true;

        while(i < board.length){
            if(isValid(i, j, board)) board[i][j] = 1;
            else { i++; continue; }

            if(helperRecursion(0, j+1, board)) return true;
            board[i][j] = 0;

            i++;
        }
        return false;
    }

    public static boolean isValid(int i, int j, int[][] board){
        for(int k = 0; k < j; k++){
            if(board[i][k] == 1) return false;
        }
        for(int k = 0; k < i; k++){
            if(board[k][j] == 1) return false;
        }

        int indexI = i;
        int indexJ = j;
        while(indexI >= 0 && indexJ >= 0){
            if(board[indexI][indexJ] == 1) return false;
            indexI--;
            indexJ--;
        }

        indexI = i;
        indexJ = j;
        while(indexI < board.length && indexJ >= 0){
            if(board[indexI][indexJ] == 1) return false;
            indexI++;
            indexJ--;
        }
        return true;
    }

    public static void printBoard(int[][] board){
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
    }

}
