package Ejercicios;

import java.util.Random;

public class Sudoku {
    private static int jMovCounts=1;
    private static int iMovCounts=1;
    private static int moves=0;
    private static int flag=0;
    private static int[] box=new int[2];
    private static int[][] board=new int[9][9];

    public static void makeBoard() {
        
        zeros(board);
        printBoard(board);
        choiceBox(box);
        while (flag==0) {
            verified(ramdom(9,1));
            printBoard(board);
            if(moves>80){
                flag=containsZeros(board);
            }
        }
        

    }
    private static void verified(int ramdom) {
        overBoard (board, box[0], box[1],ramdom(9,1));
        overRow (board, box[0], box[1],ramdom(9,1));
        overColumn (board, box[0], box[1],ramdom(9,1));
    }
    private static int containsZeros(int[][] board2) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==0){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static boolean overBoard (int[][] board, int iPosition, int jPosition, int n) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==n){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean overRow (int[][] board, int iPosition, int jPosition, int n) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==n){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean overColumn (int[][] board, int iPosition, int jPosition, int n) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==n){
                    return false;
                }
            }
        }
        return true;
    }
    public static int[][] zeros(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]=0;
            }
        }
        return board;
    }
    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("["+board[i][j]+"]");
            }
            System.out.println("");
        }
    }
    public static int[] choiceBox(int[] box) {
        int n=ramdom(9,1);
        switch (n) {
            case 1:
                box[0]=0;
                box[1]=0;
                break;
            case 2:
                box[0]=0;
                box[1]=3;
                break;
            case 3:
                box[0]=0;
                box[1]=6;
                break;
            case 4:
                box[0]=3;
                box[1]=0;
                break;
            case 5:
                box[0]=3;
                box[1]=3;
                break;
            case 6:
                box[0]=3;
                box[1]=6;
                break;
            case 7:
                box[0]=6;
                box[1]=0;
                break;
            case 8:
                box[0]=6;
                box[1]=3;
                break;
            case 9:
                box[0]=6;
                box[1]=6;
                break;
                default:
                break;
        }
        return box;
    }
    public static int ramdom(int n, int r){
        return (int)(Math.random()*(n-r)+r);
    }
}
