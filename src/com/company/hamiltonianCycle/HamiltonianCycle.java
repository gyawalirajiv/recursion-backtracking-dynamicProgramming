package com.company.hamiltonianCycle;

public class HamiltonianCycle {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,1,0,0},
                {1,0,1,0,1,0},
                {1,1,1,1,0,1},
                {1,0,1,0,0,1},
                {0,1,0,0,0,1},
                {0,1,1,1,1,1}
        };
        solve(matrix);
    }

    public static void solve(int[][] matrix){
        int[] path = new int[matrix.length];

        if(helperRecursion(1, path, matrix)) {
            printPath(path);
        }
        else System.out.println("No solution!");
    }

    public static boolean helperRecursion(int pos, int[] path, int[][] matrix){
        if(pos >= matrix.length) {
            if(matrix[path[pos-1]][0] == 1) return true;
            else return false;
        }

        for(int i = 1; i < matrix.length; i++){
            if(!isValid(path[pos-1], i, matrix, path, pos)) continue;

            path[pos] = i;
            if(helperRecursion(pos+1, path, matrix)) return true;

            path[pos] = 0;
        }

        return false;
    }

    public static boolean isValid(int prev, int curr, int[][] matrix, int[] path, int pos){
        if(matrix[prev][curr] == 0) return false;

        for(int i = 0; i < pos; i++){
            if(path[i] == curr) return false;
        }

        return true;
    }

    public static void printPath(int[] path){
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.print(path[0] + " ");
    }
}
