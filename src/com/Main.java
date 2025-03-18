package com;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Scanner;

class Position{
    public int x;
    public int y;

    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static Scanner scan = new Scanner(System.in);
    static int[][] moves = {{-2,+1},{-1,+2},{+1,+2},{+2,+1},{+2,-1},{+1,-2},{-1,-2},{-2,-1}};
    public static void main(String[] args) {
        System.out.println("Welcome to the knight move calculator.");
        do{
            showKnightMoves();
        }while (getYesOrNo("Do it Again?"));
    }

    public static boolean getYesOrNo(String prompt){
        while (true){
            String ans;
            System.out.println(prompt + " ( Y or N ) ");
            ans = scan.nextLine();
            return ans.equalsIgnoreCase("Y");
        }
    }

    public static void showKnightMoves(){
        int[][] board = new int[8][8];
        String knightSquare;
        Position knightPosition;
        do{
            System.out.print("Enter knight's position: ");
            knightSquare = scan.nextLine();
            knightPosition = convertSquaretoPosition(knightSquare);
        }while (knightPosition == null);
        board[knightPosition.x][knightPosition.y] = 1;
        System.out.println("Knight is at square " + convertPositiontoSquare(knightPosition));
        System.out.println("From here knight can move to : ");
        for(int[] move : moves){
            int x = move[0];
            int y = move[1];
            Position position = calculateNewPosition(knightPosition,x,y);

            if(position != null){
                System.out.print(convertPositiontoSquare(position) + " ");
                board[position.x][position.y] = 2;
            }
        }
        printBoard(board);
    }

    public static void printBoard(int[][] board){
        System.out.println();
        for (int y = 7; y >= 0; y--) {
            for(int x = 0; x < 8; x++){
                if(board[x][y] == 1)
                    System.out.print(" X ");
                else if (board[x][y] == 2)
                    System.out.print(" ? ");
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
    }

    @Contract(pure = true)
    public static @Nullable Position calculateNewPosition(@NotNull Position position, int x, int y){
        if(position.x + x < 0 || position.x + x > 7 || position.y + y < 0 || position.y + y > 7)
            return null;
        return new Position(position.x + x, position.y + y);
    }

    @Contract(pure = true)
    public static @Nullable String convertPositiontoSquare(@NotNull Position position){
        String file = "";
        switch (position.x){
            case 0 -> file = "a";
            case 1 -> file = "b";
            case 2 -> file = "c";
            case 3 -> file = "d";
            case 4 -> file = "e";
            case 5 -> file = "f";
            case 6 -> file = "g";
            case 7 -> file = "h";
        }
        return file + (position.y + 1);
    }

    public static @Nullable Position convertSquaretoPosition(@NotNull String sqaure){
        int x = -1;
        int y = -1;
        char file = sqaure.charAt(0);
        char rank = sqaure.charAt(1);
        switch (file){
            case 'a' -> x = 0;
            case 'b' -> x = 1;
            case 'c' -> x = 2;
            case 'd' -> x = 3;
            case 'e' -> x = 4;
            case 'f' -> x = 5;
            case 'g' -> x = 6;
            case 'h' -> x = 7;
        }
        switch (rank){
            case '1' -> y = 0;
            case '2' -> y = 1;
            case '3' -> y = 2;
            case '4' -> y = 3;
            case '5' -> y = 4;
            case '6' -> y = 5;
            case '7' -> y = 6;
            case '8' -> y = 7;
        }
        if(x == -1 || y == -1)
            return null;
        else
            return new Position(x,y);
    }
}