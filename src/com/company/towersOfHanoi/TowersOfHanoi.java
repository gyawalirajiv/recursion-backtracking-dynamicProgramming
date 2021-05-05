package com.company.towersOfHanoi;

public class TowersOfHanoi {

    public static void main(String[] args) {
        solve(4, 'A', 'B', 'C');
    }

    public static void solve(int disc, char src, char mid, char dest){

        if(disc == 0){
            System.out.println("Place " + disc + " from " + src + " to " + dest);
            return;
        }

        solve(disc - 1, src, dest, mid);
        System.out.println("Place " + disc + " from " + src + " to " + dest);
        solve(disc - 1, mid, src, dest);
    }

}
