package com.company.coloringProblem;

import java.util.Arrays;

public class ColoringProblem {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,0,1,0},
                {1,0,1,1,0},
                {0,1,0,1,0},
                {1,1,1,0,1},
                {0,0,0,1,0}
        };
        solve(matrix);
    }

    public static void solve(int[][] matrix){

        int[] colors = new int[matrix.length];
        Arrays.fill(colors, -1);
        colors[0] = 0;

        helperRecursion(1, matrix, colors);
        printColors(colors);
    }

    public static boolean helperRecursion(int pos, int[][] matrix, int[] colors){
        if(pos >= matrix.length) return true;

        for(int colorIndex = 0; colorIndex < matrix.length; colorIndex++){
            if(!isValid(colorIndex, pos, matrix, colors)) continue;

            colors[pos] = colorIndex;
            if(helperRecursion(pos+1, matrix, colors)) return true;
            colors[pos] = -1;
        }

        return false;
    }

    public static boolean isValid(int colorIndex, int pos, int[][] matrix, int[] colors){
        for(int i = 0; i < matrix.length; i++){
            if(matrix[pos][i] == 1 && colors[i] == colorIndex) return false;
        }
        return true;
    }

    public static void printColors(int[] colors){
        for (int i = 0; i < colors.length; i++) {
            System.out.println("Index " + i + " has color: " + colors[i]);
        }
    }
}
