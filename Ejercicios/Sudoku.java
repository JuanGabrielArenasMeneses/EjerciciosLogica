package Ejercicios;

import java.util.Random;

public class Sudoku {
    
    private static int moves=0;
    private static int flag=0;
    private static int[] box=new int[2];
    private static int[][] board=new int[9][9];

    public static void makeBoard() {
        
        zeros(board);
        printBoard(board);
        while (flag==0) {
            choiceBox(box);
            verified(ramdom(9,1));
            printBoard(board);
            System.out.println(""+moves);
            if(moves>80){
                flag=containsZeros(board);
            }
        }
    }
    private static void verified(int ramdom) {
        if (overBoard (board, box[0], box[1],ramdom)) {
            moves+=1;
        }
    }
    public static boolean overBoard (int[][] board, int iPosition, int jPosition, int n) {
        int iMovCounts=1;
        int jMovCounts=1;
        int boxPosition=ramdom(9,1);
        int[] toSaveElementPosition=new int[2];
        toSaveElementPosition[0]=iPosition;
        toSaveElementPosition[1]=jPosition;
        switch (boxPosition) {
            case 1:
            toSaveElementPosition[0]+=0;
            toSaveElementPosition[1]+=0;
                break;
            case 2:
            toSaveElementPosition[0]+=0;
            toSaveElementPosition[1]+=1;
                break;
            case 3:
            toSaveElementPosition[0]+=0;
            toSaveElementPosition[1]+=2;
                break;
            case 4:
            toSaveElementPosition[0]+=1;
            toSaveElementPosition[1]+=0;
                break;
            case 5:
            toSaveElementPosition[0]+=1;
            toSaveElementPosition[1]+=1;
                break;
            case 6:
            toSaveElementPosition[0]+=1;
            toSaveElementPosition[1]+=2;
                break;
            case 7:
            toSaveElementPosition[0]+=2;
            toSaveElementPosition[1]+=0;
                break;
            case 8:
            toSaveElementPosition[0]+=2;
            toSaveElementPosition[1]+=1;
                break;
            case 9:
            toSaveElementPosition[0]+=2;
            toSaveElementPosition[1]+=2;
                break;
                default:
                break;
        }
        
        if(!overRow (board, toSaveElementPosition[0],n)){
            return false;
        }
        if(!overColumn (board, toSaveElementPosition[1],n)){
            return false;
        }
        while (jMovCounts+ iMovCounts==6) {
            if (jMovCounts==3 && iMovCounts<3) {
                iPosition+=1;
                jPosition=jPosition-2;
                jMovCounts++;
                if(board[iPosition][jPosition]==n){
                    return false;
                }
            }
            jPosition++;
        }
        board[toSaveElementPosition[0]][toSaveElementPosition[1]]=n;
        return true;
    }
    public static boolean overRow (int[][] board, int iPosition, int n) {
        for (int j = 0; j < board[0].length; j++) {
            if(board[iPosition][j]==n){
                return false;
            }
        }
        return true;
    }
    public static boolean overColumn (int[][] board, int jPosition, int n) {
        for (int i = 0; i < board.length; i++) {
            if(board[i][jPosition]==n){
                return false;
            }
        }
        return true;
    }
    private static int containsZeros(int[][] board2) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==0){
                    return 0;
                }
            }
        }
        return 1;
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
        System.out.println("");
        System.out.println("");
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
